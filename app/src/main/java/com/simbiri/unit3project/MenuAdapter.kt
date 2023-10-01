package com.simbiri.unit3project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class FoodItem(val itemPic: Int, val itemName: String, val itemPrice: String)


object FoodsAndPrices {

    val pics = arrayOf(
        R.drawable.girraffe,
        R.drawable.antelopr,
        R.drawable.zebra,
        R.drawable.rhino,
        R.drawable.elephant,
        R.drawable.wildebeest,
        R.drawable.bufallo

    )

    val names = arrayListOf(

        "Spotty giraffe",
        "Succulent antelope",
        "Tasty zebras",
        "Tough rhino",
        "Gigantic  elephant",
        "Tamed wildebeest",
        "Savory buffalo"
    )

    val prices = arrayListOf(
        "15$", "17$", "20$", "19$", "13$", "12$", "10$"
    )


    var listFoodItem: ArrayList<FoodItem>? = null
        get() {

            if (field != null) {
                return field
            }

            field = ArrayList()

            for (imagePosition in pics.indices) {
                val itemPicId = pics[imagePosition]
                val itemName = names[imagePosition]
                val itemPrice = prices[imagePosition]

                val sampleFoodItem = FoodItem(itemPicId, itemName, itemPrice)
                field!!.add(sampleFoodItem)
            }

            return field

        }

}

class MenuAdapter(var context: Context, var listOfFoods: ArrayList<FoodItem>) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var positionItem: Int = 1
        private var currentFoodItem: FoodItem? = null

        private var textItemName: TextView = itemView.findViewById(R.id.textItemName)
        private var imageItemPic: ImageView = itemView.findViewById(R.id.imageItemFood)
        private var textItemPrice: TextView = itemView.findViewById(R.id.textItemPrice)


        fun setDataToItem(foodItem: FoodItem, position: Int) {
            this.positionItem = position
            this.currentFoodItem = foodItem

            imageItemPic.setImageResource(foodItem.itemPic)
            textItemName.text = foodItem.itemName
            textItemPrice.text = foodItem.itemPrice
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.food_item_sample, parent, false)

        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(menuViewolder: MenuViewHolder, position: Int) {

        val foodItemMenu = listOfFoods[position]

        menuViewolder.setDataToItem(foodItemMenu, position)

    }

    override fun getItemCount(): Int {
        return listOfFoods.size
    }
}
