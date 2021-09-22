package com.example.composestatepractice

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.tooling.preview.Preview
import com.example.composestatepractice.ui.theme.ComposeStatePracticeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()

        }
    }
}

@Composable
fun MyApp() {
    ComposeStatePracticeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column {
                val color = remember {
                    mutableStateOf(Color.Yellow)
                }
                ColorBox(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                ) {
                    color.value = it
                }
                Box(
                    modifier = Modifier
                        .background(color = color.value)
                        .weight(1f)
                        .fillMaxSize()
                )
            }
        }

    }
}

@Composable
fun ColorBox(modifier: Modifier = Modifier, updateColor: (Color) -> Unit) {
    /*val color = remember {
        mutableStateOf(Color.Yellow)
    }*/
    Box(modifier = modifier
        //.background(color.value)
        .background(Color.Magenta)
        .clickable {
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    alpha = 1f,
                    colorSpace = ColorSpaces.Srgb
                )
            )
            /*color.value =
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    alpha = 1f,
                    colorSpace = ColorSpaces.Srgb
                )*/
        }
    )
}

@Preview(showBackground = true, name = "Light mode")
@Preview(showBackground = true, name = "Dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    MyApp()
}
