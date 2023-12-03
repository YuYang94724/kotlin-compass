package c11

import c10.*
import c18.random as random18
import java.io.File

//var uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")

val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val uniquePatrons: Set<String> = generateSequence {
    val first = patronList.random()
    val last = lastName.random()
    "$first $last"
}.distinct().take(9).toSet()

var patronGold = uniquePatrons.map { Pair(it, 6.0) }.toMap().toMutableMap()
fun main() {
//    (0..9).forEach {
//        val first = patronList.random18()
//        val last = lastName.random18()
//        val name = "$first $last"
//        uniquePatrons += name
//    }
    println("size = ${uniquePatrons.size} , $uniquePatrons")
    println("size = ${patronGold.size} , $patronGold")
//    uniquePatrons.forEach {
//        patronGold[it] = 6.0
//    }
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

