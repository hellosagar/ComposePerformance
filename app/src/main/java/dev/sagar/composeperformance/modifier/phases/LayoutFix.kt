package dev.sagar.composeperformance.modifier.phases

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import com.ramcosta.composedestinations.annotation.Destination
import dev.sagar.composeperformance.ui.theme.ComposePerformanceTheme

/**
 *
 * ISSUE: Composable modifier's param is changing frequently, that it is causing the composable
 * to recompose.
 *
 * SOLUTION: Localize the phase to the lowest possible level. I this case, the Offset changes
 * the placement of the composable. So we can use the localize it Layout phase by using the
 * offset modifier lambda version  where The lambda block we provide to the modifier is invoked during
 * the layout phase (specifically, during the layout phase's placement step).
 * 
 */
@Composable
@Destination
fun LayoutFix() {
  var isShown by remember {
    mutableStateOf(false)
  }
  val offset by animateIntAsState(if (isShown) 0 else 300, animationSpec(isShown))
  Column(
    modifier = Modifier
  ) {
    Button(
      onClick = {
        isShown = !isShown
      }) {
      Text(text = "Toggle Text")
    }
    // Optimized
    Text(
      text = "Hello #2",
      modifier = Modifier.offset {
        // The `offsetX` state is read in the placement step
        // of the layout phase when the offset is calculated.
        // Changes in `offsetX` restart the layout.
        IntOffset(offset, offset)
      }
    )
  }
}

private fun <T> animationSpec(animate: Boolean): AnimationSpec<T> = if (animate) {
  spring(dampingRatio = Spring.DampingRatioLowBouncy, stiffness = Spring.StiffnessLow)
} else {
  TweenSpec(durationMillis = 0)
}

@Preview(showBackground = true)
@Composable
private fun LayoutExamplePreview() {
  ComposePerformanceTheme {
    LayoutExample()
  }
}
