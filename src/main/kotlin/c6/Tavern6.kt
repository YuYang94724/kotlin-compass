package c6

fun main() {
//    var beverage = readLine()?.takeIf { it.isNotBlank() }?.replaceFirstChar { it.uppercaseChar() } ?: "Buttered Ale"
    var beverage = readLine()
    beverage = null
    f(beverage)
    f1(beverage)
    f2(beverage)
    f3(beverage)
}

fun f3(beverage: String?) {
    var updatedBeverage = beverage
    updatedBeverage?.let { updatedBeverage = it.replaceFirstChar { it.uppercaseChar() } }
        ?: println("f3 I can't do that without crashing - beverage was null!")
    println("f3 $updatedBeverage")
}

fun f(beverage: String?) {
    var updateBeverage = beverage?.let {
        if (it.isNotBlank()) {
            it.replaceFirstChar { it.uppercaseChar() }
        } else {
            "f Buttered Ale"
        }
    }
    println("f $updateBeverage")
}

fun f1(beverage: String?) {
    val updatedBeverage: String?
    if (beverage != null) {
        updatedBeverage = beverage.replaceFirstChar { it.uppercaseChar() }
        println(updatedBeverage)
    } else {
        println("f1 I can't do that without crashing - beverage was null!")
    }
}

fun f2(beverage: String?) {
    val beverageServed: String = beverage ?: "Buttered Ale"
    println("f2 $beverageServed")
}