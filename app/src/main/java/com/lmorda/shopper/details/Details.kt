package com.lmorda.shopper.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lmorda.shopper.R

@Preview
@Composable
//TODO: What should default values / tools be?
fun Details(
    imageResId: Int = R.drawable.ic_baseline_fastfood_24,
    backBtnListener: () -> Unit = {},
    foodName: String = "Food Name",
    price: String = "$9.99"
) {
    Column(
        Modifier.fillMaxSize().background(Color.White)
    ) {
        Spacer(Modifier.height(16.dp))
        Image(
            painterResource(id = R.drawable.ic_baseline_arrow_back_24),
            "Food name",
            Modifier
                .padding(start = 16.dp),
        )
        Image(
            painterResource(id = imageResId),
            "Food name",
            Modifier
                .height(200.dp)
                .width(200.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top=32.dp)
                .clickable (
                    enabled = true,
                    onClick = { backBtnListener() }
                )
        )
        Text(
            foodName,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )
        Text(
            price,
            fontSize = 22.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )
    }
}