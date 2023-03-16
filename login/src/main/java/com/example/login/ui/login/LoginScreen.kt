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
import com.example.login.ui.login.textfields.PasswordTextField
import com.example.login.ui.login.textfields.EmailTextField as EmailTextField

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp,Alignment.Top)
    ) {

        Spacer(modifier = Modifier.height(80.dp))
        
        Image(painter = painterResource(id = R.drawable.health),
            contentDescription = "",
            Modifier.size(150.dp)
        )

        Text(text = stringResource(id = R.string.app_name),
            color = Color.White,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        EmailTextField()

        PasswordTextField(stringResource(id = R.string.password))

        Spacer(modifier = Modifier.height(8.dp))

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
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

        Text(
            text = stringResource(id = R.string.esqueceu_senha),
            color = Color.White
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginPreview() {
        LoginScreen()
}