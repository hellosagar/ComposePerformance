package dev.sagar.composeperformance.modifier.frequentchange

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.ramcosta.composedestinations.annotation.Destination

/**
 * Using the Modifier.clickable() in a remember block which returns the same modifier everytime
 * and avoid recompositions.
 */

@Composable
@Destination
fun ClickableFix() {
  val state = rememberLazyListState()

  // Solution: Put the Modifier in remember block
  val keys = remember {
    mutableStateListOf(1)
  }
  val onClickModifier = remember {
    Modifier.clickable { keys.add(keys.size + 1) }.testTag("clickable")
  }
  LazyColumn(state = state) {
    items(
      items = keys,
      key = { key ->
        key
      }
    ) { key ->
      Text(
        modifier = onClickModifier, text = "item: $key"
      )
    }
  }
}
