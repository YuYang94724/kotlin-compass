package c11

import c10.*
import java.io.File

//var uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")
//val patronGold = mapOf("Eli" to 10.5, "Mordoc" to 8.0, "Sophie" to 5.5)
//val patronGold = mapOf(Pair("Eli", 10.75),
//    Pair("Mordoc", 8.00),
//    Pair("Sophie", 5.50))
val patronGold = mutableMapOf<String, Double>()
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
fun main() {
    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }
//    println(uniquePatrons)
    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }
    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(),
            menuList.shuffled().first())
        orderCount++
    }
    displayPatronBalances()
//    println(patronGold)
//    println(patronGold["Eli"])
//    println(patronGold["Mordoc"])
//    println(patronGold["Sophie"])
//    println(patronGold.getOrElse("Reggie"){"No such patron"})
//    println(patronGold.getOrDefault("Reginald", 0.0))
}

fun displayPatronBalances() {
    patronGold.forEach { (patron, balance) ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}
fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    if (totalPurse - price >= 0.0) {
        patronGold[patronName] = totalPurse - price
    }else{
        println("Insufficient funds for $patronName to purchase for $price")
    }
}

