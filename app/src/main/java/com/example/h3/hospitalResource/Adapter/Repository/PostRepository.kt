package com.example.h3.hospitalResource.Adapter.Repository

import com.example.h3.hospitalResource.Adapter.Network.RetrofitBuilder
import com.example.h3.hospitalResource.Adapter.modal2.postItem

class PostRepository {
    suspend fun getPost():List<postItem> = RetrofitBuilder.api.getpost()
}