package com.example.baoiamfirstproject.screens

import android.content.Intent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.Paid
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import com.example.baoiamfirstproject.MainActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.auth


@Composable
fun ProfileScreen(paddingValues: PaddingValues, navController: NavHostController? = null){
    val brush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFFFAB00),
            Color(0xFFDD2C00)
        )
    )
    val context = LocalContext.current
    Column(modifier = Modifier.padding(paddingValues)) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Button(onClick = { /*TODO*/ }, modifier = Modifier
                .size(50.dp)
                .border(width = 1.dp, brush = brush, shape = RoundedCornerShape(50)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)) {}
            Text(text = "Welcome, ", fontSize = 25.sp, modifier = Modifier.padding(start = 4.dp))
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()) {
                Icon(imageVector = Icons.Filled.Settings,
                    contentDescription = "Settings"
                )
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Column {
                Text(text = "Name ", fontSize = 18.sp,
                    modifier = Modifier.padding(start = 54.dp),
                    fontWeight = FontWeight.Bold)
                Text(text = "Enter Your email ", fontSize = 15.sp,
                    modifier = Modifier.padding(start = 54.dp))

            }
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()) {
                Icon(imageVector = Icons.Filled.Edit,
                    contentDescription = "Settings"
                )
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Icon(imageVector = Icons.Outlined.Bookmark, contentDescription = "bookmark")
            Text(text = "Wishlist ", fontSize = 20.sp, modifier = Modifier.padding(start = 25.dp))
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()) {
                Icon(imageVector = Icons.Filled.ChevronRight ,
                    contentDescription = "Settings"
                )
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Icon(imageVector = Icons.Outlined.School, contentDescription = "bookmark")
            Text(text = "Certificate ", fontSize = 20.sp, modifier = Modifier.padding(start = 25.dp))
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()) {
                Icon(imageVector = Icons.Filled.ChevronRight ,
                    contentDescription = "Settings"
                )
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Icon(imageVector = Icons.Outlined.Paid, contentDescription = "bookmark")
            Text(text = "Refer and earn ", fontSize = 20.sp, modifier = Modifier.padding(start = 25.dp))
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()) {
                Icon(imageVector = Icons.Filled.ChevronRight ,
                    contentDescription = "Settings"
                )
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Icon(imageVector = Icons.Outlined.Settings, contentDescription = "bookmark")
            Text(text = "Settings ", fontSize = 20.sp, modifier = Modifier.padding(start = 25.dp))
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()) {
                Icon(imageVector = Icons.Filled.ChevronRight ,
                    contentDescription = "Settings"
                )
            }
        }

        Row (verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)){
            Text(text = "Logout",
                fontSize = 20.sp,
                style = TextStyle(brush = brush),
                modifier = Modifier.clickable {
                    Firebase.auth.signOut()
                    val intent = Intent(
                        context,
                        MainActivity::class.java
                    )
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(context, intent, null)
                })
            Icon(
                imageVector = Icons.Filled.Logout,
                contentDescription = "bookmark",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .graphicsLayer(alpha = 0.99f)
                    .drawWithCache {
                        onDrawWithContent {
                            drawContent()
                            drawRect(brush, blendMode = BlendMode.SrcAtop)
                        }
                    }.clickable {
                        Firebase.auth.signOut()
                        val intent = Intent(
                            context,
                            MainActivity::class.java
                        )
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        startActivity(context, intent, null)
                    },
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview(){
    ProfileScreen(paddingValues = PaddingValues(20.dp))
}