package com.lmorda.shopper.data

import com.lmorda.shopper.R
import kotlinx.coroutines.delay

class CartApiService {
    companion object {
        val MOCK_STATUSES = listOf(
            "Verifying payment card",
            "Processing order",
            "Order complete!"
        )
    }

    val MOCK_CART = mutableListOf<FoodItem>()
    val MOCK_STORE_ITEMS =
        listOf(
            StoreItems(
                listOf(
                    FoodItem(0, 5.49, "Jim's Ground Beef", R.drawable.cow),
                    FoodItem(1, 3.99, "Wurth Ketchup", R.drawable.ketchup),
                    FoodItem(2, 5.20, "King Hamburger Buns", R.drawable.buns),
                    FoodItem(3, 4.20, "Organic Mozarella Cheese", R.drawable.cheese),
                    FoodItem(4, 4.49, "Organic Valley Apples", R.drawable.apple),
                    FoodItem(5, 2.99, "Whole Wheat Bread", R.drawable.bread),
                    FoodItem(6, 2.50, "Elite Coffee Beans", R.drawable.coffee_beans),
                    FoodItem(7, 6.75, "Best Eggs", R.drawable.egg),
                    FoodItem(8, 5.49, "Organic Whole Milk", R.drawable.milk_bottle),
                    FoodItem(9, 7.99, "Bananas from Ecuador", R.drawable.banana),
                ), 2
            ),
            StoreItems(
                listOf(
                    FoodItem(10, 4.99, "Dark Chocolate", R.drawable.chocolate),
                    FoodItem(11, 3.49, "Celery Bunch", R.drawable.celery),
                    FoodItem(12, 6.00, "Broccoli Florets", R.drawable.broccoli),
                    FoodItem(13, 6.00, "Lettuce Head", R.drawable.lettuce),
                    FoodItem(14, 2.29, "Lemon Bag", R.drawable.lemon),
                    FoodItem(15, 3.39, "Florida Oranges", R.drawable.orange),
                    FoodItem(16, 2.00, "Cherry Tomatoes", R.drawable.tomato),
                    FoodItem(17, 5.00, "Whole Wheat Spaghetti", R.drawable.spaghetti),
                    FoodItem(18, 4.59, "Cookies", R.drawable.cookie),
                    FoodItem(19, 3.00, "Chicken Drumsticks", R.drawable.chicken_leg),
                ), 3
            ),
            StoreItems(
                listOf(
                    FoodItem(20, 3.00, "Irish Golden Butter", R.drawable.butter),
                    FoodItem(21, 1.49, "Bluberry Muffins", R.drawable.muffin),
                    FoodItem(22, 2.49, "Super Healthy Cereal", R.drawable.cereals),
                    FoodItem(23, 2.99, "Protein Bar", R.drawable.bar),
                    FoodItem(24, 4.00, "Hard Taco Shells", R.drawable.taco),
                    FoodItem(25, 4.50, "Strawberry Basket", R.drawable.strawberry),
                    FoodItem(26, 3.50, "Sugar Free Soda", R.drawable.soda),
                    FoodItem(27, 5.20, "Crinkle Cut French Fries", R.drawable.french_fries),
                    FoodItem(28, 6.00, "Cheesebuger", R.drawable.burger),
                    FoodItem(29, 7.30, "Dozen Donuts", R.drawable.donut),
                    FoodItem(30, 7.00, "Pepperoni Pizza", R.drawable.pizza),
                ), null
            ),
        )

    var MOCK_ORDER_STATUS_STEP = 0
    val MOCK_API_DELAY = 0L

    suspend fun getStoreItems(pageNum: Int): StoreItems {
        delay(MOCK_API_DELAY)
        return MOCK_STORE_ITEMS[pageNum - 1]
    }

    suspend fun createOrder(items: List<FoodItem>): Boolean {
        delay(MOCK_API_DELAY)
        MOCK_CART.clear()
        MOCK_CART.addAll(items)
        return true
    }

    suspend fun getCartItems(): List<FoodItem> {
        delay(MOCK_API_DELAY)
        return MOCK_CART
    }

    suspend fun getOrderTotal(): Double {
        delay(MOCK_API_DELAY)
        return MOCK_CART.sumOf { it.price }
    }

    suspend fun getOrderStatus(): String {
        delay(MOCK_API_DELAY)
        val status = MOCK_STATUSES[MOCK_ORDER_STATUS_STEP]
        MOCK_ORDER_STATUS_STEP++
        if (MOCK_ORDER_STATUS_STEP == MOCK_STATUSES.size)
            MOCK_ORDER_STATUS_STEP = 0
        return status
    }

}