package com.john.fbi_mostwanted.viewmodel

import android.util.Log
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
                Log.d("MY_DATA","ENTRY 1")
                val response  = fbiNetwork.getAllData()
                Log.d("MY_DATA","ENTRY 2")
                if (response.isSuccessful){
                    Log.d("MY_DATA","SUCCESSFUL")
                    response.body()?.let {
                     //   Log.d("MY_DATA",it.toString())
                        var myObjet = it.items
                        Log.d("MY_DATA",myObjet[1].description)
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