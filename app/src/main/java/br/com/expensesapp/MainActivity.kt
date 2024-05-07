package br.com.expensesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import br.com.expensesapp.navigation.ExpenseNavGraph
import br.com.expensesapp.ui.theme.ExpensesAppTheme
import br.com.expensesapp.viewmodels.CollectionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val collectionViewModel: CollectionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpensesAppTheme {
                ExpenseNavGraph(collectionViewModel)
            }
        }
    }
}