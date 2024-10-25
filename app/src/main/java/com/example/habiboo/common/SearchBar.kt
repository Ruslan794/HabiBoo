package com.example.habiboo.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.habiboo.R

@Composable
fun SearchBar() {
    val iconSize = 35.dp
    val colors = TextFieldDefaults.outlinedTextFieldColors(
        textColor = Color.Black,
        disabledTextColor = Color.Transparent,
        backgroundColor = Color.Transparent,  // Set background to transparent
        focusedBorderColor = Color.Transparent,
        unfocusedBorderColor = Color.Transparent,
        disabledBorderColor = Color.Transparent
    )

    OutlinedTextField(
        value = "",
        onValueChange = { },
        leadingIcon = {
            Image(
                painter = painterResource(R.drawable.search_icon),
                contentDescription = "Search icon",
                modifier = Modifier
                    .height(iconSize)
                    .width(iconSize)
                    .padding(5.dp),
                contentScale = ContentScale.Fit,
            )
        },
        trailingIcon = {
            Image(
                painter = painterResource(R.drawable.filter_icon),
                contentDescription = "Filter icon",
                modifier = Modifier
                    .height(iconSize)
                    .width(iconSize)
                    .padding(5.dp),
                contentScale = ContentScale.Fit,
            )
        },
        placeholder = { Text("Search room", fontSize = 18.sp) },
        singleLine = true,
        colors = colors,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 15.dp),  // Adjust horizontal padding if necessary
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            // Define the action on search press
        })
    )
}