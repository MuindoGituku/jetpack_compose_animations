import androidx.compose.animation.core.tween
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.muindogituku.assignment3.R
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BeatingHeartAnimation(navController: NavController) {
    val heartPainter: Painter = painterResource(id = R.drawable.smile)

    var forward by remember { mutableStateOf(true) }

    val scale by animateFloatAsState(
        targetValue = if (forward) 1.2f else 1f,
        animationSpec = tween(durationMillis = 1000), label = "Beating Heart Animation"
    )

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            forward = !forward
            println("Animated $forward")
        }
    }

    Scaffold (
        topBar = {
            TopAppBar(
                title = { Text(text = "Beating Heart Animation") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            shape = MaterialTheme.shapes.small,
        ) {
            Image(
                painter = heartPainter,
                contentDescription = "Beating Heart",
                modifier = Modifier
                    .scale(scale),
                alignment = Alignment.Center
            )
        }
    }
}