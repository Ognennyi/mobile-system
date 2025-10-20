package com.example.unit2_task2

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
import com.example.unit2_task2.ui.theme.Unit2_task2Theme

fun main() {
    val treatFunction = trickOrTreat(false) { "$it quarters" }
    val trickFunction = trickOrTreat(true, null)

    repeat(4) {
        treatFunction()
    }
    trickFunction()
}

//fun trickOrTreat(isTrick: Boolean): () -> Unit {
//    if (isTrick){
//        return trick
//    }else{
//        return treat
//    }
//
//}

fun trickOrTreat(
    isTrick: Boolean,
    extraTreat: ((Int) -> String)?
): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat = {
    println("Have a treat!")
}