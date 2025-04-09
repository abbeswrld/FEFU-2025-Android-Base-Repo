package co.feip.fefu2025.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.feip.fefu2025.data.source.RepositoryCard
import co.feip.fefu2025.domain.usecase.GetRepositoryCardUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RepositoryListViewModel(
    private val getRepositoryCardUseCase: GetRepositoryCardUseCase
) : ViewModel() {

    private val _repositoryCard = MutableStateFlow<RepositoryCard?>(null)
    val repositoryCard: StateFlow<RepositoryCard?> = _repositoryCard

    init {
        loadCard()
    }

    private fun loadCard() {
        viewModelScope.launch {
            _repositoryCard.value = getRepositoryCardUseCase()
        }
    }
}