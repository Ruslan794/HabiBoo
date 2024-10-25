import com.example.habiboo.domain.repository.AuthRepository
import javax.inject.Inject

class SignOutUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend fun execute(): Result<Unit> {
        return authRepository.signOut()
    }
}
