package dev.sagar.composeperformance.runtimestability

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination

/**
 * ISSUE: Composable is taking ContactInfo type as param which is unstable because it's params are
 * defined as "var" which means it's mutable, and can be changed at runtime. So, its runtime stability
 * is Unstable and thus makes the composable non-skippable.
 *
 * SOLUTION:
 * 1. Make your param as "val" instead of "var
 */
@Composable
@Destination
fun RuntimeStabilityExample() {
  var isChecked by remember {
    mutableStateOf(false)
  }
  val contact = ContactInfo(name = "Sagar", number = 1234567890)
  Column(
    modifier = Modifier
  ) {
    Checkbox(checked = isChecked, onCheckedChange = {
      isChecked = it
    })
    Contact(contact = contact)
  }
}

@Composable
private fun Contact(contact: ContactInfo) {
  Column {
    Text(text = contact.name)
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = "${contact.number}")
  }
}

// ISSUE: Params are defined as "var" which means it's mutable, and can be changed at runtime.
private data class ContactInfo(
  var name: String,
  var number: Int,
)


/*
 Compiler generated anonymous class code from lambda.
 -----------------------------------------------------------------------------------
  unstable class ContactInfo {
    stable var name: String
    stable var number: Int
    <runtime stability> = Unstable
  }
 -----------------------------------------------------------------------------------
*/
