package com.example.main.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.main.R

@Composable
fun Dialog(
    modifier: Modifier,
    confirmPair: Pair<String, () -> Unit>,
    dismissPair: Pair<String, () -> Unit>?,
    showDialog: (Boolean) -> Unit,
    title: String,
    textInfo: String?,
    icon: (@Composable () -> Unit)? = null,
) {
    AlertDialog(
        onDismissRequest = { showDialog(false) },
        confirmButton = {
            Button(
                onClick = {
                    confirmPair.second()
                    showDialog(false)
                },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue_medium))
            ) {
                Text(
                    text = confirmPair.first,
                    color = Color.White,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }

        },
        dismissButton = {
            if (dismissPair != null) {
                OutlinedButton(
                    onClick = {
                        dismissPair.second
                        showDialog(false)
                    },
                    border = BorderStroke(1.dp, colorResource(id = R.color.blue_medium))
                ) {
                    Text(
                        text = dismissPair.first,
                        color = colorResource(id = R.color.blue_medium),
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                }
            }
        },

        title = {
            Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        },
        text = {
            if (textInfo != null) {
                Text(text = textInfo, fontSize = 16.sp,)
            }
        },
        modifier = modifier,
        icon = icon
    )
}


@Composable
@Preview
fun DialogPreview() {
    Dialog(
        modifier = Modifier.fillMaxWidth(1f),
        confirmPair = Pair("Sim", {}),
        dismissPair = Pair("Não", {}),
        showDialog = {},
        title = "Jorge",
        textInfo = "Bilonga do dodao",
        icon = {
            Icon(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "",
                tint = Color.Black,
                modifier = Modifier.size(32.dp)
            )
        }
    )
}