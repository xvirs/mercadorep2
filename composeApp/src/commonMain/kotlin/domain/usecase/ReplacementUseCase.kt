package domain.usecase

import domain.interfaces.ReplacementRepositoryInterface

class ReplacementUseCase(private val repository : ReplacementRepositoryInterface) {

    suspend operator fun invoke() = repository.getReplacement()
}