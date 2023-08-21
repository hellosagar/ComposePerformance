package dev.sagar.domain

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Composable
private fun MeinkyuBtau() {
  Text(
    "Mein kyu btau"
  )
}

data class ContactInfo(
  val name: String,
  val number: Int,
)
