package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {

            }
        }
    }
}


@Preview(showBackground = true,
    device = "id:pixel_6")
@Composable
fun MainScreenPreview() {
    BusinessCardTheme {
        com.example.businesscard.MainScreen()
    }
}



@Composable
fun MainScreen(){
    Column (
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Logo_Image()
        Logo_Name()
        //Info(Modifier.padding(top = 250.dp))


    }

}


@Composable
fun Logo_Image(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.audi_logo)
    Image(
        painter = image,
        contentDescription = null,

    )
}


@Composable
fun Logo_Name(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,

        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "Ismailov Ildar",
            fontSize = 30.sp ,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Student",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

