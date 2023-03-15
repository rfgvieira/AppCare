package com.example.login.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.R

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top


    ) {

        Spacer(modifier = Modifier.height(160.dp))
        
        Image(painter = painterResource(id = R.drawable.health),
            contentDescription = "",
            Modifier.size(150.dp)
        )

        Text(text = stringResource(id = R.string.app_name),
            color = Color.White,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        EmailTextField()

        Spacer(modifier = Modifier.height(16.dp))

        PasswordTextField()

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White, 
                backgroundColor = colorResource(id = R.color.red)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ){
            Text(
                text = stringResource(id = R.string.login_caps),
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 6.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.esqueceu_senha),
            color = Color.White
        )
    }
}

@Composable
fun PasswordTextField() {
    var passwordTextState by remember {
        mutableStateOf("")
    }

    TextField(
        value = passwordTextState,
        onValueChange = {
            if(it.length <= 64)
                passwordTextState = it
        },
        singleLine = true,
        label = {
            Text(
                text = stringResource(id = R.string.password),
                color = colorResource(id = R.color.red))
        },
        colors = TextFieldDefaults.textFieldColors(
            cursorColor = colorResource(id = R.color.red),
            focusedIndicatorColor = colorResource(id = R.color.red)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)

    )
}


@Composable
fun EmailTextField() {
    var emailTextState by remember {
        mutableStateOf("")
    }
    TextField(
        value = emailTextState,
        label = {
            Text(
                text = stringResource(id = R.string.email),
                color = colorResource(id = R.color.red)
            )
        },
        onValueChange = {
            if(it.length <= 64)
                emailTextState = it
        },
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth(),
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(cursorColor = colorResource(id = R.color.red),
            focusedIndicatorColor = colorResource(id = R.color.red)
        )
    )
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginPreview() {
        LoginScreen()
}