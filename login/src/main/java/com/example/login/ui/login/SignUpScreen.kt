package com.example.login.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.example.login.ui.login.textfields.EmailTextField
import com.example.login.ui.login.textfields.NameTextField
import com.example.login.ui.login.textfields.PasswordTextField
import com.example.login.ui.login.textfields.PatientIdTextField

@Composable
fun SignUpScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp,Alignment.Top)
    ) {

        Spacer(Modifier.height(80.dp))

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

        NameTextField()

        PatientIdTextField()

        PasswordTextField(stringResource(id = R.string.password))
        
        PasswordTextField(stringResource(id = R.string.repassword))

        Spacer(modifier = Modifier.height(8.dp))
        
        Button(
            onClick = {},
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.red),
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()

        ) {
            Text(
                text = stringResource(id = R.string.signup_caps),
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }

    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    SignUpScreen()
}