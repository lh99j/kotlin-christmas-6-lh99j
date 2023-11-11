package christmas.model

class Benefits {
    private var _history = mutableMapOf<String, Int>()
    val history: Map<String, Int>
        get() = _history

    fun addHistory(type: String, price: Int) {
        _history[type] = _history.getOrDefault(type, 0) + price
    }
}