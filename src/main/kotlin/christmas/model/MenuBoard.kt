package christmas.model

import christmas.model.data.Menu
import christmas.util.validator.OrderValidator.validateMenuName

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

    fun validateMenu(name: String) = validateMenuName(foods, name)


    fun getMenuPrice(name: String): Int =
        foods.flatten().first { menu -> menu.name == name }.price


    fun getFoodCategory(name: String): Int {
        return foods.indexOfFirst { menu ->
            menu.any {
                name == it.name
            }
        }
    }
}