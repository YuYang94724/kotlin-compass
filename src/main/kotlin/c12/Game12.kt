package c12

fun main(args: Array<String>) {
    val player = Player()
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