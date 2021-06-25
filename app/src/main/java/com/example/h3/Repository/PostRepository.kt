package com.example.h3.Repository

import com.example.h3.Adapter.Posts
import com.example.h3.Network.RetrofitBuilder
import com.example.h3.modal2.postItem

class PostRepository {
    suspend fun getPost():List<postItem> = RetrofitBuilder.api.getpost()
}