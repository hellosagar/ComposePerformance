package dev.sagar.composeperformance.module

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import dev.sagar.domainfixed.ContactInfoFixed

/**
 * ISSUE: Composable is taking a data class which is in a separate module.
 *
 * Things to get the class stable:
 * - Add dependency to Compose compiler runtime
 * - Mark the class Stable using the annotation(s) here in that case @Immutable
 */
@Composable
@Destination
fun ModuleFixedExample() {
  var isChecked by remember {
    mutableStateOf(false)
  }
  Column(
    modifier = Modifier
  ) {
    Checkbox(checked = isChecked, onCheckedChange = {
      isChecked = it
    })
    ContactModuleFixed(contact = ContactInfoFixed(name = "Sagar", number = 1234567890))
  }
}

@Composable
private fun ContactModuleFixed(contact: ContactInfoFixed) {
  Column {
    Text(text = contact.name)
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = "${contact.number}")
  }
}

/*
 Compiler report(s)
  -----------------------------------------------------------------------------------
  restartable skippable scheme("[androidx.compose.ui.UiComposable]") fun ContactModuleFixed(
    stable contact: ContactInfoFixed
  )
  -----------------------------------------------------------------------------------
 */
