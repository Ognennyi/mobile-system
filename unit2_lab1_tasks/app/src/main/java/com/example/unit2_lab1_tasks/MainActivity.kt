package com.example.unit2_lab1_tasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.unit2_lab1_tasks.ui.theme.Unit2_lab1_tasksTheme


// задача 1 (пункт 2)
//fun main() {
//    val morningNotification = 51
//    val eveningNotification = 135
//
//    printNotificationSummary(morningNotification)
//    printNotificationSummary(eveningNotification)
//}
//
//
//fun printNotificationSummary(numberOfMessages: Int) {
//    if (numberOfMessages <100){
//        println("You have $numberOfMessages notifications.")
//    }else{
//        println("Your phone is blowing up! You have 99+ notifications.")
//    }
//}




//задача 2 (пункт 3)
//fun main() {
//    val child = 5
//    val adult = 28
//    val senior = 87
//
//    val isMonday = true
//
//    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
//    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
//    println("The movie ticket price for a person aged $senior is \$${ticketPrice(senior, isMonday)}.")
//}
//
//fun ticketPrice(age: Int, isMonday: Boolean): Int {
//    return when(age) {
//        in 0..12 -> 15
//        in 13..60 -> if (isMonday) 25 else 30
//        in 61..100 -> 20
//        else -> -1
//    }
//}


//задача 3 (пункт 4)
//fun main() {
//    printFinalTemperature(27.0, "Celsius", "Fahrenheit") { 9.0 / 5.0 * it + 32 }
//    printFinalTemperature(350.0, "Kelvin", "Celsius") { it - 273.15 }
//    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { 5.0 / 9.0 * (it - 32) + 273.15 }
//}
//
//
//fun printFinalTemperature(
//    initialMeasurement: Double,
//    initialUnit: String,
//    finalUnit: String,
//    conversionFormula: (Double) -> Double
//) {
//    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
//    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
//}



//задача 4 (пункт 5)
//fun main() {
//    val introSong = Song("Intro", "Artist", 2020, 1234000)
//    introSong.printDescription()
//    print(" Popular? ")
//    print(introSong.isPopular)
//}
//
//
//class Song(
//    val title: String,
//    val artist: String,
//    val yearPublished: Int,
//    val playCount: Int
//){
//    val isPopular: Boolean
//        get() = playCount >= 1000
//
//    fun printDescription() {
//        println("$title, performed by $artist, was released in $yearPublished.")
//    }
//}

//задача 5 (пункт 6)

//fun main() {
//    val amanda = Person("Amanda", 33, "play tennis", null)
//    val atiqah = Person("Atiqah", 28, "climb", amanda)
//
//    amanda.showProfile()
//    atiqah.showProfile()
//}
//
//
//class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
//    fun showProfile() {
//
//        println("Name: $name")
//        println("Age: $age")
//
//        if(hobby != null) {
//            print("Likes to $hobby. ")
//        }
//
//        if(referrer != null) {
//            print("Has a referrer named ${referrer.name}")
//            if(referrer.hobby != null) {
//                print(", who likes to ${referrer.hobby}.")
//            } else {
//                print(".")
//            }
//        } else {
//            print("Doesn't have a referrer.")
//        }
//        print("\n\n")
//    }
//}


//задача 6 (пункт 7)
//
//open class Phone(var isScreenLightOn: Boolean = false){
//    open fun switchOn() {
//        isScreenLightOn = true
//    }
//
//    fun switchOff() {
//        isScreenLightOn = false
//    }
//
//    fun checkPhoneScreenLight() {
//        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
//        println("The phone screen's light is $phoneScreenLight.")
//    }
//}
//
//class FoldablePhone(var isFolded: Boolean = true): Phone() {
//    override fun switchOn() {
//        if (!isFolded) {
//            isScreenLightOn = true
//        }
//    }
//
//    fun fold() {
//        isFolded = true
//    }
//
//    fun unfold() {
//        isFolded = false
//    }
//}
//
//fun main() {
//    val newFoldablePhone = FoldablePhone()
//
//    newFoldablePhone.switchOn()
//    newFoldablePhone.checkPhoneScreenLight()
//    newFoldablePhone.unfold()
//    newFoldablePhone.switchOn()
//    newFoldablePhone.checkPhoneScreenLight()
//}



//задача 7 (пункт 8)

//fun main() {
//    val winningBid = Bid(5000, "Private Collector")
//
//    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
//    println("Item B is sold at ${auctionPrice(null, 3000)}.")
//}
//
//class Bid(val amount: Int, val bidder: String)
//
//fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
//    return bid?.amount ?: minimumPrice
//}




