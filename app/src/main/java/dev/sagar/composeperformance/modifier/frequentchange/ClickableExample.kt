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
import com.ramcosta.composedestinations.annotation.Destination

/**
 * ISSUE: Modifier.Clickable{} is a composed modifier.
 *
 * Why its not skippable?
 * - Composable functions that return values are not skippable.
 * - Composed modifier Composable lambda returns a value (Modifier). Due to which on every
 * recomposition a new instance of Modifier is returned and thus recompositions of composable.
 *
 * Checkout the issue tracker for more details.
 * - https://issuetracker.google.com/issues/241154852#
 * - https://issuetracker.google.com/issues/206021557#comment2
 * - https://stackoverflow.com/questions/76059969/why-this-code-is-causing-recomposition-jetpack-compose
 *
 * SOLUTION:
 * 1. Put the Modifier in remember block
 * 2. Use the Modifier as singleton
 */
@Composable
@Destination
fun ClickableExample() {
  val state = rememberLazyListState()
  val keys = remember {
    mutableStateListOf(1)
  }
  LazyColumn(state = state) {
    items(
      items = keys,
      key = { key ->
        key
      }
    ) { key ->
      Text(
        // ISSUE: Clickable using composed modifier.
        modifier = Modifier.clickable {
          keys.add(keys.size + 1)
        }, text = "item: $key"
      )
    }
  }
}
