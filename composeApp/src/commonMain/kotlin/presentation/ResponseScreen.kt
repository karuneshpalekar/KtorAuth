package presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import backgroundColor
import cafe.adriel.voyager.core.screen.Screen
import model.UserAuthResponse

class ResponseScreen(val response: UserAuthResponse) : Screen {

    @Composable
    override fun Content() {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
        ) {

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                "ID",
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(horizontal = 12.dp)

            )

            response.id?.let { id ->
                Text(
                    id,
                    color = Color.White,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))


            Text(
                "UserName",
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(horizontal = 12.dp)

            )

            response.username?.let { name ->
                Text(
                    name,
                    color = Color.White,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                )
            }


            Spacer(modifier = Modifier.height(20.dp))


            Text(
                "Access Token",
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(horizontal = 12.dp)

            )

            response.accessToken?.let { aToken ->
                Text(
                    aToken,
                    color = Color.White,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                )
            }


            Spacer(modifier = Modifier.height(20.dp))

            Text(
                "Refresh Token",
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(horizontal = 12.dp)

            )

            response.refreshToken?.let { rToken ->
                Text(
                    rToken,
                    color = Color.White,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                )
            }


        }

    }

}