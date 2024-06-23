package presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import api.AuthApiImpl
import backgroundColor
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import elementColor
import kotlinx.coroutines.launch
import model.LoginRequest

class LoginScreen : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val scope = rememberCoroutineScope()
        val isLoading = remember { mutableStateOf(false) }
        val isEnabled = remember { mutableStateOf(true) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
        ) {

            Spacer(modifier = Modifier.height(150.dp))

            Text(
                "Begin your Journey",
                color = Color.White,
                fontSize = 25.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )


            Spacer(modifier = Modifier.height(100.dp))

            val emailText = remember { mutableStateOf("") }

            RoundedCornerInputField(
                value = emailText.value,
                onValueChange = { emailText.value = it },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            val passwordText = remember { mutableStateOf("") }

            InvertedRoundedCornerInputField(
                value = passwordText.value,
                onValueChange = { passwordText.value = it },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(60.dp))

            if (isEnabled.value) {
                StrokedButton(
                    "Continue", onClick = {
                        isEnabled.value = false
                        isLoading.value = true
                        scope.launch {
                            val response =
                                AuthApiImpl().login(
                                    LoginRequest(
                                        emailText.value,
                                        passwordText.value
                                    )
                                )
                            isLoading.value = false
                            isEnabled.value = true

                            navigator.push(ResponseScreen(response))
                        }

                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            if (isLoading.value) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                        .align(Alignment.CenterHorizontally),
                    color = Color.White
                )
            }

        }

    }

}


@Composable
fun StrokedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    strokeColor: Color = Color.LightGray,
    contentColor: Color = Color.White,
) {
    Button(
        onClick = {
            onClick()

        },
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .border(
                BorderStroke(width = 1.dp, color = strokeColor),
                shape = RoundedCornerShape(16.dp)
            ).fillMaxWidth(0.6f),
        colors = ButtonDefaults.buttonColors(
            containerColor = elementColor,
            contentColor = contentColor
        )
    ) {
        Text(text = text)
    }

}

@Composable
fun RoundedCornerInputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.background(color = backgroundColor)) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .background(color = Color.White),
            placeholder = { Text("Email Address", color = Color.White) },
            colors = TextFieldDefaults.colors(
                cursorColor = Color.White
            )
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .border(
                    BorderStroke(width = 1.dp, color = Color.White),
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                )
        )
    }
}

@Composable
fun InvertedRoundedCornerInputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.background(color = backgroundColor)) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                .border(BorderStroke(width = 1.dp, color = elementColor)),
            placeholder = { Text("Password", color = Color.White) },
            colors = TextFieldDefaults.colors(
                cursorColor = Color.White
            )
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                .border(
                    BorderStroke(width = 1.dp, color = Color.White),
                    shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                )
        )
    }
}