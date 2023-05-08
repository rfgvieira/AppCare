package com.example.login.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.R
import com.example.login.ui.login.components.*

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

        LoginTextField(R.string.email, 64, Modifier.fillMaxWidth())

        LoginTextField(R.string.name, 64, Modifier.fillMaxWidth())

        LoginTextField(R.string.patient_id, 12, Modifier.fillMaxWidth())

        LoginTextField(R.string.password, 100, Modifier.fillMaxWidth())

        LoginTextField(R.string.repassword, 100, Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(8.dp))
        
        LoginButton(
            clickFunction = { signUpClick() },
            modifier = Modifier.fillMaxWidth() ,
            text = stringResource(id = R.string.signup_caps)
        )

    }
}

private fun signUpClick(){

}



@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    SignUpScreen()
}