package com.example.kronometre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import com.example.kronometre.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var zamaniDurdur:Long=0;
        binding.btnstart.setOnClickListener{
            binding.kronometre.base=SystemClock.elapsedRealtime()+zamaniDurdur
            binding.kronometre.start()
            binding.btnstart.visibility = View.GONE
            binding.btnpause.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.pause))
        }
        binding.btnpause.setOnClickListener{
            zamaniDurdur= binding.kronometre.base-SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            binding.btnpause.visibility = View.GONE
            binding.btnstart.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }
        binding.btnreset.setOnClickListener{
            binding.kronometre.base= SystemClock.elapsedRealtime()
            binding.kronometre.stop()
            zamaniDurdur=0
            binding.btnpause.visibility = View.GONE
            binding.btnstart.visibility = View.VISIBLE
            binding.imageView.setImageDrawable(getDrawable(R.drawable.start))
        }

        }
    }
