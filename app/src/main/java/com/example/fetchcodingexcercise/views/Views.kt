package com.example.fetchcodingexcercise.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.fetchcodingexcercise.ui.theme.FetchItem
import com.example.fetchcodingexcercise.viewmodel.FetchViewModel

@Composable
fun ItemList(viewModel: FetchViewModel, modifier: Modifier = Modifier) {
    val value by remember{viewModel.readAll}
    Box(modifier) {
        LazyColumn(Modifier.fillMaxWidth()) {
            items(value) { fitem ->
                FetchItemRow(item = fitem)
            }
        }


    }
}

@Composable
fun FetchItemRow(item: FetchItem, modifier: Modifier = Modifier) {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround) {
        Text(text = "ID: " + item.id.toString(),
            fontSize = 16.sp)
        Text(text = "ListID: " + item.listId.toString(),
            fontSize = 16.sp)
        Text(text = "Name: " + item.name,
            fontSize = 16.sp)
    }
}

@Preview
@Composable
fun ItemListPreview() {
    val items = mutableListOf<FetchItem>()
    items.add(FetchItem(1,1,"one"))
    items.add(FetchItem(2,2,"two"))
    items.add(FetchItem(3,3,"three"))
//    ItemList(fetchItem = items)
}

@Preview
@Composable
fun FetchItemRowPeview() {
    val fetchItem = FetchItem(1,1,"one")
    FetchItemRow(item = fetchItem)
}