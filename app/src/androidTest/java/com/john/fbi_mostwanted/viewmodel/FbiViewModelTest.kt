package com.john.fbi_mostwanted.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.john.fbi_mostwanted.database.DatabaseRepository
import com.john.fbi_mostwanted.res.FbiRepository
import com.john.fbi_mostwanted.utils.FbiState
import io.mockk.mockk
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class FbiViewModelTest{

    @get:Rule
    var rule = InstantTaskExecutorRule()
    private val testDispatcher = UnconfinedTestDispatcher()
    private val database = mockk<DatabaseRepository>(relaxed = true)
    private val mockRepository = mockk<FbiRepository>(relaxed = true)

    lateinit var target: FbiViewModel

    @Before
    fun setup(){
        Dispatchers.setMain(testDispatcher)
        target = FbiViewModel(mockRepository,database,testDispatcher)
    }

    @After
    fun shutdown() {
        clearAllMocks()
        Dispatchers.resetMain()
    }

    @Test
    fun `get_all_persons_when_trying_to_load_from_server_returns_loading_state`() {

        val stateList = mutableListOf<FbiState>()
        target.fbi.observeForever {
            stateList.add(it)
        }

        target.getAllList()


        assertThat(stateList).isNotEmpty()
        assertThat(stateList[0]).isInstanceOf(FbiState.LOADING::class.java)
        assertThat(stateList[1]).isInstanceOf(FbiState.LOADING::class.java)


    }

}