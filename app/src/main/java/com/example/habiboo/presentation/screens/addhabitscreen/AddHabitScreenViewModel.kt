package com.example.habiboo.presentation.screens.addhabitscreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.habiboo.domain.model.Habit
import com.example.habiboo.domain.model.NotificationSettings
import java.time.LocalDateTime


class AddHabitScreenViewModel : ViewModel() {

    private val _name = mutableStateOf("")
    val name: State<String> = _name
    private val _note = mutableStateOf("")
    val note: State<String> = _note

    private val _notificationsEnabledChecked = mutableStateOf(false)
    val notificationsEnabledChecked: State<Boolean> = _notificationsEnabledChecked
    private val _nonDisabledNotificationsChecked = mutableStateOf(false)
    val nonDisabledNotificationsChecked: State<Boolean> = _nonDisabledNotificationsChecked
    private val _timedNotificationsEnabledChecked = mutableStateOf(false)
    val timedNotificationsEnabledChecked: State<Boolean> = _timedNotificationsEnabledChecked
    private val _randomNotificationsEnabledChecked = mutableStateOf(false)
    val randomNotificationsEnabledChecked: State<Boolean> = _randomNotificationsEnabledChecked
    private val _timePeriodNotificationsEnabled = mutableStateOf(true)
    val timePeriodNotificationsEnabled: State<Boolean> = _timePeriodNotificationsEnabled
    private val _exactTimeNotificationsEnabled = mutableStateOf(false)
    val exactTimeNotificationsEnabled: State<Boolean> = _exactTimeNotificationsEnabled

    private val _timePeriod = mutableIntStateOf(1)
    val timePeriod: State<Int> = _timePeriod
    private val _exactNotificationTime = mutableStateOf("0:00")
    val exactNotificationTime: State<String> = _exactNotificationTime

    fun createHabit() {
        val notificationSettings = NotificationSettings(
            notificationsEnabled = _notificationsEnabledChecked.value,
            nonDisabledNotificationsEnabled = _nonDisabledNotificationsChecked.value,
            timedNotificationsEnabled = _timedNotificationsEnabledChecked.value,
            randomNotificationsEnabled = _randomNotificationsEnabledChecked.value,
            timePeriodNotificationsEnabled = _timePeriodNotificationsEnabled.value,
            exactTimeNotificationsEnabled = _exactTimeNotificationsEnabled.value,
            timePeriod = _timePeriod.intValue.takeIf { _timePeriodNotificationsEnabled.value },
            exactNotificationTime = _exactNotificationTime.value.takeIf { _exactTimeNotificationsEnabled.value }
        )

        val habit = Habit(
            name = _name.value,
            note = _note.value,
            notifications = notificationSettings,
            dateOfCreation = LocalDateTime.now(),
        )
    }

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
        if (!_timedNotificationsEnabledChecked.value && !exactTimeOrTimePeriodNotificationsEnabled())
            _timePeriodNotificationsEnabled.value = true
        _timedNotificationsEnabledChecked.value = value
    }

    fun setRandomNotificationsEnabledChecked(value: Boolean) {
        _randomNotificationsEnabledChecked.value = value
    }

    fun setTimePeriodNotificationsEnabled(value: Boolean) {
        _timePeriodNotificationsEnabled.value = value
        if (!exactTimeOrTimePeriodNotificationsEnabled())
            setTimedNotificationsEnabledChecked(false)
    }

    fun setExactTimeNotificationsEnabled(value: Boolean) {
        _exactTimeNotificationsEnabled.value = value
        if (!exactTimeOrTimePeriodNotificationsEnabled())
            setTimedNotificationsEnabledChecked(false)
    }

    private fun exactTimeOrTimePeriodNotificationsEnabled(): Boolean {
        return !(!_exactTimeNotificationsEnabled.value && !_timePeriodNotificationsEnabled.value)
    }

    fun setTimePeriod(value: Int) {
        _timePeriod.value = value
    }

    fun setExactNotificationTime(value: String) {
        _exactNotificationTime.value = value
    }

    fun setName(value: String) {
        _name.value = value
    }

    fun setNote(value: String) {
        _note.value = value
    }
}