package br.com.expensesapp.data.repositories

import br.com.expensesapp.data.ExpenseDao
import br.com.expensesapp.data.models.Expense
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ExpenseRepository @Inject constructor(private val expenseDao: ExpenseDao){

    val getAllExpenses: Flow<List<Expense>> = expenseDao.getAllExpenses()

    fun getExpenseById(expenseId: Int): Flow<Expense> {
        return expenseDao.getExpenseById(expenseId)
    }

    suspend fun addExpense(expense: Expense) {
        expenseDao.addExpense(expense)
    }

    suspend fun updateExpense(expense: Expense) {
        expenseDao.updateExpense(expense)
    }

    suspend fun deleteExpense(expense: Expense) {
        expenseDao.deleteExpense(expense)
    }
}