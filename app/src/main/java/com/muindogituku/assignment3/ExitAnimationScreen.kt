import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.muindogituku.assignment3.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterExitAnimationScreen(navController: NavController) {
    var isVisible by remember { mutableStateOf(false) }

    val offsetX by animateDpAsState(
        targetValue = if (isVisible) 0.dp else (-1000).dp,
        animationSpec = tween(durationMillis = 1000), label = ""
    )

    val offsetY by animateDpAsState(
        targetValue = if (isVisible) 0.dp else (-1000).dp,
        animationSpec = tween(durationMillis = 1000), label = ""
    )

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text = "Enter/Exit Animation") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (isVisible) {
                Image(
                    painter = painterResource(id = R.drawable.peace),
                    contentDescription = "Animation Image",
                    modifier = Modifier
                        .offset(x = offsetX)
                        .size(150.dp)
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.peace),
                    contentDescription = "Animation Image",
                    modifier = Modifier
                        .offset(y = offsetY)
                        .size(150.dp)
                )
            }

            Button(onClick = { isVisible = !isVisible }) {
                Text(text = if (isVisible) "Hide Image" else "Show Image")
            }
        }
    }
}
