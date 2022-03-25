package com.lmorda.shopper.orders

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lmorda.shopper.R
import com.lmorda.shopper.data.CartApiService
import com.lmorda.shopper.data.models.FoodItem
import com.lmorda.shopper.data.models.Order

@Composable
fun OrderItems(orderItems: List<Order>) {
    LazyColumn(
        Modifier.background(Color.White),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(12.dp)
    ) {

        itemsIndexed(orderItems) { index, order ->
            // Order title
            Text(text = order.storeName)

            // Order description
            val description = """${order.items.size}  * items Delivered ${order.date}"""
            Text(text = description)

            // Images of food items ordered
            OrderImages(order)

            // Add space below row if not last order
            if (index > orderItems.size - 1) Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@Composable
private fun OrderImages(order: Order) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        items(order.items) { foodItem ->
            OrderItemImage(foodItem)
        }
    }
}

@Composable
private fun OrderItemImage(foodItem: FoodItem) {
    Image(
        painter = painterResource(id = foodItem.imageRes),
        contentDescription = stringResource(R.string.order_item_image),
        modifier = imageModifier()
    )
}

@Composable
private fun imageModifier() = Modifier
    .height(48.dp)
    .width(48.dp)

@Preview
@Composable
fun OrderItemsPreview() {
    OrderItems(orderItems = CartApiService.MOCK_ORDERS)
}