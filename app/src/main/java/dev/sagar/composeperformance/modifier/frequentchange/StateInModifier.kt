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

@Composable
fun StateInModifier() {
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
        modifier = Modifier.clickable {
          keys.add(keys.size + 1)
        }, text = "item: $key"
      )
    }
  }
}
