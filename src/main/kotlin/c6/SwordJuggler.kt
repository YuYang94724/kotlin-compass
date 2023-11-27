package c6

fun main() {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }
    try {
        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)
    } catch (e: Exception) {
        println(e)
    }
    println("You juggle $swordsJuggling swords!")
}

class UnskilledSwordJugglerException: IllegalStateException("Player cannot juggle swords")

fun proficiencyCheck(swordsJuggling: Int?) {
//    swordsJuggling ?: throw IllegalStateException("Player cannot juggle swords")
//    swordsJuggling ?: throw UnskilledSwordJugglerException()
    checkNotNull(swordsJuggling, { "Player cannot juggle swords" })
}
/**
 * checkNotNull 如果参数值为 null，则抛出 IllegalStateException 异常，否则返回非 null 值
 * require 如果参数值为 false，则抛出 IllegalArgumentException 异常
 * requireNotNull 如果参数值为 null，则抛出 IllegalStateException 异常，否则返回非 null 值
 * error 如果参数值为 null，则抛出 IllegalStateException 异常并输出错误信息，否则返回非 null 值
 * assert 如果参数值为 false，则抛出 AssertionError 异常，并打上断言编译器标记 a
 */
fun juggleSwords(swordsJuggling: Int) {
    require(swordsJuggling >= 3, { "Juggle at least 3 swords to be exciting." })
    // Juggle
}