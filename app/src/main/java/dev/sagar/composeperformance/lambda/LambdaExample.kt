package dev.sagar.composeperformance.lambda

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination

/**
 * ISSUE: Composable is taking a lambda as param and inside that param accessing the unstable
 * type class
 *
 * SOLUTION:
 * 1. Use a Method References
 * 2. Remembered Lambdas.
 */
@Composable
@Destination
fun LambdaExample() {
  val viewModel = remember {
    LambdaViewModel()
  }
  var isChecked by remember {
    mutableStateOf(false)
  }
  Column(
    modifier = Modifier
  ) {
    Checkbox(checked = isChecked, onCheckedChange = {
      isChecked = it
    })

    // ISSUE: Composable is taking a lambda as param and inside that param accessing the unstable
    Button(
      onClick = {
        viewModel.onClick()
      }) {
      Text(text = "Click Me")
    }
  }
}

/*
 Compiler report(s)
  -----------------------------------------------------------------------------------
  unstable class LambdaViewModel {
    unstable val _keys: MutableStateFlow<List<Int>>
    unstable val keys: MutableStateFlow<List<Int>>
    <runtime stability> = Unstable
  }
 -----------------------------------------------------------------------------------



 Compiler generated anonymous class code from lambda.
 -----------------------------------------------------------------------------------
  class OnClickLambda(val viewModel: LambdaViewModel) {
     operator fun invoke() {
         viewModel.onClick()
     }
  }
  -----------------------------------------------------------------------------------
 */

