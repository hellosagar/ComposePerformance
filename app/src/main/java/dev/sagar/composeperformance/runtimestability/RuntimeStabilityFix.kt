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

@Composable
@Destination
fun RuntimeStabilityFix() {
  var isChecked by remember {
    mutableStateOf(false)
  }
  val contact = ContactInfoFix(name = "Sagar", number = 1234567890)
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
private fun Contact(contact: ContactInfoFix) {
  Column {
    Text(text = contact.name)
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = "${contact.number}")
  }
}

// Solution: Params are defined as "val" which means it's immutable, and makes the runtime stability stable
private data class ContactInfoFix(
  val name: String,
  val number: Int,
)


/*
 Compiler generated anonymous class code from lambda.
 -----------------------------------------------------------------------------------
  stable class ContactInfoFix {
    stable var name: String
    stable var number: Int
    <runtime stability> = Stable
  }
 -----------------------------------------------------------------------------------
*/
