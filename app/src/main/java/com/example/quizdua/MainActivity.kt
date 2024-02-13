package com.example.quizdua

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizdua.ui.theme.QuizduaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizduaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HalamanLogin()
                }
            }
        }
    }
}

@Composable
fun HalamanLogin() {
    var nip by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .statusBarsPadding()
            .padding(horizontal = 20.dp)
            .padding(top = 20.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        val contex = LocalContext.current
        Image (
            painter = painterResource(R.drawable.dua_hati),
            null,
            modifier = Modifier
                .padding(bottom = 40.dp)
                .size(80.dp)
        )
        Text(
            text = stringResource(R.string.nip),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 5.dp)
        )
        EditNumberField(
            label = R.string.arn,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            value = nip,
            onValueChanged = { nip = it },
            modifier = Modifier
                .padding(bottom = 15.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20)),
            visualTransformation = VisualTransformation.None
        )
        Text(
            text = stringResource(R.string.password),
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 5.dp)
        )
        EditNumberField(
            label = R.string.bintang,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Send
            ),
            value = password,
            onValueChanged = { password = it },
            modifier = Modifier
                .padding(bottom = 25.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(20)),
            visualTransformation = PasswordVisualTransformation()
        )
        Button(
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            shape = RoundedCornerShape(15.dp),
        onClick = {
            cekPassword(nip, password, contex)
        },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.RoyalBlue))
        ) {
            Text(text = stringResource(R.string.login))
        }

        Text(
            text = stringResource(R.string.belum_bisa_akes),
            modifier = Modifier
                .padding(bottom = 20.dp)
        )

        ClickableText(
            text = AnnotatedString(stringResource(R.string.hubungi_cs_ikhwan)),
            modifier = Modifier
                .padding(bottom = 20.dp),
            style = TextStyle(color = colorResource(R.color.RoyalBlue), fontSize = 16.sp),
            onClick = {
                Toast.makeText(contex, R.string.menghubungi_cs_ikhwan,Toast.LENGTH_SHORT).show()
            }
        )
        ClickableText(
            text = AnnotatedString(stringResource(R.string.hubungi_cs_akhwat)),
            modifier = Modifier
                .padding(bottom = 20.dp),
            style = TextStyle(color = colorResource(R.color.RoyalBlue), fontSize = 16.sp),
            onClick = {
                Toast.makeText(contex, R.string.menghubungi_cs_akhwat,Toast.LENGTH_SHORT).show()
            }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
        }


        Row(
            modifier = Modifier
                .height(50.dp)
                .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(25)
                )
                .border(
                    width = 1.dp,
                    color = colorResource(R.color.RoyalBlue),
                    shape = RoundedCornerShape(25)
                )
                .fillMaxWidth()
                .clickable {
                    Toast
                        .makeText(contex, R.string.menuju_faq, Toast.LENGTH_SHORT)
                        .show()
                },
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = stringResource(R.string.faq),
                textAlign = TextAlign.Center,
                modifier = Modifier,
                color = colorResource(R.color.RoyalBlue)

            )
            Spacer(modifier = Modifier.padding(5.dp))
            Icon(
                imageVector = Icons.Rounded.ExitToApp,
                contentDescription = null,
                tint = colorResource(R.color.RoyalBlue)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
fun EditNumberField(
    @StringRes label: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation
) {
    TextField(
        value = value,
        singleLine = true,
        modifier = modifier,
        onValueChange = onValueChanged,
        placeholder = {
                    Text(
                        stringResource(label),
                        color = Color.Gray
                    )
                },
        keyboardOptions = keyboardOptions,
        textStyle = TextStyle(color = Color.DarkGray),
        visualTransformation = visualTransformation

    )
}

fun cekPassword(nip: String, password: String, contex: Context) {
    if (nip=="" && password=="") {
        Toast.makeText(contex, R.string.nip_dan_password,Toast.LENGTH_SHORT).show()
    } else if (nip=="") {
        Toast.makeText(contex, R.string.nip_harus_diisi,Toast.LENGTH_SHORT).show()
    } else if (password=="") {
        Toast.makeText(contex, R.string.password_harus_diisi,Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(contex, R.string.menuju_beranda,Toast.LENGTH_SHORT).show()
    }
}
@Preview(showBackground = true)
@Composable
fun LoginView() {
    QuizduaTheme {
        HalamanLogin()
    }
}