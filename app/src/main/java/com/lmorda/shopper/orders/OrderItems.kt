package com.lmorda.shopper.orders

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lmorda.shopper.R
import com.lmorda.shopper.data.models.FoodItem
import com.lmorda.shopper.data.models.Order

@Preview
@Composable
fun OrderItems(orderItems: List<Order>) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp), contentPadding = PaddingValues(12.dp)) {
        items(orderItems) { orderItem ->
            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items (orderItem.items) { foodItem ->
                    Image(
                        painter = painterResource(id = foodItem.imageRes),
                        contentDescription = stringResource(R.string.order_item_image),
                        Modifier.height(48.dp).width(48.dp)
                    )
                }
            }
        }
    }
}