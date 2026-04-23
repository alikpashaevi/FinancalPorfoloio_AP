package com.ap.vi.portfolio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.ap_vi_tl_tabs)
        val viewPager = findViewById<ViewPager2>(R.id.ap_vi_vp_pager)

        viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
        viewPager.adapter = ViewPagerFragmentAdapter(this)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.icon = when (position) {
                0 -> getDrawable(android.R.drawable.ic_menu_edit)
                1 -> getDrawable(android.R.drawable.ic_menu_sort_by_size)
                2 -> getDrawable(android.R.drawable.ic_menu_myplaces)
                else -> null
            }
        }.attach()
    }

    private class ViewPagerFragmentAdapter(fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> InputFragment()
                1 -> AnalyticsFragment()
                2 -> ProfileFragment()
                else -> throw IllegalStateException("Unexpected position $position")
            }
        }
    }
}