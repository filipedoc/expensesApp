package br.com.expensesapp.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import br.com.expensesapp.data.models.Collection

@Composable
fun CollectionDetailScreen(
    collectionId: Int
) {
    Text(text = "$collectionId")
}