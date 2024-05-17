package com.phwnam.lab3_ph35329

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.phwnam.lab3_ph35329.ui.theme.Lab3_PH35329Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingCard("Trang chính")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Greeting(){
    GreetingCard(msg = "Trang chỉ")
}


@Composable
fun GreetingCard(msg: String){
    var text by remember { mutableStateOf(msg) }
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        GetTextTitle(title = "Trang chủ")
        Button(onClick = {text = "Hi!"}) {
            Text("Say Hi!")
        }
    }
}


@Composable
fun GetTextTitle  (title: String){
    Text(
        text = title,
        fontSize = 20.sp,
        color = Color.Red,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center
    )
}

