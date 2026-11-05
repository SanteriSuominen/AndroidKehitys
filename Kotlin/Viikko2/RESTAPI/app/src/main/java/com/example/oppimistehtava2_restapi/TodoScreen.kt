package com.example.oppimistehtava2_restapi

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.*

@Composable
fun TodoScreen(
    todoViewModel: TodoViewModel = viewModel()
) {
    val todos = todoViewModel.todos
    val isLoading = todoViewModel.isLoading
    val errorMessage = todoViewModel.errorMessage
    var selectedFilter by remember {
        mutableStateOf("All")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Todo Viewer",
            style = MaterialTheme.typography.headlineMedium
        )

        Button(
            onClick = {
                todoViewModel.loadTodos()
            },
            enabled = !isLoading
        ) {
            Text("Load todos")
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            listOf("All", "Completed", "Incomplete").forEach { filter ->
                FilterChip(
                    selected = selectedFilter == filter,
                    onClick = {
                        selectedFilter = filter
                    },
                    label = {
                        Text(filter)
                    }
                )
            }
        }

        val filteredTodos = when (selectedFilter) {
            "Completed" -> todos.filter { it.completed }
            "Incomplete" -> todos.filter { !it.completed }
            else -> todos
        }.take(20)

        if (isLoading) {
            CircularProgressIndicator()
        }

        if (errorMessage != null) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }

        Text(
            text = "Showing ${filteredTodos.size} of ${todos.size} tasks"
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(filteredTodos) { todo ->
                Column {
                    Text(
                        text = todo.title,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(
                        text = if (todo.completed) "Completed"
                        else "Not completed"
                    )
                }

                HorizontalDivider()
            }
        }
    }
}