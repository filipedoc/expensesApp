package br.com.expensesapp.navigation

import br.com.expensesapp.navigation.CollectionDestinationsArgs.COLLECTION_ID_ARG
import br.com.expensesapp.navigation.ExpenseScreens.ADD_COLLECTION_SCREEN
import br.com.expensesapp.navigation.ExpenseScreens.COLLECTIONS_SCREEN
import br.com.expensesapp.navigation.ExpenseScreens.COLLECTION_DETAIL_SCREEN

object ExpenseScreens {
    const val COLLECTIONS_SCREEN = "collections"
    const val ADD_COLLECTION_SCREEN = "addCollection"
    const val COLLECTION_DETAIL_SCREEN = "collection"
}

object CollectionDestinationsArgs {
    const val COLLECTION_ID_ARG = "collectionId"
}

object ExpenseDestinations {
    const val COLLECTIONS_ROUTE = COLLECTIONS_SCREEN
    const val ADD_COLLECTION_ROUTE = ADD_COLLECTION_SCREEN
    const val COLLECTION_DETAIL_ROUTE = "$COLLECTION_DETAIL_SCREEN/{$COLLECTION_ID_ARG}"

}