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
import dev.sagar.domain.ContactInfo
import dev.sagar.domainfixed.ContactInfoFixed

/**
 * ISSUE: Composable is taking a data class which is in a separate module.
 *
 * Things to get the class stable:
 * - Add dependency to Compose compiler runtime
 * - Mark the class Stable using the annotation(s) here in that case @Immutable
 */
@Composable
fun ModuleFixedExample() {
  var isChecked by remember {
    mutableStateOf(false)
  }
  val contacts: List<ContactInfoFixed> = remember {
    mutableStateListOf(
      ContactInfoFixed(name = "Sagar", number = 1234567890),
      ContactInfoFixed(name = "Khurana", number = 1234567890),
      ContactInfoFixed(name = "Foo", number = 1234567890),
    )
  }
  Column(
    modifier = Modifier
  ) {
    Checkbox(checked = isChecked, onCheckedChange = {
      isChecked = it
    })
    ContactsModuleFixed(contacts = contacts)
  }
}

@Composable
private fun ContactsModuleFixed(contacts: List<ContactInfoFixed>){
  contacts.forEach { contact ->
    ContactModuleFixed(contact = contact)
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
