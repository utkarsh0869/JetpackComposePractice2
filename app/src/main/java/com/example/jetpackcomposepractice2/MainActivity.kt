package com.example.jetpackcomposepractice2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposepractice2.ui.theme.JetpackComposePractice2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposePractice2Theme {
                MyApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Scaffold Top App Bar")
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Text(
                    text = "Scaffold Bottom App Bar"
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier
                .padding(innerPadding)
        ) {
            Text(
                text = "content"
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposePractice2Theme {
        MyApp()
    }
}