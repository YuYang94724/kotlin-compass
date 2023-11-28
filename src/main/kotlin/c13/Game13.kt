package c13


fun main() {
    val player = Player("Madrigal", 89, true, false)
    player.castFireball()
    //Aura
    val auraColor = player.auraColor()
    //player status
    printPlayerStatus(player)
    //weapon
    player.printWeaponName()
}

private fun printPlayerStatus(player: Player) {
    println(
        "(Aura: ${player.auraColor()}) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
    )
    println("${player.name} ${player.formatHealthStatus()}")
}