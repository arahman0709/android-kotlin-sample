package com.lmorda.shopper.orders

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.lmorda.shopper.FOOD_ITEM_ID_ARG
import com.lmorda.shopper.R
import com.lmorda.shopper.data.CartApiService
import com.lmorda.shopper.data.models.FoodItem
import com.lmorda.shopper.data.models.Order
import com.lmorda.shopper.composables.clickableSquareImage48dp
import com.lmorda.shopper.composables.verticalSpace16dp
import com.lmorda.shopper.composables.verticalSpace64dp
import com.lmorda.shopper.composables.verticalSpace8dp
import com.lmorda.shopper.data.MockData.MOCK_ORDERS
import com.lmorda.shopper.utils.parseISO8601

@Composable
fun OrderItems(orderItems: List<Order>, navController: NavController? = null) {
    LazyColumn(
        Modifier.background(Color.White),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(20.dp)
    ) {
        itemsIndexed(orderItems) { index, order ->
            // Order title
            Text(text = order.storeName, color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            // Order description
            Text(text = """${order.items.size}  items delivered ${order.date.parseISO8601()}""",
                color = Color.Black, fontSize = 14.sp)
            verticalSpace8dp()
            // Images of food items ordered
            OrderImages(order, navController)
            // Add space below row if not last order
            if (index < orderItems.size - 1) verticalSpace16dp()
            else verticalSpace64dp()
        }
    }
}

@Composable
private fun OrderImages(order: Order, navController: NavController? = null) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        items(order.items) { foodItem ->
            OrderItemImage(foodItem, navController)
        }
    }
}

@Composable
private fun OrderItemImage(foodItem: FoodItem, navController: NavController? = null) {
    Image(
        painter = painterResource(id = foodItem.imageRes),
        contentDescription = stringResource(R.string.order_item_image),
        modifier = clickableSquareImage48dp(
            {
                navController?.let {
                    val bundle = bundleOf(FOOD_ITEM_ID_ARG to foodItem.id)
                    navController.navigate(R.id.action_ordersFragment_to_detailsFragment, bundle)
                }
            }
        )
    )
}

@Preview
@Composable
fun OrderItemsPreview() {
    OrderItems(orderItems = MOCK_ORDERS)
}