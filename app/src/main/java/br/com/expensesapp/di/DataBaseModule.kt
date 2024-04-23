package br.com.expensesapp.di

import android.content.Context
import androidx.room.Room
import br.com.expensesapp.data.CollectionDao
import br.com.expensesapp.data.ExpenseDao
import br.com.expensesapp.data.MyRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        MyRoomDatabase::class.java,
        "Expenses.db"
    ).build()

    @Singleton
    @Provides
    fun provideCollectionDao(database: MyRoomDatabase): CollectionDao = database.collectionDao()

    @Singleton
    @Provides
    fun provideExpenseDao(database: MyRoomDatabase): ExpenseDao = database.expenseDao()

}