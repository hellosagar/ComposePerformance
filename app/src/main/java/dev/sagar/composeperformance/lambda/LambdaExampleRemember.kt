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
 * Example demonstrating how to stabilize the lambda param using the remember block.
 *
 * Reason why it works:
 * - Remember the lambda instance between recompositions.
 * Ensure the exact same instance of the lambda.
 * 
 * P.S: Tip: When remembering a lambda, pass any captured variables as keys
 * to remember so that the lambda will be recreated if those variables change.
 *
 */
@Composable
@Destination
fun LambdaExampleRemember() {

  val viewModel: LambdaViewModel = remember {
    LambdaViewModel()
  }
  val onClick = remember(viewModel) {
    { viewModel.onClick() }
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

    Button(onClick = {
      onClick.invoke()
    }) {
      Text(text = "Click Me")
    }
  }
}

