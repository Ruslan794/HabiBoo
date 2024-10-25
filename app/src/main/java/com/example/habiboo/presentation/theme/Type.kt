package com.example.habiboo.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.habiboo.R


val Poppins = FontFamily(
    Font(R.font.poppins_regular, weight = FontWeight.Normal),
    Font(R.font.poppins_bold, weight = FontWeight.Bold),
    Font(R.font.poppins_black, weight = FontWeight.Black),
    Font(R.font.poppins_light, weight = FontWeight.Light),
    Font(R.font.poppins_semi_bold, weight = FontWeight.SemiBold)
)

val SulphurPoint = FontFamily(
    Font(R.font.sulphur_point_regular, weight = FontWeight.Normal),
    Font(R.font.sulphur_point_bold, weight = FontWeight.Bold),
    Font(R.font.sulphur_point_light, weight = FontWeight.Light)
)

val mainTextStyleMin = TextStyle(
    fontFamily = Poppins,
    fontWeight = FontWeight.Normal
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = SulphurPoint,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)
