package christmas.controller

import christmas.model.*
import christmas.model.discount.*
import christmas.util.Constants.DDAY_DISCOUNT
import christmas.util.Constants.DISCOUNT_MIN_PRICE
import christmas.util.Constants.GIFT_DISCOUNT
import christmas.util.Constants.SPECIAL_DISCOUNT
import christmas.util.Constants.WEEKDAY_DISCOUNT
import christmas.util.Constants.WEEKEND_DISCOUNT
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
        printOrder()

        outputView.printGift(order)
        calculateDiscount()
        outputView.printBenefits(benefits)
        outputView.printTotalBenefits(benefits)

        val finalPrice = getPriceAfterDiscount()
        outputView.printPriceAfterDiscount(finalPrice)

        val totalBenefits = benefits.getTotalBenefit()
        outputView.printBadgeType(Badge.getType(totalBenefits))
    }

    private fun splitInputMenu(inputMenu: List<String>): List<List<OrderForm>> {
        val result: MutableList<MutableList<OrderForm>> = MutableList(4) { mutableListOf() }

        inputMenu.forEach {
            val (name, count) = it.split("-")
            menuBoard.validateMenu(name)
            val price = menuBoard.getMenuPrice(name)
            val category = menuBoard.getFoodCategory(name)
            result[category].add(OrderForm(Menu(name, price), count.toInt()))
        }

        return result
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
                val splitMenu = splitInputMenu(inputMenu)
                return Order(splitMenu)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun printOrder() {
        outputView.printPreviewMessage(date)
        outputView.printMenu(order)
        outputView.printTotalPrice(order)
    }

    private fun calculateDiscount() {
        if (order.getTotalPrice() >= DISCOUNT_MIN_PRICE) {
            calculateDiscount(DDayDiscount(date), DDAY_DISCOUNT)
            calculateDiscount(WeekdayDiscount(order, date), WEEKDAY_DISCOUNT)
            calculateDiscount(WeekendDiscount(order, date), WEEKEND_DISCOUNT)
            calculateDiscount(SpecialDiscount(date), SPECIAL_DISCOUNT)
            calculateDiscount(GiftDiscount(order), GIFT_DISCOUNT)
        }
    }

    private fun calculateDiscount(discount: Discount, discountType: String) {
        val valid = discount.checkTarget()
        if (valid) {
            val price = discount.getPrice()
            benefits.addHistory(discountType, price)
        }
    }

    private fun getPriceAfterDiscount(): Int =
        order.getTotalPrice() - benefits.getTotalDiscount()

}