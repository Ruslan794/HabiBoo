package com.example.habiboo.presentation.screens.loginscreen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habiboo.domain.repository.AuthRepository
import com.example.habiboo.domain.use_case.get_token.GetTokenUseCase
import com.example.habiboo.domain.use_case.save_token.SaveTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val saveTokenUseCase: SaveTokenUseCase,
    private val getTokenUseCase: GetTokenUseCase
) : ViewModel() {


    // Add a constant for log tag
    private val TAG = "LoginViewModel"


    private val _email = mutableStateOf("")
    val email: State<String> = _email
    private val _password = mutableStateOf("")
    val password: State<String> = _password

    // LiveData для управления состоянием загрузки
    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> get() = _loading

    // LiveData для отображения ошибок
    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    // LiveData для успешного входа
    private val _loginSuccess = MutableLiveData(false)
    val loginSuccess: LiveData<Boolean> get() = _loginSuccess

    // LiveData для проверки авторизации
    private val _isUserLoggedIn = MutableLiveData(false)
    val isUserLoggedIn: LiveData<Boolean> get() = _isUserLoggedIn

    init {
        // Check if there's already a saved token on initialization
        checkIfUserIsLoggedIn()
    }

    // Функция для выполнения входа
    fun login(email: String, password: String) {
        _loading.value = true
        _error.value = null

        // Log the start of the login process
        Log.d(TAG, "Attempting to login with email: $email")

        viewModelScope.launch {
            try {
                val response = authRepository.signIn(email, password)

                // Log the API response
                Log.d(TAG, "API Response: $response")

                if (response.isSuccessful) {
                    val authResponse = response.body()
                    authResponse?.let {
                        saveTokenUseCase(it.jwt)

                        // Log successful login and token
                        Log.d(TAG, "Login successful! JWT Token: ${it.jwt}")
                        _loginSuccess.value = true
                    }
                } else {
                    _error.value = "Login failed"

                    // Log failure details
                    Log.e(TAG, "Login failed with code: ${response.code()} and message: ${response.message()}")
                }
            } catch (e: Exception) {
                _error.value = e.message

                // Log any exception that occurs during login
                Log.e(TAG, "Exception during login: ${e.message}", e)
            } finally {
                _loading.value = false
                Log.d(TAG, "Login process completed")
            }
        }
    }

    fun onSingInBtnPress() {
        login(_email.value, _password.value)
     }

    // Функция для проверки, авторизован ли пользователь
    private fun checkIfUserIsLoggedIn() {
        viewModelScope.launch {
            val token = getTokenUseCase()
            if (!token.isNullOrEmpty()) {
                // If a token is present, consider the user logged in
                _isUserLoggedIn.value = true
                _loginSuccess.value = true

                // Log that the user is already logged in
                Log.d(TAG, "User is already logged in with token: $token")
            } else {
                // No token means the user is not logged in
                _isUserLoggedIn.value = false
            }
        }
    }

    fun setEmail(value:String){
        _email.value = value
    }

    fun setPassword(value:String){
        _password.value = value
    }

}