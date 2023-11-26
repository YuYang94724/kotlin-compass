package c3

import kotlin.math.pow
import kotlin.random.Random

fun main() {
    val name = "Madrigal"
    val healthPoints = 100
    val isBlessed = true
    val isImmortal = false
    val karma = (Math.random().pow((110 - healthPoints) / 100.0) * 20).toInt()
    println("karma is $karma")
//    val karma = (Math.pow(Math.random(), (110 - healthPoint) / 100.0) * 20).toInt()
    val auraColor = when (karma) {
        in 0..5 -> "red"
        in 6..10 -> "orange"
        in 11..15 -> "purple"
        in 16..20 -> "green"
        else -> "black"
    }
//    healthStatus
    val healthStatus = when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 89 downTo 75 ->
            if (isBlessed) {
                "has some minor wounds but is healing quite quickly!"
            } else {
                "has some minor wounds."
            }

        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }
// Player status
    println("(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "YES" else "NO" })")
    println("$name $healthStatus")

    //format
    val statusFormatString = "(HP: $healthPoints)(Aura: $auraColor) -> $healthStatus"
    println(statusFormatString)

    pracPrint(name)
}

private fun pracPrint(name: String) {
    //4.15
    val castFireballCount = castFireball()
    println(castFireballCount)
    //4.16
    val status = when (castFireballCount) {
        in 1..10 -> "tipsy"
        in 11..20 -> "sloshed"
        in 21..30 -> "soused"
        in 31..40 -> "stewed"
        in 41..50 ->"..t0aSt3d"
        else -> "error!"
    }
    println("$name drink $castFireballCount Fireballs and getting $status")
}

private fun castFireball()= Random.nextInt(1, 51) // 1 is inclusive, 51 is exclusive