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

/**
 * ISSUE: Composable is taking a data class which is in a separate module.
 * Thus, compose compiler  cannot infer the stability of this class.
 * As such it declares it as unstable.
 *
 * SOLUTION:
 * 1. Create UI model in the app module + maps functions()
 * 2. Don't pass data class argument if primitives are enough.
 * 3.  Enable the Compose compiler and make the data classes stable using the Stable annotation(s).
 * However it will just be the dependency for the compose runtime and not for Compose-UI.
 */
@Composable
fun ModuleExample() {
  println("ModuleExample")
  var isChecked by remember {
    mutableStateOf(false)
  }
  val contacts: List<ContactInfo> = remember {
    mutableStateListOf(
      ContactInfo(name = "Sagar", number = 1234567890),
      ContactInfo(name = "Khurana", number = 1234567890),
      ContactInfo(name = "Foo", number = 1234567890),
    )
  }
  Column(
    modifier = Modifier
  ) {
    Checkbox(checked = isChecked, onCheckedChange = {
      isChecked = it
    })
    ContactsModule(contacts = contacts)
  }
}

@Composable
private fun ContactsModule(contacts: List<ContactInfo>){
  contacts.forEach { contact ->
    ContactModule(contact = contact)
  }
}

// ISSUE: Composable is taking a data class which is in a seperate module. The Compose compiler
// cannot infer the stability of this class. As such it declares it as unstable.
@Composable
private fun ContactModule(contact: ContactInfo) {
  Column {
    Text(text = contact.name)
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = "${contact.number}")
  }
}

/*
 Compiler report(s)
  -----------------------------------------------------------------------------------
  restartable scheme("[androidx.compose.ui.UiComposable]") fun ContactModule(
    unstable contact: ContactInfo
  )
  -----------------------------------------------------------------------------------
 */
