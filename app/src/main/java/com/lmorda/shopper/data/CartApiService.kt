package com.lmorda.shopper.data

import com.lmorda.shopper.ORDER_COMPLETE
import com.lmorda.shopper.R
import com.lmorda.shopper.data.models.*
import com.lmorda.shopper.data.models.FoodCategory.*
import com.lmorda.shopper.utils.Loug
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class CartApiService() {
    companion object {
        val MOCK_STATUSES = listOf(
            "Verifying payment card",
            "Processing order",
            ORDER_COMPLETE
        )
    }

    val MOCK_CART = mutableListOf<FoodItem>()
    val MOCK_STORE_ITEMS =
        listOf(
                FoodItem(0, 5.49, "Jim's Ground Beef", R.drawable.cow, RecommendedForYou),
                FoodItem(1, 3.99, "Wurth Ketchup", R.drawable.ketchup, RecommendedForYou),
                FoodItem(2, 5.20, "King Hamburger Buns", R.drawable.buns, RecommendedForYou),
                FoodItem(3, 4.20, "Organic Mozarella Cheese", R.drawable.cheese, RecommendedForYou),
                FoodItem(4, 4.49, "Organic Valley Apples", R.drawable.apple, MostPopular),
                FoodItem(5, 2.99, "Whole Wheat Bread", R.drawable.bread, MostPopular),
                FoodItem(6, 2.50, "Elite Coffee Beans", R.drawable.coffee_beans, MostPopular),
                FoodItem(7, 6.75, "Best Eggs", R.drawable.egg, MostPopular),
                FoodItem(8, 5.49, "Organic Whole Milk", R.drawable.milk_bottle, MostPopular),
                FoodItem(9, 7.99, "Bananas from Ecuador", R.drawable.banana, MostPopular),
                FoodItem(10, 4.99, "Dark Chocolate", R.drawable.chocolate, WhatsNew),
                FoodItem(11, 3.49, "Celery Bunch", R.drawable.celery, WhatsNew),
                FoodItem(12, 6.00, "Broccoli Florets", R.drawable.broccoli, WhatsNew),
                FoodItem(13, 6.00, "Lettuce Head", R.drawable.lettuce, WhatsNew),
                FoodItem(14, 2.29, "Lemon Bag", R.drawable.lemon, WhatsNew),
                FoodItem(15, 3.39, "Florida Oranges", R.drawable.orange, WhatsNew),
                FoodItem(16, 2.00, "Cherry Tomatoes", R.drawable.tomato, RecommendedForYou),
                FoodItem(17, 5.00, "Whole Wheat Spaghetti", R.drawable.spaghetti, RecommendedForYou),
                FoodItem(18, 4.59, "Cookies", R.drawable.cookie, RecommendedForYou),
                FoodItem(19, 3.00, "Chicken Drumsticks", R.drawable.chicken_leg, RecommendedForYou),
                FoodItem(20, 3.00, "Irish Golden Butter", R.drawable.butter, RecommendedForYou),
                FoodItem(21, 1.49, "Bluberry Muffins", R.drawable.muffin, WhatsNew),
                FoodItem(22, 2.49, "Super Healthy Cereal", R.drawable.cereals, WhatsNew),
                FoodItem(23, 2.99, "Protein Bar", R.drawable.bar, WhatsNew),
                FoodItem(24, 4.00, "Hard Taco Shells", R.drawable.taco, MostPopular),
                FoodItem(25, 4.50, "Strawberry Basket", R.drawable.strawberry, MostPopular),
                FoodItem(26, 3.50, "Sugar Free Soda", R.drawable.soda, MostPopular),
                FoodItem(27, 5.20, "Crinkle Cut French Fries", R.drawable.french_fries, MostPopular),
                FoodItem(28, 6.00, "Cheesebuger", R.drawable.burger, MostPopular),
                FoodItem(29, 7.30, "Dozen Donuts", R.drawable.donut, MostPopular),
                FoodItem(30, 7.00, "Pepperoni Pizza", R.drawable.pizza, MostPopular),
        )
    val MOCK_PREVIOUSLY_BOUGHT = listOf(
            StoreItems(items = MOCK_STORE_ITEMS.subList(0, 10), nextPage = 2),
            StoreItems(items = MOCK_STORE_ITEMS.subList(10, 20), nextPage = null)
        )
        
    var MOCK_ORDER_STATUS_STEP = 0
    val MOCK_API_DELAY = 0L
    val MOCK_ARRIVAL_UPDATE_DELAY = 10000L
    val MOCK_ORDER_NUM = 0
    val MOCK_ARRIVALS = listOf(
        Arrival(
            orderNum = MOCK_ORDER_NUM,
            status = "Confirming your order",
            arrivalFirst = "2021-11-01T14:47:00Z",
            arrivalSecond = "2021-11-01T14:57:00Z",
            statusDetails = "We sent your order to Jons for final confirmation.",
            storeName = "Jons"
        ),
        Arrival(
            orderNum = MOCK_ORDER_NUM,
            status = "Order confirmed",
            arrivalFirst = "2021-11-01T14:49:00Z",
            arrivalSecond = "2021-11-01T14:54:00Z",
            statusDetails = "Order confirmed. Driver is waiting for your order.",
            storeName = "Jons"
        )
    )
    val MOCK_ORDERS = listOf(
        Order(
            orderNum = 0,
            date = "2021-11-01T14:49:00Z",
            items = listOf(MOCK_STORE_ITEMS[0], MOCK_STORE_ITEMS[1],
                MOCK_STORE_ITEMS[2], MOCK_STORE_ITEMS[3], MOCK_STORE_ITEMS[4], MOCK_STORE_ITEMS[5]),
            total = 123.39
        ),
        Order(
            orderNum = 0,
            date = "2021-12-01T14:49:00Z",
            items = listOf(MOCK_STORE_ITEMS[10], MOCK_STORE_ITEMS[11],
                MOCK_STORE_ITEMS[12], MOCK_STORE_ITEMS[13], MOCK_STORE_ITEMS[14], MOCK_STORE_ITEMS[15]),
            total = 67.44

        )
    )

    /**
     * Get a list of food items at a store (only one store right now!)
     */
    suspend fun getStoreItems(category: FoodCategory): List<FoodItem> {
        Loug.d("shopper", "GET /v1/store/items?category=$category")
        delay(MOCK_API_DELAY)
        Loug.d("shopper", "SUCCESS /v1/store/items?category=$category\n" +
                MOCK_STORE_ITEMS.filter { it.category == category })
        return MOCK_STORE_ITEMS.filter { it.category == category }
    }

    /**
     * Get a list of food items a user can buy again
     */
    suspend fun getPreviousItems(pageNum: Int): StoreItems {
        Loug.d("shopper", "GET /v1/store/items/previous")
        delay(MOCK_API_DELAY)
        Loug.d("shopper", "SUCCESS /v1/store/previous\n" + MOCK_PREVIOUSLY_BOUGHT[pageNum - 1])
        return MOCK_PREVIOUSLY_BOUGHT[pageNum - 1]
    }

    /**
     * Get the details about a food item
     */
    suspend fun getFoodItemDetails(foodItemId: Int?): FoodItem? {
        Loug.d("shopper", "GET /v1/store/items/" + foodItemId)
        delay(MOCK_API_DELAY)
        Loug.d(
            "shopper",
            "SUCCESS /v1/store/items/\n" + foodItemId + " " +
                    MOCK_STORE_ITEMS.find { it.id == foodItemId })
        return MOCK_STORE_ITEMS.find { it.id == foodItemId }
    }

    /**
     * Get summary of all orders
     */
    suspend fun getOrders(): List<Order> {
        Loug.d("shopper", "GET /v1/store/orders")
        Loug.d("shopper", MOCK_ORDERS.toString())
        Loug.d("shopper", "SUCCESS /v1/order")
        delay(MOCK_API_DELAY)
        return MOCK_ORDERS
    }

    /**
     * Create a new order
     */
    suspend fun createOrder(): Boolean {
        Loug.d("shopper", "POST /v1/order")
        delay(MOCK_API_DELAY)
        Loug.d("shopper", "SUCCESS /v1/order")
        return true
    }

    /**
     * Add ad item to the cart
     */
    suspend fun addItemToCart(foodItem: FoodItem): Boolean {
        foodItem.inCart = true
        MOCK_CART.add(foodItem)
        MOCK_STORE_ITEMS.find { it.id == foodItem.id }?.inCart = true
        return true
    }

    /**
     * Remove an item that was added to the cart
     */
    suspend fun removeItemFromCart(foodItem: FoodItem): Boolean {
        MOCK_CART.remove(foodItem)
        MOCK_STORE_ITEMS.find { it.id == foodItem.id }?.inCart = false
        return true
    }

    /**
     * Get the list of items currently in the cart
     */
    suspend fun getCartItems(): List<FoodItem> {
        Loug.d("shopper", "GET /v1/cart/items")
        delay(MOCK_API_DELAY)
        Loug.d("shopper", "SUCCESS /v1/cart/items\n" + MOCK_CART)
        return MOCK_CART
    }

    /**
     * Get the order total by summing all of the items in the cart
     */
    suspend fun getOrderTotal(): Double {
        Loug.d("shopper", "GET /v1/order/total")
        delay(MOCK_API_DELAY)
        Loug.d("shopper", "SUCCESS /v1/order/total")
        return MOCK_CART.sumOf { it.price }
    }

    /**
     * Get the status of the checkout process, includes verifying payment method,
     * processing order, and checkout complete statuses
     */
    suspend fun getCheckoutStatus(): String {
        Loug.d("shopper", "GET /v1/order/status")
        delay(MOCK_API_DELAY)
        val status = MOCK_STATUSES[MOCK_ORDER_STATUS_STEP]
        MOCK_ORDER_STATUS_STEP++
        if (MOCK_ORDER_STATUS_STEP == MOCK_STATUSES.size) {
            MOCK_CART.clear()
            MOCK_STORE_ITEMS.forEach { it.inCart = false }
            MOCK_ORDER_STATUS_STEP = 0
        }
        Loug.d("shopper", "SUCCESS /v1/order/status " + status)
        return status
    }

    /**
     * Get arrival details for the order including driver status and arrival time.  Simulates
     * some type of real-time server connection using a flow
     */
    fun getArrivalDetails(orderNum: Int) = flow {
        if (orderNum != MOCK_ORDER_NUM) emit(null)
        var updateNum = 0
        while (updateNum < MOCK_ARRIVALS.size) {
            emit(MOCK_ARRIVALS[updateNum])
            updateNum++
            delay(MOCK_ARRIVAL_UPDATE_DELAY)
        }
    }

}