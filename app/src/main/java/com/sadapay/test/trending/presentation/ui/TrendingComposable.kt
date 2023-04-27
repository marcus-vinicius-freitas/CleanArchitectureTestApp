package com.sadapay.test.trending.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.sadapay.test.R
import com.sadapay.test.trending.domain.models.TrendingItemModel
import com.sadapay.test.trending.presentation.viewmodel.TrendingViewModel

@Composable
fun TrendingScreen(viewModel: TrendingViewModel) {
    val trendingReposState = viewModel.trendingReposState.value
    val loadingState = viewModel.loadingState.value
    var showMenu by remember { mutableStateOf(false) }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.trendingTitle))
                },
                actions = { 
                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }
                    ) {
                        Text(text = stringResource(id = R.string.settingsMenuTitle))
                    }
                }
            )
        }
    ) { contentPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding)
        ) {
            when {
                loadingState -> {
                    ShimmerLoadingAnimation()
                }
                trendingReposState == null -> {
                    ErrorScreen()
                }
                trendingReposState.items.isNotEmpty() -> {
                    TrendingReposList(repositories = trendingReposState.items)
                }
            }
        }
    }

    // Fetch the trending repositories when the screen is displayed
    LaunchedEffect(Unit) {
        viewModel.getTrendingRepos()
    }

}

@Composable
fun TrendingReposList(repositories: List<TrendingItemModel>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(repositories) { repository ->
            repository.name?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.subtitle1
                )
            }
        }
    }
}

@Composable
fun ErrorScreen() {
    Text(stringResource(id = R.string.error))
}

@Composable
fun ShimmerLoadingAnimation() {
    val colors = listOf(
        Color.LightGray.copy(alpha = 0.9f),
        Color.LightGray.copy(alpha = 0.5f),
        Color.LightGray.copy(alpha = 0.9f)
    )
}
