package com.example.oppimistehtava2_restapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.oppimistehtava2_restapi.ui.theme.Oppimistehtava2_RESTAPITheme
import androidx.compose.foundation.layout.Box

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Oppimistehtava2_RESTAPITheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Box(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        TodoScreen()
                    }
                }
            }
        }
    }
}