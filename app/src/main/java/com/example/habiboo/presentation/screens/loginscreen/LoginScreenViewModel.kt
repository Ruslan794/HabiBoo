package com.example.habiboo.presentation.screens.loginscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habiboo.domain.repository.AuthRepository
import com.example.habiboo.domain.use_case.get_token.GetTokenUseCase
import com.example.habiboo.domain.use_case.save_token.SaveTokenUseCase
import kotlinx.coroutines.launch

class LoginScreenViewModel(
    private val authRepository: AuthRepository,
    private val saveTokenUseCase: SaveTokenUseCase,
    private val getTokenUseCase: GetTokenUseCase
) : ViewModel() {

    // LiveData для управления состоянием загрузки
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    // LiveData для отображения ошибок
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    // LiveData для успешного входа
    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean> get() = _loginSuccess

    // LiveData для проверки авторизации
    private val _isUserLoggedIn = MutableLiveData<Boolean>()
    val isUserLoggedIn: LiveData<Boolean> get() = _isUserLoggedIn

    // Функция для выполнения входа
    fun login(email: String, password: String) {
        _loading.value = true
        _error.value = null

        viewModelScope.launch {
            val result = authRepository.signIn(email, password)
            _loading.value = false

            if (result.isSuccess) {
                val jwtToken = result.getOrNull()
                if (jwtToken != null) {
                    // Сохраняем токен
                    saveTokenUseCase(jwtToken.toString())
                    _loginSuccess.value = true
                }
            } else {
                _error.value = result.exceptionOrNull()?.message ?: "Unknown error"
                _loginSuccess.value = false
            }
        }
    }

    // Функция для проверки, авторизован ли пользователь
    fun checkIfUserIsLoggedIn() {
        viewModelScope.launch {
            val token = getTokenUseCase()
            _isUserLoggedIn.value = token != null // true, если токен есть
        }
    }

}