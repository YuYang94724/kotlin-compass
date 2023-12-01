package c17

class LootBox<T : Loot>(vararg item: T) {
    private var loot: Array<out T> = item
    var open = false

    operator fun get(index: Int): T? = loot[index].takeIf { open }
    fun fetch(item: Int): T? {
        return loot[item].takeIf { open }
    }

    fun <R> fetch(item: Int, lootModFunction: (T) -> R): R? {
        return lootModFunction(loot[item]).takeIf { open }
    }

}
open class Loot(val value: Int)

class Fedora(val name: String,  value: Int) : Loot(value)

class Coin( value: Int) : Loot(value)

fun main() {
    val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("a generic-looking fedora", 15),
        Fedora("a dazzling magenta fedora", 25))
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))

    lootBoxOne.open = true
    lootBoxOne.fetch(1)?.run {
        println("You retrieve $name from the box!")
    }

    val coin = lootBoxOne.fetch(0) {
        Coin(it.value * 3)
    }
    coin?.let { println(it.value) }
    val fedora = lootBoxOne[1]
    fedora?.apply { println(this.name) } //只會回傳自己
    fedora?.run { println(this.name) } //可以回傳任何值
    val b = fedora?.also { println(it.name)
        it.value * 2
        "123".let { it.length-2 + "12345".length }//在裡面做事情但沒任何作用
    }//只會回傳自己
    val a = fedora?.let { println(it.name)
        listOf("123", it.name)
    } //可以回傳任何值
}