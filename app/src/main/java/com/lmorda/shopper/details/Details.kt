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
import com.lmorda.shopper.data.models.FoodCategory
import com.lmorda.shopper.data.models.FoodItem

@Preview
@Composable
fun FoodItemDetails(
    foodItem: FoodItem,
    backBtnListener: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
            contentDescription = "Food name",
            modifier = Modifier.padding(start = 16.dp),
        )
        Image(
            painter = painterResource(id = foodItem.imageRes),
            contentDescription = "Food name",
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 32.dp)
                .clickable(
                    enabled = true,
                    onClick = { backBtnListener() }
                )
        )
        Text(
            text = foodItem.name,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )
        Text(
            text = foodItem.price.toString(),
            fontSize = 22.sp,
            color = Color.Black,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
        )
    }
}

@Preview
@Composable
fun FoodItemDetailsPreview() {
    FoodItemDetails(
        FoodItem(
            id = 0,
            category = FoodCategory.MostPopular,
            name = "Hamburger",
            price = 5.99,
            imageRes = R.drawable.ic_baseline_fastfood_24
        )
    )
}