package br.com.expensesapp.data

import br.com.expensesapp.data.models.Collection

object TestData {
    val collections: List<Collection> = listOf(
        Collection(
            1,
            "Janeiro",
            "Contas de Janeiro"
        ),
        Collection(
            2,
            "Fevereiro",
            "Contas de Fevereiro"
        ),
        Collection(
            3,
            "Março",
            "Contas de Março"
        )
    )
}