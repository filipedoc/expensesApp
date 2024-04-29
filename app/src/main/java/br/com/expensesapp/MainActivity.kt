package br.com.expensesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.expensesapp.navigation.ExpenseNavGraph
import br.com.expensesapp.ui.theme.ExpensesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpensesAppTheme {
                ExpenseNavGraph()
            }
        }
    }
}