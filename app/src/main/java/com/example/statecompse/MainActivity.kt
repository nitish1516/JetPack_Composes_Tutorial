package com.example.statecompse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.statecompse.ui.theme.StateCompseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateCompseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var nameState by remember{
        mutableStateOf("")
    }
    /** remember will only save the value in current mode
     * if we rotate the device we will lost our data
     * so we are going to use rememberSaveable */
    var name by rememberSaveable{
        mutableStateOf("")
    }
   Column(horizontalAlignment=Alignment.CenterHorizontally,
   modifier= Modifier
       .fillMaxWidth()
       .fillMaxHeight(),
   verticalArrangement = Arrangement.Center) {
       Text(text = "Hello $name")
       Spacer(modifier = Modifier.height(20.dp))
       TextField(value = nameState, onValueChange ={
           nameState=it
       } )
       Spacer(modifier = Modifier.height(20.dp))
       Button(onClick = {
           name=nameState
       }) {
           Text(text = "Display")
           
       }
   }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StateCompseTheme {
        Greeting("Android")
    }
}