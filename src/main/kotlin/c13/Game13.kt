package c13


fun main() {
//    val player = Player("Madrigal", 89, true, false)
    val player = Player("Madrigal")
    val kar = Player("Kar")
    println(kar.healthPoints)
    println(kar.name)
    //lateinit test
    player.determineFate()
    player.proclaimFate()
    //fireball test
    player.castFireball()
    //Aura
    val auraColor = player.auraColor()
    //player status
    printPlayerStatus(player)
    //weapon
    player.printWeaponName()
}

fun printPlayerStatus(player: Player) {
    println(
        "(Aura: ${player.auraColor()}) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
    )
    println("${player.name} ${player.formatHealthStatus()}")
}