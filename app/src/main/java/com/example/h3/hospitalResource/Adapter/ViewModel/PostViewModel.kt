package com.example.h3.hospitalResource.Adapter.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.h3.hospitalResource.Adapter.Repository.PostRepository
import com.example.h3.hospitalResource.Adapter.modal2.postItem
import kotlinx.coroutines.launch

class PostViewModel(private val postRepository: PostRepository): ViewModel() {

    val postMutableLiveData:MutableLiveData<List<postItem>> = MutableLiveData()

    fun getPost()
    {
        viewModelScope.launch {
            val response= postRepository.getPost()
            postMutableLiveData.value=response

         }
    }

}