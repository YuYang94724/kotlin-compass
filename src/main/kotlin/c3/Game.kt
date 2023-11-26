package c3

fun main(args: Array<String>) {
    val name = "Madrigal"
    val healthPoints = 89
    val isBlessed = true
    val isImmortal = false
    //Aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    printPlayerStatus(auraColor, isBlessed, name, healthStatus)
    printPlayerStatus(
        isBlessed = true,
        auraColor = "NONE",
        name = "ABC",
        healthStatus = formatHealthStatus(healthPoints = 92, isBlessed = false)
    )
    castFireball()
    shouldReturnAString()
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println(
        "(Aura: $auraColor) " +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    )
    println("$name $healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean) =
     if ((isBlessed && healthPoints > 50) || isImmortal) "GREEN" else "NONE"



private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String =
    when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
//        in 75..89 ->
        in 89 downTo 75 ->
            if (isBlessed) {
                "has some minor wounds but is healing quite quickly!"
            } else {
                "has some minor wounds."
            }

        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }


private fun castFireball(numFireballs: Int = 2) =
    println("A glass of Fireball springs into existence. (x$numFireballs)")

private fun shouldReturnAString(){
    //不知道邏輯要寫啥先給他的TODO
    TODO("implement the string building functionality here to return a string")
}