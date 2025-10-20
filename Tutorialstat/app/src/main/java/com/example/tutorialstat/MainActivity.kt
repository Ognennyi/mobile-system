package com.example.tutorialstat

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tutorialstat.ui.theme.TutorialStatTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TutorialStatTheme {
                MainScreen()
            }
        }
    }
}


@Preview(showBackground = true,
    device = "id:pixel_6")
@Composable
fun MainScreenPreview() {
    TutorialStatTheme {
        MainScreen()
    }
}

@Composable
fun MainScreen() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            AudImage()
            audiText()

        } //заканчивается колонка
    }
}

@Composable
fun AudImage(modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.audi)
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun audiText(){
    Column (modifier = Modifier.padding(16.dp)){
        Text(
            text = "Audi RS7",
            fontSize = 24.sp,
        )
        Text(
            text = "Audi RS7 — спортивный пятидверный фастбэк класса Гран Туризмо, " +
                    "выпускаемый подразделением Audi Sport GmbH на платформе Audi A7.",
            textAlign = TextAlign.Justify
        )
//        Text(
//            text = "Дизайн: внешний дизайн автомобиля отличается от стандартной версии A7 и более" +
//                    " мощной спортивной S7, спортивными воздухозаборниками спереди, серебристыми " +
//                    "боковыми зеркалами заднего вида, фирменной выхлопной системой RS. \n" +
//                    "Интерьер: для обивки сидений и простора салона используются материалы из " +
//                    "натуральной кожи и алькантары. В базовой комплектации RS7 применяются материалы" +
//                    " из карбона.",
//            textAlign = TextAlign.Justify
//        )
    }
}