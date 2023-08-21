package dev.sagar.domainfixed

import androidx.compose.runtime.Immutable

@Immutable
data class ContactInfoFixed(
  val name: String,
  val number: Int,
)
