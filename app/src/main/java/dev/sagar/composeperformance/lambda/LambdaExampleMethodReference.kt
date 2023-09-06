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
 * Example demonstrating how to stabilize the lambda param using the method reference.
 *
 * Reason why it works:
 * - Prevent the creation of a new class, which in turns reference unstable type class.
 * - Method references are @Stable functional types
 */
@Composable
@Destination
fun LambdaExampleMethodReference() {

  val viewModel: LambdaViewModel = remember {
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

    // SOLUTION: Use a Method References
    Button(onClick = viewModel::onClick) {
      Text(text = "Click Me")
    }
  }
}

