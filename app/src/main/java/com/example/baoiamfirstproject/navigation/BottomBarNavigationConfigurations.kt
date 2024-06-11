package com.example.baoiamfirstproject.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.baoiamfirstproject.model.BottomNavigationItem
import com.example.baoiamfirstproject.screens.LoginScreen
import com.example.baoiamfirstproject.screens.ProfileScreen

@Composable
fun BottomBarNavigationConfigurations(
    navController: NavHostController,
    paddingValues: PaddingValues,
    items: List<BottomNavigationItem>
) {
    NavHost(navController, startDestination = "explore") {
        composable("explore") {
            Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Text(text = "Explore")
            }
        }
        composable("course") {
            Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Text(text = "Course")
            }
        }
        composable("career") {
            Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                Text(text = "Career")
            }
        }
        composable("profile") {
            ProfileScreen(paddingValues = paddingValues, navController)
        }
        composable(route= "login"){
            LoginScreen(navController)
        }
    }
}