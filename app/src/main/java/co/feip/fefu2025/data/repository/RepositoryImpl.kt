package co.feip.fefu2025.data.repository

import co.feip.fefu2025.R
import co.feip.fefu2025.data.source.Repository
import co.feip.fefu2025.domain.repository.RepositoryRepository

class RepositoryImpl : RepositoryRepository {
    override fun getRepositories(): List<Repository> {
        return listOf(
            Repository("wyborn666", "My repository", "120", "32", R.drawable.me),
            Repository("AlexMarchu", "Teacher of the Pacific Design School", "3400", "320", R.drawable.icon_rep1),
            Repository("sxmurxy0", "Minecraft cheats and puzzles", "2750", "450", R.drawable.icon_rep2),
        )
    }

    override fun getStarredRepositories(): List<Repository> {
        return listOf(
            Repository("AlexMarchu", "Teacher of the Pacific Design School", "3400", "320", R.drawable.icon_rep1),
            Repository("sxmurxy0", "Minecraft cheats and puzzles", "2750", "450", R.drawable.icon_rep2),
        )
    }
}