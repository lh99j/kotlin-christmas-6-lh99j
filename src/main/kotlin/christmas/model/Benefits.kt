package christmas.model

class Benefits {
    private var history = MutableList(5) { 0 }

    fun addHistory(benefits: Int, price: Int) {
        history[benefits] += price
    }
}