package com.example.baoiamfirstproject.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person2
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.Person2
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.baoiamfirstproject.components.BottomNavigationBar
import com.example.baoiamfirstproject.model.BottomNavigationItem
import com.example.baoiamfirstproject.navigation.BottomBarNavigationConfigurations

@Composable
fun HomeScreen(){
    val items = listOf(
        BottomNavigationItem(
            title = "Explore",
            route = "explore",
            selectedIcon = Icons.Rounded.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
        ),
        BottomNavigationItem(
            title = "My Course",
            route = "course",
            selectedIcon = Icons.Filled.MenuBook,
            unselectedIcon = Icons.Outlined.MenuBook,
            hasNews = false,
        ),
        BottomNavigationItem(
            title = "Career",
            route = "career",
            selectedIcon = Icons.Filled.School,
            unselectedIcon = Icons.Outlined.School,
            hasNews = false,
        ),
        BottomNavigationItem(
            title = "Profile",
            route = "profile",
            selectedIcon = Icons.Filled.Person2,
            unselectedIcon = Icons.Outlined.Person2,
            hasNews = false,
        )
    )
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController, items = items)
        }
    ) {
        BottomBarNavigationConfigurations(navController = navController, paddingValues = it,
            items = items)
    }
}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}

