package dev.sagar.composeperformance

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator
import dev.sagar.composeperformance.destinations.ClickableExampleDestination
import dev.sagar.composeperformance.destinations.ClickableFixDestination
import dev.sagar.composeperformance.destinations.CollectionExampleDestination
import dev.sagar.composeperformance.destinations.CollectionExampleSolutionAnnotationDestination
import dev.sagar.composeperformance.destinations.CollectionSolutionKotlinxDestination
import dev.sagar.composeperformance.destinations.DrawingExampleDestination
import dev.sagar.composeperformance.destinations.DrawingFixDestination
import dev.sagar.composeperformance.destinations.LambdaExampleDestination
import dev.sagar.composeperformance.destinations.LambdaExampleMethodReferenceDestination
import dev.sagar.composeperformance.destinations.LambdaExampleRememberDestination
import dev.sagar.composeperformance.destinations.LayoutExampleDestination
import dev.sagar.composeperformance.destinations.LayoutFixDestination
import dev.sagar.composeperformance.destinations.ModuleExampleDestination
import dev.sagar.composeperformance.destinations.ModuleFixedExampleDestination
import dev.sagar.composeperformance.destinations.RuntimeStabilityExampleDestination
import dev.sagar.composeperformance.destinations.RuntimeStabilityFixDestination

@Composable
@Destination
@RootNavGraph(start = true)
fun HomeScreen(
  navigator: DestinationsNavigator
) {
  val list = listOf(
    listOf(
      Sample(
        name = "Collections",
        onClick = {
          navigator.navigate(CollectionExampleDestination())
        }
      ),
      Sample(
        name = "Annotation",
        onClick = {
          navigator.navigate(CollectionExampleSolutionAnnotationDestination())
        }
      ),
      Sample(
        name = "KotlinX",
        onClick = {
          navigator.navigate(CollectionSolutionKotlinxDestination())
        }
      ),
    ),
    listOf(
      Sample(
        name = "Lambda",
        onClick = {
          navigator.navigate(LambdaExampleDestination())
        }
      ),
      Sample(
        name = "Remember",
        onClick = {
          navigator.navigate(LambdaExampleRememberDestination())
        }
      ),
      Sample(
        name = "Method Reference",
        onClick = {
          navigator.navigate(LambdaExampleMethodReferenceDestination())
        }
      ),
    ),
    listOf(
      Sample(
        name = "Clickable Modifier",
        onClick = {
          navigator.navigate(ClickableExampleDestination())
        }
      ),
      Sample(
        name = "Clickable Fix",
        onClick = {
          navigator.navigate(ClickableFixDestination())
        }
      ),
    ),
    listOf(
      Sample(
        name = "Drawing",
        onClick = {
          navigator.navigate(DrawingExampleDestination())
        }
      ),
      Sample(
        name = "Drawing Fix",
        onClick = {
          navigator.navigate(DrawingFixDestination())
        }
      ),
    ),
    listOf(
      Sample(
        name = "Layout",
        onClick = {
          navigator.navigate(LayoutExampleDestination())
        }
      ),
      Sample(
        name = "Layout Fix",
        onClick = {
          navigator.navigate(LayoutFixDestination())
        }
      ),
    ),
    listOf(
      Sample(
        name = "Separate Module",
        onClick = {
          navigator.navigate(ModuleExampleDestination())
        }
      ),
      Sample(
        name = "Separate Module Fix",
        onClick = {
          navigator.navigate(ModuleFixedExampleDestination())
        }
      ),
    ),
    listOf(
      Sample(
        name = "Runtime Stability",
        onClick = {
          navigator.navigate(RuntimeStabilityExampleDestination())
        }
      ),
      Sample(
        name = "Runtime Stability Fix",
        onClick = {
          navigator.navigate(RuntimeStabilityFixDestination())
        }
      )
    )
  )

  Spacer(modifier = Modifier.height(32.dp))
  Column {
    list.forEach { samples ->
      Spacer(modifier = Modifier.height(16.dp))
      Row(
        modifier = Modifier
          .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
      ) {
        samples.forEach { sample ->
          Button(onClick = sample.onClick) {
            Text(text = sample.name)
          }
        }
      }
      Spacer(modifier = Modifier.height(16.dp))
      Divider()
    }
  }
}

private data class Sample(
  val name: String,
  val onClick: () -> Unit,
)

@Composable
private fun HomeScreenPreview() {
  HomeScreen(EmptyDestinationsNavigator)
}
