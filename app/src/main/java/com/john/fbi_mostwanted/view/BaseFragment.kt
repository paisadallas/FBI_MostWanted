package com.john.fbi_mostwanted.view

import android.content.Context
import androidx.fragment.app.Fragment

import com.john.fbi_mostwanted.viewmodel.FbiViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

open abstract class BaseFragment : Fragment() {

    protected val fbiViewModel: FbiViewModel by sharedViewModel()

}