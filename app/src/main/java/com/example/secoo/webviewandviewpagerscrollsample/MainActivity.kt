package com.example.secoo.webviewandviewpagerscrollsample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPager.adapter = ScreenSlidePagerAdapter(supportFragmentManager)
    }


    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return if (position == 0) {
//                WebViewFragment.getInstance("https://droidyue.com")
//                WebViewFragment.getInstance("https://www.iqiyi.com")
                WebViewFragment.getInstance("https://www.baidu.com")

            } else {
//                WebViewFragment.getInstance("https://asset.droidyue.com/content/scroll_page.html")
                WebViewFragment.getInstance("https://m.iqiyi.com")
            }
        }

        override fun getCount(): Int {
            return 2
        }
    }
}
