package ru.stambul4you.mshoplist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.stambul4you.mshoplist.R
import ru.stambul4you.mshoplist.domain.ShopItem

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ShopListAdapter


        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
                adapter.ShopList = it
        }

    }
            private fun setupRecyclerView(){
                val rvShopList = findViewById<RecyclerView>(R.id.rv_shop_list)
                adapter = ShopListAdapter()
                rvShopList.adapter = adapter
            }
}