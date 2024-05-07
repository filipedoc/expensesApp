package br.com.expensesapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import br.com.expensesapp.R
import br.com.expensesapp.data.TestData
import br.com.expensesapp.data.models.Collection
import br.com.expensesapp.viewmodels.CollectionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollectionsScreen(
    collectionViewModel: CollectionViewModel,
    onAddCollection: () -> Unit,
    onCollectionClick: (Collection) -> Unit,
) {

    LaunchedEffect(key1 = true){
        collectionViewModel.getAllCollections()
    }

    val allCollections = collectionViewModel.allCollections.collectAsState()

    Scaffold(
        topBar = {
                 TopAppBar(
                     modifier = Modifier.fillMaxWidth(),
                     title = {
                         Column {
                             Text(
                                 text = stringResource(id = R.string.collection_app_bar_title)
                             )
                             Text(
                                 text = stringResource(id = R.string.collection_app_bar_subtitle),
                                 style = TextStyle(fontSize = 15.sp)
                             )
                         } },
                     )
        },
        content = { innerPadding ->
            LazyColumn(modifier = Modifier.padding(innerPadding)) {
                items(TestData.collections){ collection ->
                    CollectionItem(
                        collection,
                        onCollectionClick
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddCollection) {
                Icon(Icons.Filled.Add, stringResource(id = R.string.add_collection))
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CollectionItem(
    collection: Collection,
    onCollectionClick: (Collection) -> Unit,
){
    Card(
        modifier = Modifier
        .padding(
            horizontal = dimensionResource(id = R.dimen.horizontal_margin_card_collections),
            vertical = dimensionResource(id = R.dimen.vertical_margin_card_collections)
        ),
        onClick = { onCollectionClick(collection) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = dimensionResource(id = R.dimen.horizontal_margin_row_collections),
                    vertical = dimensionResource(id = R.dimen.vertical_margin_row_collections),
                ),
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = collection.title,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(text = collection.description)

            }
            Checkbox(checked = false, onCheckedChange = {})
        }
    }
}

//@Preview
//@Composable
//fun CollectionsScreenPreview() {
//    CollectionsScreen(onCollectionClick = {}, onAddCollection = {})
//}