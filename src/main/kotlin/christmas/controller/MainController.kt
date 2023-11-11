package christmas.controller

import christmas.model.Benefits
import christmas.model.Menu
import christmas.model.MenuBoard
import christmas.model.Order
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
    private lateinit var order: Order
    private val benefits = Benefits()
    var date = 0

    fun run() {
        date = readTodayDate()

        val orders = getOrderMenu()
        order = Order(orders)
        printOrder()

        outputView.printGift(order)
        calculateDiscount()
        outputView.printBenefits(benefits)
        outputView.printTotalBenefits(benefits)
        val finalPrice = getPriceAfterDiscount()
        outputView.printPriceAfterDiscount(finalPrice)
    }

    private fun splitInputMenu(inputMenu: List<String>): List<Map<Menu, Int>> {
        val result: MutableList<MutableMap<Menu, Int>> = MutableList(4) { mutableMapOf() }

        inputMenu.forEach {
            val (name, count) = it.split("-")
            menuBoard.validateMenu(name)
            val price = menuBoard.getMenuPrice(name)
            val category = menuBoard.getFoodCategory(name)
            result[category][Menu(name, price)] = count.toInt()
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

    private fun getOrderMenu(): List<Map<Menu, Int>> {
        while (true) {
            try {
                val inputMenu = inputView.readOrder()
                return splitInputMenu(inputMenu)
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
            calculateDDayDiscount()
            calculateWeekdayDiscount()
            calculateWeekendDiscount()
            calculateSpecialDiscount()
            calculateGiftDiscount()
        }
    }

    private fun calculateDDayDiscount() {
        val dDayDiscount = DDayDiscount(date)
        val valid = dDayDiscount.checkTarget()
        if (valid) {
            val price = dDayDiscount.getPrice()
            benefits.addHistory(DDAY_DISCOUNT, price)
        }
    }

    private fun calculateWeekdayDiscount() {
        val weekdayDiscount = WeekdayDiscount(order, date)
        val valid = weekdayDiscount.checkTarget()
        if (valid) {
            val price = weekdayDiscount.getPrice()
            benefits.addHistory(WEEKDAY_DISCOUNT, price)
        }
    }

    private fun calculateWeekendDiscount() {
        val weekendDiscount = WeekendDiscount(order, date)
        val valid = weekendDiscount.checkTarget()
        if (valid) {
            val price = weekendDiscount.getPrice()
            benefits.addHistory(WEEKEND_DISCOUNT, price)
        }
    }

    private fun calculateSpecialDiscount() {
        val specialDiscount = SpecialDiscount(date)
        val valid = specialDiscount.checkTarget()
        if (valid) {
            val price = specialDiscount.getPrice()
            benefits.addHistory(SPECIAL_DISCOUNT, price)
        }
    }

    private fun calculateGiftDiscount() {
        val giftDiscount = GiftDiscount(order)
        val valid = giftDiscount.checkTarget()
        if (valid) {
            val price = giftDiscount.getPrice()
            benefits.addHistory(GIFT_DISCOUNT, price)
        }
    }

    private fun getPriceAfterDiscount(): Int =
        order.getTotalPrice() - benefits.getTotalDiscount()

}