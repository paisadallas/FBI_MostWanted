package com.john.fbi_mostwanted.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.john.fbi_mostwanted.database.DatabaseRepository
import com.john.fbi_mostwanted.res.FbiRepository
import com.john.fbi_mostwanted.utils.FbiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FbiViewModel(
    private val fbiNetwork : FbiRepository,
    private val dataBase : DatabaseRepository,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
):ViewModel() {

    private val _sortedFbi : MutableLiveData<FbiState> = MutableLiveData(FbiState.LOADING)

    val fbi: LiveData<FbiState> get() = _sortedFbi

    fun getAllList(){
        viewModelScope.launch (ioDispatcher){
            try {
                val response  = fbiNetwork.getAllData()
                if (response.isSuccessful){
                        response.body().let {

                        }
                }else{
                    throw Exception("response null")
                }

            }catch (e:java.lang.Exception){
                _sortedFbi.postValue(FbiState.ERROR(e))
            }
        }
    }
}