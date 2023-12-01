package domain.interfaces.android

import domain.models.AutoParte
import kotlinx.coroutines.flow.Flow

interface ReplacementUseCaseInterfaceAndorid {
    suspend fun getReplacement() : Flow<List<AutoParte>>
}