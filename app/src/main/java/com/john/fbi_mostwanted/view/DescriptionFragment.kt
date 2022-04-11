package com.john.fbi_mostwanted.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.john.fbi_mostwanted.R
import com.john.fbi_mostwanted.databinding.FragmentDescriptionBinding
import com.squareup.picasso.Picasso

class DescriptionFragment : Fragment() {

    val args: DescriptionFragmentArgs by navArgs()

    private val binding by lazy {
        FragmentDescriptionBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Picasso.get().load(args.criminal[1])
            .resize(600,600)
            .centerCrop()
            .into(binding.imgFace)

        binding.tvTitle.text = args.criminal[0].toString()
        binding.tvDescription.text = args.criminal[2].toString()

        return binding.root
    }

}