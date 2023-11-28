package c7

import java.util.*

const val TAVERN_NAME = "Taernyl's Folly"
fun main() {
    placeOrder("shandy,Dragon's Breath,5.91")
    placeOrder("elixir,Shirley's Temple,4.12")
}


//    private fun toDragonSpeak(phrase: String) =
//    phrase.lowercase(Locale.getDefault()).replace(Regex("[aeiou]")) {
//        when (it.value) {
//            "a" -> "4"
//            "e" -> "3"
//            "i" -> "1"
//            "o" -> "0"
//            "u" -> "|_|"
//            else -> it.value
//        }
//    }

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

//private fun toDragonSpeak(phrase: String): String{
//    val myFun = test(Regex("[aeiou]"))
//    return myFun(phrase)
//}
//private fun test(regex: Regex): (String) -> String {
//    return { regexString ->
//        regexString.map  {
//            when (it.lowercaseChar()) {
//                'a' -> "4"
//                'e' -> "3"
//                'i' -> "1"
//                'o' -> "0"
//                'u' -> "|_|"
//                else -> it.toString()
//            }
//        }.joinToString("")
//    }
//}
//private fun test(regex: Regex): (String) -> String {
//    return { regexString ->
//        regexString.replace(regex) {
//            when (it.value) {
//                "a" -> "4"
//                "e" -> "3"
//                "i" -> "1"
//                "o" -> "0"
//                "u" -> "|_|"
//                else -> it.value
//            }
//        }
//    }
//}


public fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

//    val data = menuData.split(',')
//    val type = data[0]
//    val name = data[1]
//    val price = data[2]
    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)

    val phrase = if (name == "Dragon's Breath") {
        "Madrigal exclaims ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "Madrigal says: Thanks for the $name."
    }
//    println(phrase)
    println(toDragonSpeak("DRAGON'S BREATH: IT'S GOT WHAT ADVENTURERS CRAVE!"))
}
