package christmas.model

import christmas.model.data.Menu
import christmas.util.Constants.APPETIZER_INDEX
import christmas.util.Constants.DESSERT_INDEX
import christmas.util.Constants.DRINK_INDEX
import christmas.util.Constants.MAIN_FOOD_INDEX
import christmas.util.Validator.validateMenuName

class MenuBoard {
    private val foods: List<List<Menu>>

    init {
        val appetizer = listOf(
            Menu("양송이수프", 6_000),
            Menu("타파스", 5_500),
            Menu("시저샐러드", 8_000)
        )

        val mainFood = listOf(
            Menu("티본스테이크", 55_000),
            Menu("바비큐립", 54_000),
            Menu("해산물파스타", 35_000),
            Menu("크리스마스파스타", 25_000)
        )

        val dessert = listOf(
            Menu("초코케이크", 15_000),
            Menu("아이스크림", 5_000)
        )

        val drink = listOf(
            Menu("제로콜라", 3_000),
            Menu("레드와인", 60_000),
            Menu("샴페인", 25_000)
        )

        foods = listOf(appetizer, mainFood, dessert, drink)
    }

    fun validateMenu(name: String) {
        validateMenuName(foods, name)
    }

    fun getMenuPrice(name: String): Int {
        return foods.flatten().find { menu -> menu.name == name }!!.price
    }

    fun getFoodCategory(name: String): Int {
        val appetizer = isAppetizer(name)
        val mainFood = isMainFood(name)
        val dessert = isDessert(name)
        val drink = isDrink(name)
        val trueValues = listOf(appetizer, mainFood, dessert, drink).indexOfFirst { it }
        return trueValues
    }

    private fun isAppetizer(name: String): Boolean {
        return foods[APPETIZER_INDEX].any { menu ->
            menu.name == name
        }
    }

    private fun isMainFood(name: String): Boolean {
        return foods[MAIN_FOOD_INDEX].any { menu ->
            menu.name == name
        }
    }

    private fun isDessert(name: String): Boolean {
        return foods[DESSERT_INDEX].any { menu ->
            menu.name == name
        }
    }

    private fun isDrink(name: String): Boolean {
        return foods[DRINK_INDEX].any { menu ->
            menu.name == name
        }
    }
}