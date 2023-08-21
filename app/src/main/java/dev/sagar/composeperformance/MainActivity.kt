package dev.sagar.composeperformance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import dev.sagar.composeperformance.module.ModuleExample
import dev.sagar.composeperformance.ui.theme.ComposePerformanceTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposePerformanceTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Row {
//            DrawingExample()
//            LayoutExample()
//            RuntimeStabilityExample()
//            CollectionExample()
//            CollectionExampleSolutionOne()
//            CollectionExampleSolutionTwo()
            ModuleExample()
//            ModuleFixedExample()
//            StateInModifier()
//            StateInModifierSolnOne()
//            StateInModifierSolnTwo()
//            LambdaExample()
//            LambdaExampleFix()
//            LambdaExampleTwoFix()
          }
        }
      }
    }
  }
}
