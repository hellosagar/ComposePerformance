package dev.sagar.composeperformance.modifier.frequentchange

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun StateInModifierSolnTwo(
  viewModel: StateInViewModel = viewModel()
) {
  val state = rememberLazyListState()
  val keys: List<Int> by viewModel.keys.collectAsState()
  val onClick = remember() { { viewModel.onClick() } }
  LazyColumn(state = state) {
    items(
      items = keys,
      key = { key ->
        key
      }
    ) { key ->
      Text(
        modifier = Modifier
          .clickable{
            onClick.invoke()
          }, text = "item: $key"
      )
    }
  }
}
