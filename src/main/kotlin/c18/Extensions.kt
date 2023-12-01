package c18

import c14.Room
import c16.Goblin

fun <T> Iterable<T>.random(): T = this.shuffled().first()
fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

fun <T> T.easyPrint() : T {
    println(this)
    return this
}

val String.numVowels
    get() = count { "aeiouy".contains(it) }
infix fun String?.printWithDefault(default: String) = println(this ?: default)


fun Room.configurePitGoblin(block: Room.(Goblin) -> Goblin): Room {
    val goblin = block(Goblin("Pit Goblin", description = "An Evil Pit Goblin"))
    monster = goblin
    return this
}



fun main() {
    //鏈式去調用自己擴展的函數 使用generic型態參數去擴展讓任何類型都可以呼叫並回傳自己
    "Madrigal has left the building".easyPrint().addEnthusiasm().easyPrint()
    42.easyPrint()
    "How many vowels?".numVowels.easyPrint()

    val nullableString: String? = null
    nullableString.printWithDefault("Default")
    nullableString printWithDefault "Default string"

    frame("Welcome, Madrigal", 5, "@").easyPrint()
    "#".padEnd(3).plus("123").plus("#".padStart(3)).easyPrint()
    println("Welcome, Madrigal".cool(5))
    //回纏呼叫方法的新元素隊伍
    val i = (0..4).onEach {
        println("2")
        val nL = listOf(it+it)
        println(nL)
    }
    (0..4).forEach { println("3") }
    println(i)
}

fun frame(name: String, padding: Int, formatChar: String = "*"): String {
    val greeting = "$name!"
    val middle = formatChar.padEnd(padding)
        .plus(greeting)
        .plus(formatChar.padStart(padding))
    val end = (0 until middle.length).joinToString("") { formatChar }
    return "$end\n$middle\n$end"
}
//取名frame會衝突
fun String.cool(times: Int, formatChar: String = "*") :String {
    val greeting = "$this!"
    val  middle = formatChar.padEnd(times)
        .plus(greeting)
        .plus(formatChar.padStart(times))
    val end = (0 until middle.length).joinToString("") { formatChar }
    return "$end\n$middle\n$end"
}