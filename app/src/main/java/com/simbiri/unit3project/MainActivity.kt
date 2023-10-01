package com.simbiri.unit3project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var recyclerFoodItems: RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerViewAdapter = MenuAdapter(this, FoodsAndPrices.listFoodItem!!)

        recyclerFoodItems = findViewById(R.id.foodItemRecyclerView)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.HORIZONTAL

        recyclerFoodItems.layoutManager = layoutManager
        recyclerFoodItems.adapter = recyclerViewAdapter


    }

}
