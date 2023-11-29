package c14

import c13.Player
import c13.printPlayerStatus

fun main() {
    val player = Player("Madrigal")

    //fireball test
    player.castFireball()
    var currentRoom = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())
    //Aura
    val auraColor = player.auraColor()
    //player status
    printPlayerStatus(player)

    //print className
    val className = when(currentRoom){
        is TownSquare -> "TownSquare"
        is Room -> "Room"
        else -> "Unknown"
    }
    printIsSourceOfBlessings(player)
}


fun printIsSourceOfBlessings(any: Any) {
    val isSourceOfBlessings = if (any is Player) {
        any.isBlessed
    } else {
        (any as Room).name == "Fount of Blessings"
    }

    println("$any is a source of blessings: $isSourceOfBlessings")
}