package com.john.fbi_mostwanted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.john.fbi_mostwanted.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
         ActivityMainBinding.inflate(layoutInflater)
     }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}