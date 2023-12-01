package domain.usecase

import domain.interfaces.ReplacementRepositoryInterface
import domain.models.StatusResult

class ReplacementUseCase(private val repository : ReplacementRepositoryInterface) {

    suspend operator fun invoke() =
        when(val response = repository.getReplacement()){
            is StatusResult.Error -> StatusResult.Error(response.message)
            is StatusResult.Success -> StatusResult.Success(response.value)
        }
}