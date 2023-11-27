package c8

var gal = 5
val pint = 0.125
var playerPurse = transferDragonCoinToGold()

fun main() {
    //8.9
    val remainingGal = gal - pint * 12
    println("$remainingGal gallons remaining")
    println("-----------------------------------------")
    //8.10
    placeOrder("shandy,Dragon's Breath,5.91")
    println("-----------------------------------------")
    placeOrder("shandy,Dragon's Breath,5.91")
    println("-----------------------------------------")
    //8.11
    printPlayerPurse()
    buynDrink("Dragon's Breath", 5.91)
    printPlayerPurse()
    if (checkPlayerDragonCoinRemain()){
        println("Yes it's good")
    }else{
        println("No it's error")
    }
}

fun checkPlayerDragonCoinRemain(): Boolean{
    val remainDragonCoin ="%.4f".format(playerPurse / 1.43).toDouble()
    println("Remaining balance: $remainDragonCoin Dragon's Coins")
    return if (remainDragonCoin == 0.8671) true else false
}

fun transferDragonCoinToGold(): Double {
    return playerDragonCoin * 1.43
}
fun buynDrink(drinkName: String, drinkPrice: Double) {
    println("player buy $drinkName for $drinkPrice gold")
    playerPurse = playerPurse - drinkPrice
}
fun printPlayerPurse(){
    println("playerPurse = ${"%.2f".format(playerPurse)}")
}
