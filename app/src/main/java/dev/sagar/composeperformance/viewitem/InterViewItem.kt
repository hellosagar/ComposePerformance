package dev.sagar.composeperformance.viewitem

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Example showing that interfaces are not unstable by default
 */
interface ViewItemScratch {
  val identifier: Int
  val layoutId: Int

  fun add(): Int
  fun minus(): Int

  @SuppressLint("NotConstructor")
  @Composable
  fun ViewItem(
    lazyItemScope: LazyItemScope? = null,
    rowScope: RowScope? = null,
    columnScope: ColumnScope? = null
  ) {
  }
}


data class TitleViewItemScratch(
  val text: String,
  val index: Int,
  val modifier: Modifier = Modifier,
  override val identifier: Int = index
) : ViewItemScratch {
  override val layoutId: Int
    get() = index

  override fun add(): Int {
    return 2
  }

  override fun minus(): Int {
    return 1
  }

  @Composable
  override fun ViewItem(
    lazyItemScope: LazyItemScope?, rowScope: RowScope?, columnScope: ColumnScope?
  ) {
    Text(
      modifier = modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(horizontal = 16.dp),
      text = text,
    )
  }
}


@Composable
fun WithViewItemScratch(title: TitleViewItemScratch) {
  val selectionState: MutableList<ViewItemScratch> = remember {
    mutableStateListOf()
  }
  var isChecked by remember {
    mutableStateOf(false)
  }
  val onButtonClick = remember {
    {
      selectionState.add(
        TitleViewItemScratch(
          index = selectionState.size + 1,
          text = "Hello world #${selectionState.size + 1}",
          identifier = selectionState.size + 1,
        )
      )
    }
  }
  Column {
    Checkbox(checked = isChecked, onCheckedChange = {
      isChecked = it
    })
    Button(onClick = {
      onButtonClick.invoke()
    }) {
      Text(text = "Add")
    }
    val lsit = remember {
      listOf<String>("as  ", "asd")
    }
    interComp(viewItem = title)
    LazyColumn {
      items(
        items = selectionState,
        key = { viewItem: ViewItemScratch -> viewItem.identifier }
      ) { item ->
        interComp(viewItem = item)
      }
    }
  }
}

@Composable
fun interComp(viewItem: ViewItemScratch){
  viewItem.ViewItem()
}
