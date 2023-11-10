package christmas.model

class Order {
    private var _menu = mutableListOf<Menu>()
    val menu: List<Menu>
        get() = _menu

    fun getTotalPrice(): Int = _menu.sumOf { it.price }

    fun addMenu(menu: Menu) = _menu.add(menu)

}