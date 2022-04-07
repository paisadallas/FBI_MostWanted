package com.john.fbi_mostwanted.utils

sealed class FbiState{
    object LOADING: FbiState()
    class SUCCESS<T>(val criminal :T): FbiState()
    class ERROR (val error:Throwable):FbiState()
}
