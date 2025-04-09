package co.feip.fefu2025.presentation.screen


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue


@Composable
fun RepositoryCardScreen(viewModel: RepositoryListViewModel) {
    val repositoryCard by viewModel.repositoryCard.collectAsState()

    repositoryCard?.let { card ->
        RepositoryCardContent(card)
    }
}