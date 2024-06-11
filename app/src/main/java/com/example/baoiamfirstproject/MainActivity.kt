package com.example.baoiamfirstproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.baoiamfirstproject.navigation.MainNavigationComponent
import com.example.baoiamfirstproject.screens.HomeScreen
import com.example.baoiamfirstproject.screens.LoginScreen
import com.example.baoiamfirstproject.screens.SignUpScreen
import com.example.baoiamfirstproject.ui.theme.BaoiamFirstProjectTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth

class MainActivity : ComponentActivity() {
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BaoiamFirstProjectTheme {
                auth = Firebase.auth
                val currentUser = auth.currentUser
                MainNavigationComponent(navController = rememberNavController(),
                    currentUser = currentUser)
            }
        }
    }
}
