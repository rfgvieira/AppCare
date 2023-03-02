package com.example.login.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.login.ui.login.LoginActivity
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.example.login.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
                Splash()
        }

        lifecycleScope.launch {
            delay(3000)
            goToLogin()
        }
    }

    private fun goToLogin(){
        startActivity(Intent(this, LoginActivity :: class.java))
    }

}


@Composable
fun Splash(){
    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.isStatusBarVisible = false

    Column(
        modifier  = Modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.blue_dark),
                        colorResource(id = R.color.blue_medium),
                        colorResource(id = R.color.blue_light),
                        colorResource(id = R.color.blue_medium),
                        colorResource(id = R.color.blue_dark)
                    )
                )
            )
            .fillMaxSize(1f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
            
    ){
        Image(
            painter = painterResource(id = R.drawable.health),
            contentDescription = "",
            modifier = Modifier
                .width(150.dp)
                .height(150.dp)
        )
        Text(
            "AppCare",
            color = colorResource(id = R.color.gray_light),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Slogan()
    }

}

@Composable
fun Slogan() {
    Text(
        stringResource(id = R.string.slogan),
        color = colorResource(id = R.color.gray_light),
        fontSize = 16.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .offset(0.dp, 8.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun SplashPreview(){
    Splash()
}
