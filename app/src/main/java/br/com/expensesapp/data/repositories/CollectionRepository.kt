package br.com.expensesapp.data.repositories

import br.com.expensesapp.data.CollectionDao
import br.com.expensesapp.data.models.Collection
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CollectionRepository @Inject constructor(private val collectionDao: CollectionDao){

    val getAllCollections: Flow<List<Collection>> = collectionDao.getAllCollections()

    fun getCollectionById(collectionId: Int): Flow<Collection> {
        return collectionDao.getCollectionById(collectionId);
    }

    suspend fun addCollection(collection: Collection) {
        collectionDao.addCollection(collection)
    }

    suspend fun updateCollection(collection: Collection) {
        collectionDao.updateCollection(collection)
    }

    suspend fun deleteCollection(collection: Collection) {
        collectionDao.deleteCollection(collection)
    }
}