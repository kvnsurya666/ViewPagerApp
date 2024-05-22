package com.kevinsurya.viewpagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var viewPager2: ViewPager2
    lateinit var myAdapter: MyPagerAdapter
    lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1- Initialize the ViewPager
        viewPager2 = findViewById(R.id.viewPager2)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        // 2- Add Fragments to the list in the adapter class
        myAdapter = MyPagerAdapter(supportFragmentManager, lifecycle)
        myAdapter.addFragmentToList(FragmentOne())
        myAdapter.addFragmentToList(FragmentTwo())
        myAdapter.addFragmentToList(FragmentThree())

        // 3- Connection the adapter with ViewPager2
        viewPager2.adapter = myAdapter

        // 4- Connecting TabLayout with ViewPager
        tabLayout = findViewById(R.id.tablayout)
        TabLayoutMediator(
            tabLayout,
            viewPager2
        ){
            tab, position ->
            // Customize the tab labels if needed
            tab.text = "Tab ${position+1}"
        }.attach()
    }
}