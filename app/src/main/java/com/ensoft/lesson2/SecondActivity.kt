package com.ensoft.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ensoft.lesson2.databinding.ActivityMainBinding
import com.ensoft.lesson2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //        val flipIn = AnimationUtils.loadAnimation(this, R.anim.flip_in_animation)
//        val flipOut = AnimationUtils.loadAnimation(this, R.anim.flip_out_animation)

        //viewFlipper.childCount
//        btn_next.setOnClickListener {
//            viewFlipper.inAnimation = flipIn
//            viewFlipper.outAnimation = flipOut
//            viewFlipper.showNext()
//        }
//        btn_prev.setOnClickListener {
//            viewFlipper.inAnimation = flipIn
//            viewFlipper.inAnimation = flipOut
//            viewFlipper.showPrevious()
//
//        }
        binding.viewFlipper.flipInterval = 2000
        binding.btnStart.setOnClickListener {
            binding.viewFlipper.startFlipping()
        }
        binding.btnStop.setOnClickListener {
            binding.viewFlipper.stopFlipping()
        }
    }
}