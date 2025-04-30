package com.example.lab41_palazova

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.lab41_palazova.databinding.ActivityMainBinding
import androidx.core.view.get


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var pagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = pagerAdapter

        // оновлення елементів у нижній навігації
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.bottomNavigation.menu[position].isChecked = true
            }
        })

        // обробник натискань на пункти нижнього меню
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_1 -> binding.viewPager.currentItem = 0
                R.id.item_2 -> binding.viewPager.currentItem = 1
                R.id.item_3 -> binding.viewPager.currentItem = 2
                R.id.item_4 -> binding.viewPager.currentItem = 3
                R.id.item_5 -> binding.viewPager.currentItem = 4
            }
            true
        }
    }
}
