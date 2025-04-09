package co.feip.fefu2025.domain.repository

import co.feip.fefu2025.data.source.RepositoryCard

interface RepositoryCardRepository {
    fun getRepositoryCard(): RepositoryCard
}