import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.LoginScreen


val backgroundColor = Color(0xFFF18181B)
val elementColor = Color(0xFFF27272A)

@Composable
@Preview
fun App() {

    val darkColors = darkColorScheme(
        primary = backgroundColor,
    )


    MaterialTheme(colorScheme = darkColors) {
        Navigator(LoginScreen()) {
            SlideTransition(it)
        }
    }
}
