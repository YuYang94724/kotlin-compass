package c15

import c13.Player
import c13.printPlayerStatus
import c14.Room
import c14.TownSquare
import c18.configurePitGoblin
import java.util.*

var notEnd = true
fun main() {
    Game.play()
}

object Game {
    val player = Player("Madrigal")
    var currentRoom: Room = TownSquare()
    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room")))
    init {
        println("Welcome, adventurer.")
        player.castFireball()
        currentRoom.configurePitGoblin {goblin ->
            goblin.healthPoints = dangerLevel * 3
            goblin
        }
    }

    fun play() {
        while (notEnd) {
            // Play NyetHack
            println(currentRoom.description())
            println(currentRoom.load())
            // Player status
            printPlayerStatus(player)

            print("> Enter your command: ")
            println(GameInput(readLine()).processCommand())
        }
    }
    private fun printPlayerStatus(player: Player) {
        println(
            "(Aura: ${player.auraColor()}) " +
                    "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
        )
        println("${player.name} ${player.formatHealthStatus()}")
    }
    //對象表達式
    val abandonedTownSquare = object : TownSquare() {
        override fun load() = "You anticipate applause, but no one is here..."
    }

    //搖留當
    private fun canRing(player: Player)=
        if (player.currentPosition == Coordinate(0,0))
            TownSquare().ringBell() + " can Ring"
        else
            "You can't ringBell !!"

    //印地圖
    private fun printWhereAmI(player: Player): String {
        val xLen = worldMap[0].size
        val yLen = worldMap[1].size
        val xArray = mutableListOf<String>()
        val yArray = mutableListOf<String>()
        for (i in 1..xLen){
            xArray += "0"
        }
        for (i in 1..yLen){
            yArray += "0"
        }
        val mapList = listOf(xArray,yArray)
        mapList[player.currentPosition.x][player.currentPosition.y] = "X"
        var  mapString = ""
        mapList.forEachIndexed { index, it ->
            it.forEach {
                mapString += "$it "
            }
            if (mapList.size-1 != index){
                mapString+="\n"
            }
        }
        return mapString
    }

    private fun endGame(): String {
        notEnd = false
        return "Good Bye!"
    }

    private fun move(directionInput: String) =
        try {
            val direction = Direction.valueOf(directionInput.uppercase(Locale.getDefault()))
            val newPosition = direction.updateCoordinate(player.currentPosition)
            if (!newPosition.isInBounds) {
                println("$direction is out of bounds.")
                throw IllegalStateException()
            }
            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom
            "OK, you move $direction to the ${newRoom.name}.\n${newRoom.load()}"
        } catch (e: Exception) {
            "Invalid direction: [$directionInput]."
        }

    private class GameInput(arg: String?){
        private val input = arg ?: ""

        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1) { "" }

        fun processCommand() = when(command.lowercase(Locale.getDefault())) {
            "move" -> move(argument)
            "exit", "quit" -> endGame()
            "map" -> printWhereAmI(player)
            "ring" -> canRing(player)
            else -> commandNotFound()
        }

        private fun commandNotFound() = "I'm not quite sure what you're trying to do!"
    }
}

fun printIsSourceOfBlessings(any: Any) {
    val isSourceOfBlessings = if (any is Player) {
        any.isBlessed
    } else {
        (any as Room).name == "Fount of Blessings"
    }

    println("$any is a source of blessings: $isSourceOfBlessings")
}