package co.feip.fefu2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import co.feip.fefu2025.data.repository.RepositoryCardImpl
//import co.feip.fefu2025.data.repository.RepositoryImpl
//import co.feip.fefu2025.domain.usecase.GetRepositoriesUseCase
import co.feip.fefu2025.domain.usecase.GetRepositoryCardUseCase
import co.feip.fefu2025.presentation.screen.RepositoryCardScreen
//import co.feip.fefu2025.presentation.screen.RepositoryListScreen
import co.feip.fefu2025.presentation.screen.RepositoryListViewModel
import co.feip.fefu2025.ui.theme.FEFU2025AndroidBaseRepoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FEFU2025AndroidBaseRepoTheme {
                val repository = RepositoryCardImpl()
                val useCase = GetRepositoryCardUseCase(repository)
                val viewModel = RepositoryListViewModel(useCase)

                RepositoryCardScreen(viewModel = viewModel)

//               val repository = RepositoryImpl()
//               val useCase = GetRepositoriesUseCase(repository)
//                val viewModel = RepositoryListViewModel(useCase)

//                RepositoryListScreen(viewModel = viewModel)
            }
        }
    }
}
