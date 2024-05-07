package br.com.expensesapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.expensesapp.navigation.CollectionDestinationsArgs.COLLECTION_ID_ARG
import br.com.expensesapp.navigation.ExpenseScreens.COLLECTION_DETAIL_SCREEN
import br.com.expensesapp.screens.CollectionDetailScreen
import br.com.expensesapp.screens.CollectionsAddScreen
import br.com.expensesapp.screens.CollectionsScreen
import br.com.expensesapp.viewmodels.CollectionViewModel

@Composable
fun ExpenseNavGraph(
    collectionViewModel: CollectionViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ExpenseDestinations.COLLECTIONS_ROUTE,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = ExpenseDestinations.COLLECTIONS_ROUTE){
            CollectionsScreen(
                collectionViewModel = collectionViewModel,
                onAddCollection = {
                    navController.navigate(route = ExpenseDestinations.ADD_COLLECTION_ROUTE)
                },
                onCollectionClick = {collection ->
                    navController.navigate("$COLLECTION_DETAIL_SCREEN/${collection.id}")
                }
            )
        }
        composable(route = ExpenseDestinations.ADD_COLLECTION_ROUTE){
            CollectionsAddScreen()
        }
        composable(
            route = ExpenseDestinations.COLLECTION_DETAIL_ROUTE,
            arguments = listOf(
                navArgument(COLLECTION_ID_ARG) { type = NavType.IntType }
            )
        ){entry ->
            entry.arguments?.getInt(COLLECTION_ID_ARG)?.let { collectionId ->
                CollectionDetailScreen(collectionId)
            }
        }
    }
}