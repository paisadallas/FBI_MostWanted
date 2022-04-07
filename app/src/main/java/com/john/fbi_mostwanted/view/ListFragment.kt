package com.john.fbi_mostwanted.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.john.fbi_mostwanted.R
import com.john.fbi_mostwanted.databinding.FragmentListBinding
import com.john.fbi_mostwanted.utils.FbiState

class ListFragment : BaseFragment() {

    private val binding by lazy {
        FragmentListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fbiViewModel.getAllList()
        fbiViewModel.fbi.observe(viewLifecycleOwner){
            when(it){
                FbiState.LOADING ->{

                }
              is  FbiState.SUCCESS <*> ->{

                }
                is FbiState.ERROR -> {
                    Toast.makeText(requireContext(), it.error.localizedMessage, Toast.LENGTH_LONG)
                        .show()
                }
            }
        }

       return (binding.root)
    }

}