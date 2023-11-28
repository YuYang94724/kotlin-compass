package c9

import c6.f
import java.io.File

data class Person(var name: String, var age: Int)

fun main() {
//    val person = Person("Alice", 30)
    val runResult = Person("Alice", 30).run {
        this.age += 5
//        "The person's name is $name and age is $age."
        Person("Nick", 30)
//        this
    }
    println("runResult = $runResult")
    println("==================================")
    val withResult = with(runResult) {
        Person("Nick", 30)
    }
    println("withResult = $withResult")
    println("==================================")
    val applyResult = Person("Alice", 30).apply {
        this.age += 5
        Person("Nick", 30)

    }
    println("applyResult = $applyResult")
    println("==================================")
    val resultAlso = Person("Alice", 30)
        .also {
            it.age +=5
            Person("Nick", 30)
        }
    println("resultAlso = $resultAlso")
    println("==================================")
    val resultLet = Person("Alice", 30)
        .let {
            it.age +=5
            Person("Nick", 30)
        }
    println("resultLet = $resultLet")

    val applyP = Person("123", 456).apply {
        this.name>10.toString()
    }
    val alsoP = Person("123", 456).also {
        it.name>10.toString()
    }
    println("$applyP , $alsoP")
    val letP = Person("123", 456).run {
        this.name.length>10
    }
    println("letP = $letP")
}

fun testApply() {
//    val menuFile = File("menu-file.txt")
//    menuFile.setReadable(true)
//    menuFile.setWritable(true)
//    menuFile.setExecutable(false)
    val menuFile = File("menu-file.txt").apply {
        setReadable(true)
        setWritable(true)
        setExecutable(false)
    }
}

fun testLet() {
    //1
//    val firstElement = listOf(1,2,3).first()
//    val firstItemSquared = firstElement * firstElement
    val firstItemSquared = listOf(1, 2, 3).first().let {
        it * it
    }

    //2
//    fun formatGreeting(vipGuest: String?): String {
//        return if (vipGuest != null) {
//            "Welcome, $vipGuest. Please, go straight back - your table is ready."
//        } else {
//            "Welcome to the tavern. You'll be seated shortly."
//        }
//    }
    fun formatGreeting(vipGuest: String?): String {
        return vipGuest?.let {
            "Welcome, $it. Please, go straight back - your table is ready."
        } ?: "Welcome to the tavern. You'll be seated soon."
    }
}

fun testRun() {
    //1
    val menuFile = File("menu-file.txt")
    val servesDragonsBreath = menuFile.run {
        readText().contains("Dragon's Breath")
    }

    //2
//    fun nameIsLong(name: String) = name.length >= 20
//    "Madrigal".run(::nameIsLong)  // False
//    "Polarcubis, Supreme Master of NyetHack".run(::nameIsLong) // True
    fun nameIsLong(name: String) = name.length >= 20
    fun playerCreateMessage(nameTooLong: Boolean): String {
        return if (nameTooLong) {
            "Name is too long. Please choose another name."
        } else {
            "Welcome, adventurer"
        }
    }
    //執行fun的意思
    "Polarcubis, Supreme Master of NyetHack"
        .run(::nameIsLong)
        .run(::playerCreateMessage)
        .run(::println)
    //傳統一層一層呼叫
    println(playerCreateMessage(nameIsLong("Polarcubis, Supreme Master of NyetHack")))

}

fun testWith() {
    val nameTooLong = with("Polarcubis, Supreme Master of NyetHack") {
        length >= 20
    }
}

fun testAlso(){
    var alsoAge: Int
    val resultAlso = Person("testAlso", 10)
        .also {
            println(it.name)
            alsoAge = it.age + 5
        }
    println("resultAlso = $resultAlso alsoAge = $alsoAge")
    var letAge: Int
    val resultLet = Person("testLet", 10)
        .let {
            println(it.name)
            letAge = it.age+5
            it
        }
    println("resultLet = $resultLet letAge = $letAge")

}

