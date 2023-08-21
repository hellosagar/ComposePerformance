package dev.sagar.composeperformance.modifier.phases

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import dev.sagar.composeperformance.ui.theme.ComposePerformanceTheme

/**
 *
 * ISSUE: Composable modifier's param is changing frequently, that it is causing the composable
 * to recompose.
 *
 * SOLUTION: Localize the phase to the lowest possible level. I this case, the animationSpec
 * only changing the value of the alpha. So we can use the localize it to drawing phase by using the
 * graphicsLayer modifier instead of alpha modifier which triggers the recompositions for the composable.
 */
@Composable
fun DrawingExample() {
  var isShown by remember {
    mutableStateOf(false)
  }
  val opacity by animateFloatAsState(if (isShown) 0f else 0.5f, animationSpec(isShown))
  Column(
    modifier = Modifier
  ) {
    Button(
      onClick = {
        isShown = !isShown
      }) {
      Text(text = "Toggle Text")
    }

    // Unoptimized
    Text(text = "Hello World! #1", modifier = Modifier.alpha(opacity))
    // Optimized
    Text(text = "Hello World! #2", modifier = Modifier.graphicsLayer { alpha = opacity })
  }
}

private fun <T> animationSpec(animate: Boolean): AnimationSpec<T> = if (animate) {
  spring(dampingRatio = Spring.DampingRatioLowBouncy, stiffness = Spring.StiffnessLow)
} else {
  TweenSpec(durationMillis = 0)
}

@Preview(showBackground = true)
@Composable
private fun ExampleOnePreview() {
  ComposePerformanceTheme {
    DrawingExample()
  }
}
