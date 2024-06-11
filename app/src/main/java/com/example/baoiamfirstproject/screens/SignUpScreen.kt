package com.example.baoiamfirstproject.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baoiamfirstproject.R
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

@Composable
fun SignUpScreen(navController: NavController? = null){
    var name by remember {
        mutableStateOf("")
    }
    var email by remember{
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }
    var showPassword by remember {
        mutableStateOf(false)
    }
    val brush = Brush.horizontalGradient(colors = listOf(
        Color(0xFFFFAB00),
        Color(0xFFDD2C00)
    ))
    val auth = Firebase.auth
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.baoiam_logo),
                contentDescription = "Logo of the app", modifier = Modifier.size(200.dp))
            Text(text = "Create an account", fontWeight = FontWeight.Medium, fontSize = 25.sp)
            OutlinedTextField(value = name,
                onValueChange = {name = it},
                label = { Text(text = "Name") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text,
                    autoCorrect = true,
                    imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                })
            )
            OutlinedTextField(value = email,
                onValueChange = {email = it},
                label = { Text(text = "Email/Phone Number") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email,
                    autoCorrect = true,
                    imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                })
            )
            OutlinedTextField(value = password,
                onValueChange = {password = it},
                label = { Text(text = "Password") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                }),
                visualTransformation = if (showPassword) VisualTransformation.None
                else PasswordVisualTransformation(),
                trailingIcon = {
                    Icon(
                        imageVector = if (showPassword) Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff,
                        contentDescription = "Show password",
                        modifier = Modifier.clickable {
                            showPassword = !showPassword
                        }
                    )
                }
            )
            OutlinedTextField(value = confirmPassword,
                onValueChange = {confirmPassword = it},
                label = { Text(text = "Confirm Password") },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                }),
                visualTransformation = if (showPassword) VisualTransformation.None
                else PasswordVisualTransformation(),
                trailingIcon = {
                    Icon(
                        imageVector = if (showPassword) Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff,
                        contentDescription = "Show password",
                        modifier = Modifier.clickable {
                            showPassword = !showPassword
                        }
                    )
                }
            )
            Text(text = "Forgot Password?",
                modifier  = Modifier.padding(start = 150.dp),
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.primary,
                fontSize = 15.sp
            )

            Button(onClick = {
                             signUpWithEmailAndConfirmPass(auth, email, confirmPassword, context, navController)
            },
                modifier = Modifier
                    .width(290.dp)
                    .background(brush = brush, shape = RoundedCornerShape(15.dp)),
                shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)) {
                Text(text = "Sign Up")
            }

            Text(text = "--------------or login with ---------------",
                color = Color.Gray, fontSize = 15.sp
            )
            Row{
                Image(painter = painterResource(id = R.drawable.google_logo),
                    contentDescription = "Google Sign in",
                    modifier = Modifier.size(40.dp))
                Image(painter = painterResource(id = R.drawable.facebook_logo),
                    contentDescription = "Facebook Sign in",
                    modifier = Modifier.size(40.dp))
            }
            Row {
                Text(text = "Don't have an account? ", color = Color.DarkGray)
                Text(text = "Register",
                    style = TextStyle(brush = brush),
                    textDecoration = TextDecoration.Underline)
            }

        }
    }
}

fun signUpWithEmailAndConfirmPass(auth:FirebaseAuth,
                                  email:String,
                                  pass:String,
                                  context: Context,
                                  navController: NavController?){
    auth.createUserWithEmailAndPassword(email,pass)
        .addOnCompleteListener {
            if(it.isSuccessful){
                Toast.makeText(context, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                navController?.navigate("home")
            }else{
                Toast.makeText(context, "Authentication Failed", Toast.LENGTH_SHORT).show()
            }
        }
}

@Preview
@Composable
fun SignUpPreview(){
    SignUpScreen()
}