package dev.sagar.composeperformance.lambda

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class LambdaViewModel: ViewModel() {

  private val _keys: MutableStateFlow<List<Int>> = MutableStateFlow(mutableListOf(1))
  val keys: MutableStateFlow<List<Int>> = _keys

    fun onClick() {
      println("Clicked on Button")
    }
}
