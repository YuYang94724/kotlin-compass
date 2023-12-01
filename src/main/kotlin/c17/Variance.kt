package c17

import c13.Player

class Barrel<in T>(item: T)

fun main(args: Array<String>) {
    var fedoraBarrel: Barrel<Fedora> = Barrel(Fedora("a generic-looking fedora", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))
    var coinBarrel: Barrel<Coin> = Barrel(Coin(15))

    fedoraBarrel = lootBarrel
    coinBarrel = lootBarrel

//    var loot: Loot = Fedora("a generic-looking fedora", 15) // No errors
//    println(lootBarrel.item)
//    val myCoin: Loot = lootBarrel.item
//    lootBarrel = fedoraBarrel
//    println(lootBarrel.item)
//    val myFedora: Fedora = lootBarrel.item
    val languages = arrayOf("Kotlin", "Java", "Generics", 1)
    val test = arrayOf("1", fedoraBarrel, Player("M"))
    println(test[0])
    println((test[1] is Barrel<Nothing>).toString())
    println((test[2] as Player).name)
    println(randomOrBackupLoot{ backup("456") })
    println(
        test{
        "123456"
        }
    )
}

 inline fun <reified T> randomOrBackupLoot(backupLoot: () -> T): T {
    val items = listOf(Coin(14), Fedora("a fedora of the ages", 150))
    val first: Loot = items.shuffled().first()
    return if (first is T) {
        first
    } else {
        backupLoot()
    }
}

fun backup(s: String): String = s+"123"

fun test(backop: ()->String): String =  if ((backop() + "123").length>5) backop() else "bad"


