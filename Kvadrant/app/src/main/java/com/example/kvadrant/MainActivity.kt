package com.example.kvadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kvadrant.ui.theme.KvadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KvadrantTheme {
                MainScreen()
            }
        }
    }
}



@Preview(showBackground = true,
    device = "id:pixel_6")
@Composable
fun MainScreenPreview() {
    KvadrantTheme {
        com.example.kvadrant.MainScreen()
    }
}

@Composable
fun MainScreen(){
    Column (Modifier.fillMaxSize()){
        Row(Modifier.weight(1f)) {
            FirstBlock(modifier = Modifier.weight(1f).background(Color(0xFFEADDFF)))
            SecondBlock(modifier = Modifier.weight(1f).background(Color(0xFFD0BCFF)))
        }
        Row(Modifier.weight(1f)) {
            ThreeBlock(modifier = Modifier.weight(1f).background(Color(0xFFB69DF8)))
            FourBlock(modifier = Modifier.weight(1f).background(Color(0xFFF6EDFF)))
        }
    }
}


@Composable
fun FirstBlock(modifier: Modifier = Modifier){
    Column (modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        Text(
            text = "Displays text and follows the recommended Material Design guidelines."
        )
    }
}


@Composable
fun SecondBlock(modifier: Modifier = Modifier){
    Column ( modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Image composable"
        )
        Text(
            text = "Creates a composable that lays out and draws a given Painter class object."
        )
    }
}



@Composable
fun ThreeBlock(modifier: Modifier = Modifier){
    Column (modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Row composable"
        )
        Text(
            text = "A layout composable that places its children in a horizontal sequence."
        )
    }
}


@Composable
fun FourBlock(modifier: Modifier = Modifier){
    Column ( modifier = modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(
            text = "Column composable" ,
            textAlign = TextAlign.Center
        )
        Text(
            text = "A layout composable that places its children in a vertical sequence."
        )
    }
}