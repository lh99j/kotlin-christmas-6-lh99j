package christmas.controller

import christmas.model.*
import christmas.model.Order
import christmas.model.data.Menu
import christmas.model.data.OrderForm
import christmas.model.discount.*
import christmas.view.InputView
import christmas.view.OutputView
import java.lang.IllegalArgumentException

class MainController(private val inputView: InputView, private val outputView: OutputView) {
    private val menuBoard = MenuBoard()
    private val benefits = Benefits()
    private val order: Order
    private val date: Int

    init {
        date = readTodayDate()
        order = getOrderMenu()
    }

    fun run() {
        displayOrderInformation()
        applyBenefits()
        displayBenefitsInformation()
        displayFinalPurchasePrice()
        displayBadgeType()
    }

    private fun readTodayDate(): Int {
        outputView.printGreetings()
        while (true) {
            try {
                return inputView.readDate()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getOrderMenu(): Order {
        while (true) {
            try {
                val inputMenu = inputView.readOrder()
                return makeOrder(inputMenu)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun makeOrder(inputMenu: List<String>): Order {
        val result: MutableList<MutableList<OrderForm>> = MutableList(FOOD_CATEGORY_SIZE) { mutableListOf() }

        inputMenu.forEach {
            val (name, count) = it.split("-")
            menuBoard.validateMenu(name)
            val price = menuBoard.getMenuPrice(name)
            val category = menuBoard.getFoodCategory(name)
            result[category].add(OrderForm(Menu(name, price), count.toInt()))
        }

        return Order(result)
    }

    private fun displayOrderInformation() {
        outputView.printPreviewMessage(date)
        outputView.printMenu(order)
        outputView.printTotalPrice(order)
    }

    private fun displayBenefitsInformation() {
        outputView.printGift(order)
        outputView.printBenefits(benefits)
        outputView.printTotalBenefits(benefits)
    }

    private fun displayFinalPurchasePrice() {
        val finalPrice = getPriceAfterDiscount()
        outputView.printPriceAfterDiscount(finalPrice)
    }

    private fun displayBadgeType() {
        val totalBenefits = benefits.getTotalBenefit()
        outputView.printBadgeType(Badge.getType(totalBenefits))
    }

    private fun getPriceAfterDiscount(): Int =
        order.getTotalPrice() - benefits.getTotalDiscount()

    private fun applyBenefits() {
        if (order.getTotalPrice() >= DISCOUNT_MIN_PRICE) {
            calculateDiscount()
        }
    }

    private fun calculateDiscount() {
        addBenefits(DDayDiscount(date), DDAY_DISCOUNT)
        addBenefits(WeekdayDiscount(order, date), WEEKDAY_DISCOUNT)
        addBenefits(WeekendDiscount(order, date), WEEKEND_DISCOUNT)
        addBenefits(SpecialDiscount(date), SPECIAL_DISCOUNT)
        addBenefits(GiftDiscount(order), GIFT_DISCOUNT)
    }

    private fun addBenefits(discount: Discount, discountType: String) {
        val valid = discount.checkTarget()
        if (valid) {
            val price = discount.getPrice()
            benefits.addHistory(discountType, price)
        }
    }

    companion object {
        private const val DDAY_DISCOUNT = "크리스마스 디데이 할인"
        private const val WEEKDAY_DISCOUNT = "평일 할인"
        private const val WEEKEND_DISCOUNT = "주말 할인"
        private const val SPECIAL_DISCOUNT = "특별 할인"
        private const val GIFT_DISCOUNT = "증정 이벤트"
        const val DISCOUNT_MIN_PRICE = 10_000
        const val FOOD_CATEGORY_SIZE = 4
    }
}