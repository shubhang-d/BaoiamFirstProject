package com.example.baoiamfirstproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.baoiamfirstproject.screens.HomeScreen
import com.example.baoiamfirstproject.screens.LoginScreen
import com.example.baoiamfirstproject.screens.SignUpScreen
import com.google.firebase.auth.FirebaseUser

@Composable
fun MainNavigationComponent(navController: NavHostController, currentUser: FirebaseUser?){
    NavHost(navController = navController,
        startDestination = if (currentUser != null){ "home"} else{ "login"}){
        composable(route= "login"){
            LoginScreen(navController)
        }
        composable("signup"){
            SignUpScreen(navController)
        }
        composable(route = "home"){
            HomeScreen()
        }
    }
}