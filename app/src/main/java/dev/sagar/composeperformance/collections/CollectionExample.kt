package dev.sagar.composeperformance.collections

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

/**
 * ISSUE: Composable is taking a List<T> (Collection Type) as param which is a interface. The Compose compiler cannot be
 * sure of the immutability of this class as it just sees the declared type and as such declares it as unstable.
 *
 *
 * SOLUTION:
 * 1. Use a immutable list like kotlinx.collections.ImmutableList<T>.
 * 2. Use a data class annotated with stable annotation wrapping a List.
 */
@Composable
@Destination
fun CollectionExample() {
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
    Contacts(contacts = contacts)
  }
}


// ISSUE: Composable is taking a List<T> (Collection Type) as param which is a interface.
@Composable
private fun Contacts(contacts: List<ContactInfo>){
  contacts.forEach { contact ->
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

private data class ContactInfo(
  val name: String,
  val number: Int,
)


/*
 Compiler report(s)
  -----------------------------------------------------------------------------------
  restartable scheme("[androidx.compose.ui.UiComposable]") fun Contacts(
    unstable contacts: List<ContactInfo>
  )
  -----------------------------------------------------------------------------------
 */
