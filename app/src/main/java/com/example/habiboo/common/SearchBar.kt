package com.example.habiboo.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habiboo.R

@Composable
fun SearchBar() {
    val iconSize = 24.dp // Уменьшил размер иконок для более аккуратного вида
    val cornerRadius = 16.dp // Радиус скругления углов
    val shadowElevation = 8.dp // Высота тени

    OutlinedTextField(
        value = "",
        onValueChange = { },
        leadingIcon = {
            Image(
                painter = painterResource(R.drawable.search_icon),
                contentDescription = "Search icon",
                modifier = Modifier
                    .height(iconSize)
                    .width(iconSize),
                contentScale = ContentScale.Fit,
            )
        },
        trailingIcon = {
            Image(
                painter = painterResource(R.drawable.filter_icon),
                contentDescription = "Filter icon",
                modifier = Modifier
                    .height(iconSize)
                    .width(iconSize),
                contentScale = ContentScale.Fit,
            )
        },
        placeholder = { Text("Search room", fontSize = 16.sp) },
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.White, // Устанавливаем белый фон
            cursorColor = Color.Black,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent,
            errorBorderColor = Color.Transparent,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 20.dp)
            .shadow(
                elevation = shadowElevation,
                shape = RoundedCornerShape(cornerRadius),
                clip = true
            ),
        shape = RoundedCornerShape(cornerRadius), // Скругляем углы
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            // Define the action on search press
        })
    )
}