fun main(args: Array<String>) {
    val input = "HELLO WORLD"
    val dragonSpeak = toDragonSpeak(input)
    println("Input: $input")
    println("Dragon Speak: $dragonSpeak")
}





private fun toDragonSpeak(phrase: String): String {
    val lowerPhrase = phrase.lowercase() // 统一转换为小写
    return lowerPhrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }.mapIndexed { index, char ->
        if (phrase[index].isUpperCase()) char.uppercase() else char.toString()
    }.joinToString("")
}
