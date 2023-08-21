package dev.sagar.composeperformance.collections

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
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

/**
 * Composable demonstrating how to stabilize the param i.e Collection type (List<T>)
 * using a immutable list like kotlinx.collections.ImmutableList<T>.
 *
 *
 * Working of PersistentList:
 * - Modification operations return new instances of the persistent list
 * with the modification applied.
 *
 *
 * Converting the Iterable<T> to ImmutableList<T>, use the following
 * - Iterable<T>.toImmutableList(): ImmutableList<T>
 * - Iterable<T>.toImmutableSet(): ImmutableSet<T>
 *
 * Note: Minimum jetpack compose version required: Version 1.2, for the compiler to consider the
 * kotlinx.collections.ImmutableList<T> as stable.
 */
@Composable
fun CollectionSolutionKotlinx() {
  var isChecked by remember {
    mutableStateOf(false)
  }

  val contacts: ImmutableList<ContactInfoTwo> = remember {
    persistentListOf(
      ContactInfoTwo(name = "Sagar", number = 1234567890),
      ContactInfoTwo(name = "Khurana", number = 1234567890),
      ContactInfoTwo(name = "Foo", number = 1234567890),
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

/**
 * Passing the ImmutableList<T> as param to the composable.
 */
@Composable
private fun Contacts(contacts: ImmutableList<ContactInfoTwo>) {
  contacts.forEach { contact ->
    Contact(contact = contact)
  }
}

@Composable
private fun Contact(contact: ContactInfoTwo) {
  Column {
    Text(text = contact.name)
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = "${contact.number}")
  }
}

private data class ContactInfoTwo(
  val name: String,
  val number: Int,
)

/*
 Compiler report(s)
  -----------------------------------------------------------------------------------
  restartable skippable scheme("[androidx.compose.ui.UiComposable]") fun Contacts(
    stable contacts: ImmutableList<ContactInfoTwo>
  )
  -----------------------------------------------------------------------------------
 */
