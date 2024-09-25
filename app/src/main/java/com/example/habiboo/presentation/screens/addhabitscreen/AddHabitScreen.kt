package com.example.habiboo.presentation.screens.addhabitscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.habiboo.presentation.theme.SoftPink80


@Composable
fun AddHabitScreen(navController: NavHostController, vm: AddHabitScreenViewModel = viewModel()) {
    val scrollState = rememberScrollState()

    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 15.dp, vertical = 40.dp)
            .verticalScroll(scrollState)
            .background(color = SoftPink80)
    ) {
        Text(text = "NAME")
        Text(text = "NOTE...  ....  ....")
        CheckBoxesBlock(vm)
    }
}

@Composable
fun CheckBoxesBlock(vm: AddHabitScreenViewModel) {
    val notificationsEnabledChecked by vm.notificationsEnabledChecked
    val nonDisabledNotificationsChecked by vm.nonDisabledNotificationsChecked
    val timedNotificationsEnabledChecked by vm.timedNotificationsEnabledChecked
    val randomNotificationsEnabledChecked by vm.randomNotificationsEnabledChecked
    val timePeriodNotificationsEnabled by vm.timePeriodNotificationsEnabled
    val exactTimeNotificationsEnabled by vm.exactTimeNotificationsEnabled

    var textFieldText by remember { mutableStateOf("") }

    Column {
        SimpleCheckBox(
            title = "Enable Notifications",
            initialValue = notificationsEnabledChecked,
            onCheckedChange = { newValue -> vm.setNotificationsEnabledChecked(newValue) }
        )

        SimpleCheckBox(
            title = "Enable Non-Disabled Notifications",
            initialValue = nonDisabledNotificationsChecked,
            onCheckedChange = { newValue -> vm.setNonDisabledNotificationsChecked(newValue) },
            enabled = notificationsEnabledChecked
        )

        SimpleCheckBox(
            title = "Enable Random Notifications",
            initialValue = randomNotificationsEnabledChecked,
            onCheckedChange = { newValue -> vm.setRandomNotificationsEnabledChecked(newValue) },
            enabled = notificationsEnabledChecked
        )

        SimpleCheckBox(
            title = "Enable Timed Notifications",
            initialValue = timedNotificationsEnabledChecked,
            onCheckedChange = { newValue -> vm.setTimedNotificationsEnabledChecked(newValue) },
            enabled = notificationsEnabledChecked
        )

        if (timedNotificationsEnabledChecked) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(start = 20.dp)
            ) {
                Checkbox(
                    checked = timePeriodNotificationsEnabled,
                    onCheckedChange = { vm.setTimePeriodNotificationsEnabled(it)}
                )
                Text(
                    text = "every",
                )

                TextField(
                    value = textFieldText,
                    onValueChange = { newText -> textFieldText = newText },
                    Modifier.width(35.dp).height(30.dp)
                )
                Text(text = "hours.")
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(start = 20.dp)
            ) {
                Checkbox(
                    checked = exactTimeNotificationsEnabled,
                    onCheckedChange = { vm.setExactTimeNotificationsEnabled(it)}
                )
                Text(
                    text = "at:",
                )
                //add time picker and list od dates
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
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}