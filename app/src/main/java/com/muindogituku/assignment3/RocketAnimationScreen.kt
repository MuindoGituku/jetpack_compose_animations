import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.muindogituku.assignment3.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RocketAnimationScreen(navController: NavController) {
    var isLaunching by remember { mutableStateOf(false) }
    val transition = updateTransition(!isLaunching, label = "Combined Transition")

    val rocketPositionAnim by transition.animateDp(
        transitionSpec = { tween(durationMillis = 5000) }, label = "Position Animation",
    ) { launched ->
        if (launched) 0.dp else (-600).dp
    }

    val rocketSizeAnim by transition.animateDp(
        transitionSpec = { tween(durationMillis = 5000) }, label = "Size Animation",
    ) { launched ->
        if (launched) 2.dp else 0.3.dp
    }

    val launchRocket: () -> Unit = {
        isLaunching = !isLaunching
    }

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text = "Rocket Animation") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.rocket_ship),
                contentDescription = "Rocket",
                modifier = Modifier
                    .offset(y = rocketPositionAnim)
                    .size((rocketSizeAnim * 150))
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = launchRocket) {
                Text(
                    if (isLaunching) "Land Rocket" else "Launch Rocket",
                    fontSize = 20.sp
                )
            }
        }
    }
}