package c10

import c7.placeOrder
import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"
var playerGold = 10
var playerSilver = 10
var patronList = mutableListOf("Eli", "Mordoc", "Sophie")
//讀取外部文字黨
val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")
fun main() {
    placeOrder("shandy,Dragon's Breath,5.91")
    println(patronList)
    val fifthPatronNull = patronList.getOrNull(4) ?: "Unknown Patron"
    println(fifthPatronNull)
    val fifthPatronElse = patronList.getOrElse(4) { "Unknown Patron" }
    println(fifthPatronElse)
    //找一個
    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards.")
    } else {
        println("The tavern master says: Eli isn't here.")
    }
    //找多個
    if (patronList.containsAll(setOf("Sophie", "Mordoc"))) {//list or set看起來都可以
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    } else {
        println("The tavern master says: Nay, they departed hours ago.")
    }
    //刪除及新增
    println(patronList)
    patronList.remove("Eli")
    //patronList.add("Alex")
    patronList += "Alex"
    patronList.add(0, "Alex")
    patronList[0] = "Alexis"
    println(patronList)
//    patronList.removeIf { it.length < 5 }
//    println(patronList)
    //forEach
    patronList.forEach {
        println("Hello $it!")
    }
    //for in
    for (patron in patronList) {
        println("Good evening, $patron")
    }
    //forEach index
    patronList.forEachIndexed { index, patron ->
        println("Good evening, $patron - you're #${index + 1} in line.")
        placeOrder(patron, menuList.shuffled().first())
    }
    menuList.forEachIndexed { index, data ->
        println("$index : $data")
    }
    println(patronList)
    val (goldMedal, _,_, bronzeMedal) = patronList
    println("goldMedal =  $goldMedal, bronzeMedal = $bronzeMedal")
}
fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    println("$patronName speaks with $tavernMaster about their order.")
    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price."
    println(message)
// performPurchase(price.toDouble()) performPurchase(price.toDouble())
    val phrase = if (name == "Dragon's Breath") {
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "Madrigal says: Thanks for the $name."
        "$patronName says: Thanks for the $name."
    }
    println(phrase)
}

private fun toDragonSpeak(phrase: String): String {
    return phrase.map {
        when (it.lowercaseChar()) {
            'a' -> "4"
            'e' -> "3"
            'i' -> "1"
            'o' -> "0"
            'u' -> "|_|"
            else -> it.toString()
        }
    }.joinToString("")
}