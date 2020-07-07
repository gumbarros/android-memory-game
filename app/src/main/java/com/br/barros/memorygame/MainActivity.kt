package com.br.barros.memorygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.br.barros.memorygame.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var images: List<Map<Int, Int>>

    private lateinit var technologies: MutableList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        shuffleImages()
        setListeners()
    }

    private fun shuffleImages() {
        technologies = mutableListOf<Int>(
            R.drawable.flutter,
            R.drawable.flutter,
            R.drawable.kotlin,
            R.drawable.kotlin,
            R.drawable.react,
            R.drawable.react
        )
        technologies.shuffle()
        setImages()
    }


    private fun setImages() {
        images = listOf(
            mapOf(
                binding.imageView.id to technologies[0]
            ),
            mapOf(
                binding.imageView2.id to technologies[1]
            ),
            mapOf(
                binding.imageView3.id to technologies[2]
            ),
            mapOf(
                binding.imageView4.id to technologies[3]
            ),
            mapOf(
                binding.imageView5.id to technologies[4]
            ),
            mapOf(
                binding.imageView6.id to technologies[5]
            )
        )
    }

    private fun setListeners() {
        val images: List<ImageView> = listOf(
            binding.imageView,
            binding.imageView2,
            binding.imageView3,
            binding.imageView4,
            binding.imageView5,
            binding.imageView6
        )
        for (image in images) {
            image.tag = R.drawable.android
            image.setOnClickListener {
                showImage(it as ImageView)
            }
        }
    }

    private fun showImage(image: ImageView) {
        val drawnImage: Map<Int, Int>? = images.find { it.keys.first() == image.id }
        if(image.tag == R.drawable.android){
            image.setImageResource(drawnImage!!.values.first())
            image.tag = drawnImage!!.values.first()
        }
        else{
            image.setImageResource(R.drawable.android)
            image.tag = R.drawable.android
        }
    }
}