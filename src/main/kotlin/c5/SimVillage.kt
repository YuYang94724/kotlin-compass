package c5

import kotlin.random.Random

fun main() {
    val numLetters = "Mississippi".count { it == 's' }
    println("numLetters = $numLetters")
    //5-1匿名寒士
    println({
        val currentYear = 2023
        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
    }())
    val greetingFunction: () -> String = {
        val currentYear = 2023
        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
    }
    val greetingFunction2 = {
        val currentYear = 2023
        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
    }
    val greetingFunction3: (currentYear: Int) -> String = {
        "Welcome to SimVillage, Mayor! (copyright $it) "
    }
    val greetingFunction4: (Int, String, Int) -> String = { currentYear, name, numBuildings ->
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $name! (copyright $currentYear)"
    }
//    println(greetingFunction4(2023, "Guyal", 2))
    val printConstructionCost: (Int) -> Unit = { it->
        val cost = 500
        println("construction cost: ${cost * it}")
    }
    //呼叫fun當參數
    runSimulation("Guyal", greetingFunction4, ::printConstructionCost)
    //呼叫變數當參數
    runSimulation("Guyal", greetingFunction4, printConstructionCost)
    //呼叫lambda直接寫方法
    runSimulation("Guyal", greetingFunction4) {
        val cost = 500
        println("construction cost: ${cost * it}")
    }
    println("=========================================")
    runSimulation()
}

inline fun runSimulation(playerName: String, greetingFunction: (Int, String, Int) -> String, costPrint: (Int) -> Unit) {
    val numBuildings = (1..3).shuffled().last() // Randomly selects 1, 2, or 3
//    val numBuildings = Random.nextInt(1, 4) // Randomly selects 1, 2, or 3
    costPrint(5)
    println(greetingFunction(2023, playerName, numBuildings))
}

fun runSimulation() {
    val greetingFunction = configureGreetingFunction(numBuildings = 5, structureType = "hospitals")
    println(greetingFunction("Guyal"))
    println(greetingFunction("Guyal"))
}

fun printConstructionCost(numBuildings: Int){
    val cost = 500
    return  println("construction cost: ${cost * numBuildings}")
}

fun configureGreetingFunction(structureType: String, numBuildings: Int): (String) -> String {
//    val structureType = "hospitals"
    var numBuildings = numBuildings
    return { playerName: String ->
        val currentYear = 2023
        numBuildings += 1
        printConstructionCost(5)
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}