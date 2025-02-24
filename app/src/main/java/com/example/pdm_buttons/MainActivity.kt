package com.example.pdm_buttons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pdm_buttons.ui.theme.PDMButtonsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PDMButtonsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        ButtonExamples()
                    }
                }
            }
        }
    }
}

@Composable
fun ButtonExamples() {
    var buttonText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { buttonText = "You clicked the Filled Button!" }) {
            Text("Filled Button")
        }

        FilledTonalButton(onClick = { buttonText = "You clicked the FilledTonal Button!" }) {
            Text("Tonal Filled Button")
        }

        OutlinedButton(onClick = { buttonText = "You clicked the Outlined Button!" }) {
            Text("Outlined Button")
        }

        ElevatedButton(onClick = { buttonText = "You clicked the Elevated Button!" }) {
            Text("Elevated Button")
        }

        TextButton(onClick = { buttonText = "You clicked the Text Button!" }) {
            Text("Text Button")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = buttonText,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    PDMButtonsTheme {
        ButtonExamples()
    }
}
