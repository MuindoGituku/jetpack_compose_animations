import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.keyframes
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaleAnimationButton(navController: NavController) {
    var isScaled by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isScaled) 2f else 1f,
        animationSpec = keyframes {
            durationMillis = 1000
            0.0f at 0
            1.2f at 300
            1.5f at 600
            1.0f at 900
        }, label = ""
    )

   Scaffold (
       topBar = {
           TopAppBar(
               title = { Text(text = "Scale Animation Screen") },
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
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = { isScaled = !isScaled },
                modifier = Modifier
                    .padding(16.dp)
                    .graphicsLayer(scaleX = scale, scaleY = scale)
            ) {
                Text(text = "Scale Animation Button")
            }
        }
    }
}