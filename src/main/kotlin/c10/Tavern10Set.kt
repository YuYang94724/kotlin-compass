package c10

val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
fun main(args: Array<String>) {
    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        println(name)
        uniquePatrons += name
    }
    println(uniquePatrons)

    val testSet = mutableSetOf("1", "2", "3")
    println("testSet = $testSet")
    testSet += setOf("4", "5")
    println("testSet += $testSet")
    testSet.add("6")
    println("testSet add $testSet")
    testSet.addAll(setOf("7", "8"))
    println("testSet addAll $testSet")
    //使用while達成條件才停止
    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(),
            menuList.shuffled().first())
        orderCount++
    }
    //list and set 互轉
    val set = listOf("Eli Baggins", "Eli Baggins", "Eli Ironfoot").toSet()
    println(set)
    //轉回List快速搜索
    val list = listOf("Eli Baggins", "Eli Baggins", "Eli Ironfoot").toSet().toList()
    println(list)
    //上述方式太常發生所以有新的方法
    val distinct = listOf("Eli Baggins", "Eli Baggins", "Eli Ironfoot").distinct()
    println(distinct)
    println("is list == distinct ? [${list == distinct}]")
    println("is list === distinct ? [${list === distinct}]")
    println("is list == set ? [${list == set}]")
    //拷貝出來的list是否和原本的位址值一樣
    var newList = mutableListOf<String>()
    newList.addAll(list)
    println("is list === newList ? [${list === newList}]")
}