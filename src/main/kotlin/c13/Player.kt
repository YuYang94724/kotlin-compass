package c13

import java.io.File
import java.util.*

class Player (_name: String,
              var healthPoints: Int = 100,
              val isBlessed: Boolean,
              private val isImmortal: Boolean) {
    var name = _name
        get() = replaceFirst(field) + " of $hometown"
        set(value) {
            field = value
        }

    private fun replaceFirst(name: String) = name.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
    }

    val hometown by lazy {selectHometown()}

    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()

    lateinit var alignment: String
    fun determineFate() {
        alignment = "Good"
    }
    fun proclaimFate() {
        if (::alignment.isInitialized) println(alignment)
    }
    //init 區塊如果要初始化屬性則需要放在類別屬性後，所以建議有聲明類別屬性則放在他下方
    init {
        require(healthPoints > 0, { "healthPoints must be greater than zero." })
        require(name.isNotBlank(), { "Player must have a name." })
    }

    constructor(name: String) : this(name, 100, false, false){
        if (name.lowercase(Locale.getDefault()) == "kar"){
            healthPoints = 40
        }
    }



    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. (x$numFireballs)")

    fun auraColor() =
        if ((isBlessed && healthPoints > 50) || isImmortal) "GREEN" else "NONE"

    fun formatHealthStatus(): String =
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

    var weapon: Weapon? = Weapon("Ebony Kris")
    fun printWeaponName() {
        weapon?.also {
            println(it.name)
        }
    }
}

class Weapon(val name: String)