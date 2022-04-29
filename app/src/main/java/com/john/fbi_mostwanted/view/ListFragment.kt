package com.john.fbi_mostwanted.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.john.fbi_mostwanted.R
import com.john.fbi_mostwanted.adapter.PeopleAdapter
import com.john.fbi_mostwanted.databinding.FragmentListBinding
import com.john.fbi_mostwanted.model.Criminals
import com.john.fbi_mostwanted.utils.FbiState

class ListFragment : BaseFragment() {

    private val binding by lazy {
        FragmentListBinding.inflate(layoutInflater)
    }
//
     private val peopleAdapter by lazy {
        PeopleAdapter() {
           Log.d("CLICK","YOU DID CLICK"+it.title)
            var data= Array<String>(4){""}
            data[0] = it.title
            data[1] = it.images[0]?.large.toString()
            data[2] = it.description

            val intention = ListFragmentDirections.actionListFragmentToDescriptionFragment(data)
            findNavController().navigate(intention)
          //  findNavController()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.rvList.apply {
//            layoutManager =
//                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)

          layoutManager =
              GridLayoutManager(requireContext(),2,GridLayoutManager.VERTICAL,false)
            adapter = peopleAdapter
        }

        fbiViewModel.getAllList()
        fbiViewModel.fbi.observe(viewLifecycleOwner){
            when(it){
                FbiState.LOADING ->{

                }
              is  FbiState.SUCCESS <*> ->{
                    var listItem = it?.criminal as Criminals

                  listItem?.items?.let { it1 -> peopleAdapter.update(it1) }
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