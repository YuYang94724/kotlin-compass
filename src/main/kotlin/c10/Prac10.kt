package c10

val len = 34
var typeSet = mutableSetOf<String>()
var printList = mutableListOf<String>()
fun main() {
    //10.11
    println("*** Welcome to Taernyl's Folly ***\n")
    menuList.forEach {
        val drinkName = it.split(",")[1]
        val price = it.split(",")[2].toDouble()
        val dotLen = 34 - drinkName.length - price.toString().length
        println(drinkName + ".".repeat(dotLen) + price)
    }
    //10.12
    println("\n====================================\n")
    println("*** Welcome to Taernyl's Folly ***")

//    val drinkMap = menuList.map { it.split(",") }
//        .groupBy({ it.first() }, { it[1] to it[2].toDouble() })
//    drinkMap.keys.forEach { drinkType ->
//        val typeLen = (len - 4 - drinkType.length) / 2
//        printList.add("${" ".repeat(typeLen)}~[$drinkType]~${" ".repeat(typeLen)}\n")
//
//        drinkMap[drinkType]?.forEach { (drinkName, price) ->
//            val dotLen = 34 - drinkName.length - price.toString().length
//            val content = "${printList.last()}$drinkName${".".repeat(dotLen)}$price\n"
//            printList[printList.lastIndex] = content
//        }
//    }
    menuList.forEach {
        val drinkArray = it.split(",")
        val drinkType = drinkArray.first()
        typeSet.add(drinkType)
    }
    typeSet.forEach {
        val typeLen = (len - 4 - it.length) / 2
        printList.add("${" ".repeat(typeLen)}~[$it]~${" ".repeat(typeLen)}\n")
    }
    menuList.forEach {
        val drinkArray = it.split(",")
        val drinkName = drinkArray[1]
        val price = drinkArray[2].toDouble()
        val dotLen = 34 - drinkName.length - price.toString().length
        printList.forEachIndexed { index, it ->
            if (it.contains(drinkArray.first())) {
                val content= it+drinkName + ".".repeat(dotLen) + price+"\n"
                printList[index] = content
            }
        }
    }
    printList.forEach(::print)
}