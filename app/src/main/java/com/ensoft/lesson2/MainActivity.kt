package com.ensoft.lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.ensoft.lesson2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var introAdapter: IntroAdapter
    private lateinit var indicatorContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setIntroAdapter()
        setupIndicator()
        setCurrentIndicatorActive(0)

//        binding.btnStart.visibility = View.INVISIBLE

    }
    private fun setIntroAdapter(){
        introAdapter = IntroAdapter(
            listOf(
                IntroItem(R.drawable.pic1, "TITLE 1", getString(R.string.lorem1)),
                IntroItem(R.drawable.pic2, "TITLE 2", getString(R.string.lorem2)),
                IntroItem(R.drawable.pic3, "TITLE 3", getString(R.string.lorem3))
            )
        )
        binding.viewPager.adapter = introAdapter

        binding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == introAdapter.itemCount - 1){
                    binding.btnStart.visibility = View.VISIBLE
                    binding.tvSkip.visibility = View.INVISIBLE

                }else{
                    binding.btnStart.visibility = View.INVISIBLE
                    binding.tvSkip.visibility = View.VISIBLE
                }
                setCurrentIndicatorActive(position)
            }
        })
        (binding.viewPager.getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        binding.btnNext.setOnClickListener {
            if (binding.viewPager.currentItem + 1 < introAdapter.itemCount){
                binding.viewPager.currentItem++
            }else{
                startActivity(Intent(applicationContext, SecondActivity::class.java))
                finish()
            }
        }
        binding.btnStart.setOnClickListener {
            startActivity(Intent(applicationContext, SecondActivity::class.java))
            finish()
        }
        binding.tvSkip.setOnClickListener {
            startActivity(Intent(applicationContext, SecondActivity::class.java))
            finish()
        }
    }
    private fun setupIndicator(){
        indicatorContainer = findViewById(R.id.indicatorContainer)
        val indicators = arrayOfNulls<ImageView>(introAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
            WRAP_CONTENT, WRAP_CONTENT
        )
        layoutParams.setMargins(8,0,8,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.setImageDrawable(ContextCompat.getDrawable(
                applicationContext, R.drawable.indicator_inactive
            ))
            indicators[i]?.layoutParams = layoutParams
            indicatorContainer.addView(indicators[i])
        }
    }
    private fun setCurrentIndicatorActive(position: Int){
        val childCount = indicatorContainer.childCount
        for (i in 0 until childCount){
            val indicator = indicatorContainer.getChildAt(i) as ImageView

            if (i == position){
                indicator.setImageDrawable(ContextCompat.getDrawable(
                    applicationContext, R.drawable.indicator_active
                ))
            }else{
                indicator.setImageDrawable(ContextCompat.getDrawable(
                    applicationContext, R.drawable.indicator_inactive
                ))
            }
        }
    }
}