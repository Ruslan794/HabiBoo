package com.example.habiboo.presentation.screens.addhabitscreen

import android.app.TimePickerDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.habiboo.presentation.navigation.NavDestination
import java.time.LocalTime

@Composable
fun AddHabitScreen(navController: NavHostController, vm: AddHabitScreenViewModel = viewModel()) {
    val scrollState = rememberScrollState()
    val nameIsEmpty by remember {
        derivedStateOf {
            vm.name.value.isEmpty()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 100.dp)
                .verticalScroll(scrollState)
        ) {

            OutlinedTextField(
                value = vm.name.value,
                onValueChange = { newName ->
                    if (newName.isNotEmpty()) {
                        val number = newName.length
                        if (number <= 20) {
                            vm.setName(newName)
                        }
                    }
                },
                label = { Text("Name", fontSize = 18.sp) },
                placeholder = { Text("Enter name of new habit", fontSize = 18.sp) },
                singleLine = true,
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp)),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            OutlinedTextField(
                value = vm.note.value,
                onValueChange = { newNote -> vm.setNote(newNote) },
                label = { Text("Note", fontSize = 18.sp) },
                shape = RoundedCornerShape(25.dp),
                placeholder = { Text("Enter note for your habit", fontSize = 18.sp) },
                modifier = Modifier
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            CheckBoxesBlock(vm)
        }

        Button(
            onClick = {
                vm.createHabit()
                navController.navigate(NavDestination.Home.route)
                      },
            Modifier
                .fillMaxWidth()
                .padding(vertical = 25.dp)
                .align(Alignment.BottomCenter),
            enabled = !nameIsEmpty
        ) {
            Text(text = "SAVE", fontSize = 18.sp)
        }
    }
}

@Composable
fun CheckBoxesBlock(vm: AddHabitScreenViewModel) {

    Column {
        SimpleCheckBox(
            title = "Enable Notifications",
            initialValue = vm.notificationsEnabledChecked.value,
            onCheckedChange = { newValue -> vm.setNotificationsEnabledChecked(newValue) }
        )

        SimpleCheckBox(
            title = "Enable Non-Disabled Notifications",
            initialValue = vm.nonDisabledNotificationsChecked.value,
            onCheckedChange = { newValue -> vm.setNonDisabledNotificationsChecked(newValue) },
            enabled = vm.notificationsEnabledChecked.value
        )

        SimpleCheckBox(
            title = "Enable Random Notifications",
            initialValue = vm.randomNotificationsEnabledChecked.value,
            onCheckedChange = { newValue -> vm.setRandomNotificationsEnabledChecked(newValue) },
            enabled = vm.notificationsEnabledChecked.value
        )

        SimpleCheckBox(
            title = "Enable Timed Notifications",
            initialValue = vm.timedNotificationsEnabledChecked.value,
            onCheckedChange = { newValue -> vm.setTimedNotificationsEnabledChecked(newValue) },
            enabled = vm.notificationsEnabledChecked.value
        )

        if (vm.timedNotificationsEnabledChecked.value) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(start = 20.dp)
            ) {
                Checkbox(
                    checked = vm.timePeriodNotificationsEnabled.value,
                    onCheckedChange = { vm.setTimePeriodNotificationsEnabled(it) }
                )
                Text(
                    text = "every",
                    fontSize = 18.sp
                )

                OutlinedTextField(
                    value = vm.timePeriod.value.toString(),
                    onValueChange = { newText ->
                        val sanitizedInput = newText.filter { it.isDigit() }
                        if (sanitizedInput.isNotEmpty()) {
                            val number = sanitizedInput.toInt()
                            if (number in 1..99) {
                               vm.setTimePeriod(sanitizedInput.toInt())
                            }
                        }
                    },
                    modifier = Modifier
                        .width(55.dp)
                        .height(50.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                    singleLine = true,
                )

                Text(text = "hours.", fontSize = 18.sp)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(start = 20.dp)
            ) {
                Checkbox(
                    checked = vm.exactTimeNotificationsEnabled.value,
                    onCheckedChange = { vm.setExactTimeNotificationsEnabled(it) }
                )
                Text(
                    text = "at:",
                    fontSize = 18.sp
                )
                MyTimePicker(vm)
            }
        }
    }
}

@Composable
fun SimpleCheckBox(
    title: String,
    initialValue: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    enabled: Boolean = true
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = initialValue,
            onCheckedChange = { newCheckedValue ->
                onCheckedChange(newCheckedValue)
            },
            enabled = enabled
        )
        Text(
            text = title,
            color = if (enabled) Color.Black else Color.Gray,
            modifier = Modifier.padding(start = 8.dp),
            fontSize = 18.sp
        )
    }
}

@Composable
fun MyTimePicker(vm:AddHabitScreenViewModel) {

    var time by remember { mutableStateOf(LocalTime.of(0, 0)) }
    val context = LocalContext.current

    val timePickerDialog = TimePickerDialog(
        context,
        { _, selectedHour, selectedMinute ->
            val updatedTime = LocalTime.of(selectedHour, selectedMinute)
            time = updatedTime
            vm.setExactNotificationTime("${updatedTime.hour}:${updatedTime.minute.toString().padStart(2, '0')}")
        },
        time.hour, time.minute, true
    )

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 25.dp)
    ) {
        Text(
            text = vm.exactNotificationTime.value ,
            fontSize = 18.sp
        )
        Button(onClick = { timePickerDialog.show() }) {
            Text(text = "Pick Time")
        }
    }
}
