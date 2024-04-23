package br.com.expensesapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.expensesapp.data.models.Expense

@Database(entities = [Collection::class, Expense::class], version = 1, exportSchema = false)
abstract class MyRoomDatabase: RoomDatabase() {

    abstract fun collectionDao(): CollectionDao

    abstract fun  expenseDao(): ExpenseDao
}