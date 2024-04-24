package br.com.expensesapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import br.com.expensesapp.data.models.Collection

@Dao
interface CollectionDao {

    @Query("SELECT * FROM collection")
    fun getAllCollections(): Flow<List<Collection>>

    @Query("SELECT * FROM collection WHERE id = :collectionId")
    fun getCollectionById(collectionId: Int): Flow<Collection>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCollection(collection: Collection)

    @Update
    suspend fun updateCollection(collection: Collection)

    @Delete
    suspend fun deleteCollection(collection: Collection)

}