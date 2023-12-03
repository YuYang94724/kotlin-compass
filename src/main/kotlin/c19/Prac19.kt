package c19

import c18.easyPrint

fun main() {
    val valuesToAdd = listOf(1, 18, 73, 3, 44, 6, 1, 33, 2, 22, 5, 7)
    println(result(valuesToAdd)) // 输出 2339

    val l = listOf(Pair("1", 100), Pair("2", 200),Pair("3", 300))
    val p = l.reduce { acc, pair -> //acc 為每次最下面回傳的pair
        println(" @@ $acc")
        println(" !! $pair")
        pair
    }
    p.easyPrint()

}

fun result(list :List<Int>): Int = list.filter { it >= 5 } // 删除小于 5 的数
    .chunked(2) // 两两分组
    .map { it.reduce { acc, i -> acc * i } } // 将各组数两两相乘并求和
    .sum() // 求和