package com.br.barros.memorygame

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.children
import com.br.barros.memorygame.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var images: List<Map<Int, Int>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCards()
        setListeners()
    }

    private fun setListeners(){
        val images: List<ImageView> = listOf(
            binding.imageView,
            binding.imageView2,
            binding.imageView3,
            binding.imageView4,
            binding.imageView5,
            binding.imageView6
        )
        for (image in images) {
            image.setOnClickListener {
                showImage(it as ImageView)
            }
        }
    }

    private fun showImage(image : ImageView){
        val drawnImage : Map<Int, Int>? = images.find { it.keys.first() == image.id }
        image.setImageResource(drawnImage!!.values.first())
    }

    private fun setCards(){
        images = listOf(
            mapOf(
                binding.imageView.id to randomCard()
            ),
            mapOf(
                binding.imageView2.id to randomCard()
            ),
            mapOf(
                binding.imageView3.id to randomCard()
            ),
            mapOf(
                binding.imageView4.id to randomCard()
            ),
            mapOf(
                binding.imageView5.id to randomCard()
            ),
            mapOf(
                binding.imageView6.id to randomCard()
            )
        )
    }

    private fun randomCard(): Int {
        return when (Random.nextInt(0, 3)) {
            0 -> R.drawable.kotlin
            1 -> R.drawable.flutter
            else -> R.drawable.react
        }
    }
}