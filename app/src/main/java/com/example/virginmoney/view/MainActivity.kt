package com.example.virginmoney.view


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.virginmoney.ui.theme.VirginMoneyTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContent {
            VirginMoneyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")'
                    myApp()

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    VirginMoneyTheme {
        myApp()
    }
}


@Composable
fun myApp() {

    val context = LocalContext.current

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(4.dp)
            .fillMaxHeight()
            .fillMaxWidth()
    ) {

        Button(
            modifier = Modifier.padding(10.dp, 10.dp, 10.dp, 10.dp),
            onClick = { context.startActivity(Intent(context, ListActivity::class.java).putExtra("TYPE","PEOPLE")) }
        ) {
            Text("People")
        }

        Button(
            modifier = Modifier.padding(10.dp, 10.dp, 10.dp, 10.dp),
            onClick = {
            context.startActivity(Intent(context, ListActivity::class.java).putExtra("TYPE","ROOM")) }
        ) {
            Text("Room")
        }

    }

}




