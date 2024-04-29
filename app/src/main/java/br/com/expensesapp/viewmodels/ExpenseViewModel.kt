package br.com.expensesapp.viewmodels

import androidx.lifecycle.ViewModel
import br.com.expensesapp.data.repositories.CollectionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExpenseViewModel @Inject constructor(
    private val repository: CollectionRepository
): ViewModel() {

}
