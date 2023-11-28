package c10

fun main() {
    //不可變是假的
    val myList: List<Int> = listOf(1,2,3)
    println(myList)
    (myList as MutableList)[2] = 1000
    println(myList)
}