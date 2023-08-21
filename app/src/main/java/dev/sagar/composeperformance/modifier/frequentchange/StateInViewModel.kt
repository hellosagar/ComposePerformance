package dev.sagar.composeperformance.modifier.frequentchange

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class StateInViewModel: ViewModel() {

  private val _keys: MutableStateFlow<List<Int>> = MutableStateFlow(mutableListOf(1))
  val keys: MutableStateFlow<List<Int>> = _keys

  fun onClick() {
    _keys.value = _keys.value.toMutableList().apply {
      add(size + 1)
    }
  }

}
