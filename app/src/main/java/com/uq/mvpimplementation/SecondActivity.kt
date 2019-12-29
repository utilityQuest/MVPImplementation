package com.uq.mvpimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.uq.mvpimplementation.News.NewsFragment

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.landingNewsFragment, NewsFragment.newInstance())
                .commit()
        }
    }
}
