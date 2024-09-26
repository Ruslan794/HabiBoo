package com.example.habiboo.presentation.screens.addhabitscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel


class AddHabitScreenViewModel : ViewModel() {

    private val _notificationsEnabledChecked = mutableStateOf(false)
    val notificationsEnabledChecked: State<Boolean> = _notificationsEnabledChecked
    private val _nonDisabledNotificationsChecked = mutableStateOf(false)
    val nonDisabledNotificationsChecked: State<Boolean> = _nonDisabledNotificationsChecked
    private val _timedNotificationsEnabledChecked = mutableStateOf(false)
    val timedNotificationsEnabledChecked: State<Boolean> = _timedNotificationsEnabledChecked
    private val _randomNotificationsEnabledChecked = mutableStateOf(false)
    val randomNotificationsEnabledChecked: State<Boolean> = _randomNotificationsEnabledChecked
    private val _timePeriodNotificationsEnabled = mutableStateOf(false)
    val timePeriodNotificationsEnabled: State<Boolean> = _timePeriodNotificationsEnabled
    private val _exactTimeNotificationsEnabled = mutableStateOf(false)
    val exactTimeNotificationsEnabled: State<Boolean> = _exactTimeNotificationsEnabled

    fun setNotificationsEnabledChecked(value: Boolean) {
        _notificationsEnabledChecked.value = value
        if (!value) {
            _nonDisabledNotificationsChecked.value = false
            _timedNotificationsEnabledChecked.value = false
            _randomNotificationsEnabledChecked.value = false
        }
    }

    fun setNonDisabledNotificationsChecked(value: Boolean) {
        _nonDisabledNotificationsChecked.value = value
    }

    fun setTimedNotificationsEnabledChecked(value: Boolean) {
        _timedNotificationsEnabledChecked.value = value
    }

    fun setRandomNotificationsEnabledChecked(value: Boolean) {
        _randomNotificationsEnabledChecked.value = value
    }

    fun setTimePeriodNotificationsEnabled(value: Boolean) {
        _timePeriodNotificationsEnabled.value = value
    }

    fun setExactTimeNotificationsEnabled(value: Boolean) {
        _exactTimeNotificationsEnabled.value = value
    }

    fun createHabit() {

    }
}