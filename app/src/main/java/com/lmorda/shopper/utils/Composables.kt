package com.lmorda.shopper.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun clickableSquareImage48dp(clickListener: () -> Unit) = Modifier
    .height(48.dp)
    .width(48.dp)
    .clickable(enabled = true, onClick = clickListener)


@Composable
fun verticalSpace8dp() {
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
fun verticalSpace16dp() {
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun verticalSpace64dp() {
    Spacer(modifier = Modifier.height(64.dp))
}