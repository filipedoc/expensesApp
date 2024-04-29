package br.com.expensesapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.expensesapp.data.repositories.CollectionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import br.com.expensesapp.data.models.Collection
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class CollectionViewModel @Inject constructor(
    private val repository: CollectionRepository
): ViewModel() {

    private val _allCollections = MutableStateFlow<List<Collection>>(emptyList())
    val allCollections: StateFlow<List<Collection>> = _allCollections
    fun getAllCollections() {
        viewModelScope.launch {
            repository.getAllCollections.collect{
                _allCollections.value = it
            }
        }
    }
}