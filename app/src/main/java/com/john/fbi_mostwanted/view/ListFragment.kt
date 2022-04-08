package com.john.fbi_mostwanted.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.john.fbi_mostwanted.R
import com.john.fbi_mostwanted.databinding.FragmentListBinding
import com.john.fbi_mostwanted.model.Criminals
import com.john.fbi_mostwanted.utils.FbiState

class ListFragment : BaseFragment() {

    private val binding by lazy {
        FragmentListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.rvList.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            adapter = peopleAdapter
        }

        fbiViewModel.getAllList()
        fbiViewModel.fbi.observe(viewLifecycleOwner){
            when(it){
                FbiState.LOADING ->{

                }
              is  FbiState.SUCCESS <*> ->{
                    var listItem = it?.criminal as Criminals

                  peopleAdapter.update(listItem?.items)
                }
                is FbiState.ERROR -> {
                    Toast.makeText(requireContext(), it.error.localizedMessage, Toast.LENGTH_LONG)
                        .show()

                    Log.d("MY_DATA_ERROR",it.error.localizedMessage)
                }
            }
        }

       return (binding.root)
    }

}