package com.example.taskscompleted

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.taskscompleted.ui.theme.TasksCompletedTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.Typeface
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TasksCompletedTheme {
                MainScreen()
                }
            }
        }
    }


@Preview(showBackground = true,
    device = "id:pixel_6")
@Composable
fun MainScreenPreview() {
    TasksCompletedTheme {
        MainScreen()
    }
}


@Composable
fun MainScreen(){
    Surface (modifier = Modifier.fillMaxSize())
    {
        Column ( horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            GalImage()
            TaskText()
        }

    }
}

@Composable
fun GalImage(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.ic_task_completed)
    Image(
        painter = image,
        contentDescription = null,

    )
}

@Composable
fun TaskText(){
        Text(
            text = "",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp, top = 8.dp)
        )
        Text(
            text = "Nice work!",
            fontSize = 16.sp
        )

}