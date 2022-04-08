package com.john.fbi_mostwanted.view

import androidx.fragment.app.Fragment
import com.john.fbi_mostwanted.adapter.PeopleAdapter
import com.john.fbi_mostwanted.viewmodel.FbiViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

open class BaseFragment : Fragment() {

    protected val fbiViewModel: FbiViewModel by sharedViewModel()

    protected val peopleAdapter by lazy {
        PeopleAdapter()
    }
}