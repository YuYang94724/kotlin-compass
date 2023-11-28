package c13

import java.util.*

class Player (_name: String,
              var healthPoints: Int,
              val isBlessed: Boolean,
              private val isImmortal: Boolean) {
    var name = _name
        get() = field.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        set(value) {
            field = value
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