package dev.sagar.composeperformance.collections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination

/**
 * Composable demonstrating how to stabilize the param i.e Collection type (List<T>, Set<T>, etc)
 * using a data class annotated with stable annotation (@Immutable or @Stable) wrapping a List.
 *
 * Requirements for a type to be considered stable:
 * - The result of equals() will always return the same result for the same two instances
 * - When a public property of the type changes, Composition will be notified.
 * - All public property types are stable as well.
 *
 * `@Immutable vs @Stable annotation?
 *
 * `@`Immutable:
 * - Properties will never change once constructed.
 * - All primitive types (String, Int, Float, etc) are considered immutable and lambdas.
 *
 *
 * `@`Stable:
 * - Properties are mutable but compose runtime will be notified whenever anything changes.
 * - use State i.e mutableStateOf()
 *
 *
 */
@Composable
@Destination
fun CollectionExampleSolutionAnnotation() {
  var isChecked by remember {
    mutableStateOf(false)
  }
  val contacts: ContactInfoOneList = remember {
    ContactInfoOneList(
      contacts = listOf(
        ContactInfoOne(name = "Sagar", number = 1234567890),
        ContactInfoOne(name = "Khurana", number = 1234567890),
        ContactInfoOne(name = "Foo", number = 1234567890),
      )
    )
  }
  Column(
    modifier = Modifier
  ) {
    Checkbox(checked = isChecked, onCheckedChange = {
      isChecked = it
    })
    Contacts(contacts = contacts)
  }
}

@Composable
private fun Contacts(contacts: ContactInfoOneList) {
  contacts.contacts.forEach { contact ->
    Contact(contact = contact)
  }
}
@Immutable
private data class ContactInfoOneList(
  val contacts: List<ContactInfoOne>
)

@Composable
private fun Contact(contact: ContactInfoOne) {
  Column {
    Text(text = contact.name)
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = "${contact.number}")
  }
}

/**
 * Data class annotated with stable annotation wrapping a List.
 */


private data class ContactInfoOne(
  val name: String,
  val number: Int,
)
/*
` Compiler report(s)
  -----------------------------------------------------------------------------------
  restartable skippable scheme("[androidx.compose.ui.UiComposable]") fun Contacts(
    stable contacts: ContactInfoOneList
  )
  -----------------------------------------------------------------------------------
 */

