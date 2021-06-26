package com.example.h3.hospitalResource.Adapter.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.h3.hospitalResource.Adapter.Repository.PostRepository
import com.example.h3.hospitalResource.Adapter.modal2.postItem
import com.example.test.UPItem
import kotlinx.coroutines.launch

class PostViewModel(private val postRepository: PostRepository): ViewModel() {

    val postMutableLiveData:MutableLiveData<List<postItem>> = MutableLiveData()
//    val postMutableLiveData:MutableLiveData<List<UPItem>> = MutableLiveData()

    val UPpostMutableLiveData :MutableLiveData<List<UPItem>> = MutableLiveData()

    fun getPost()
    {
        viewModelScope.launch {
            val response= postRepository.getPost()
            postMutableLiveData.value=response

         }
    }

    fun getUP()
    {
        viewModelScope.launch {
            val response= postRepository.getUP()
            UPpostMutableLiveData.value=response

        }
    }

}