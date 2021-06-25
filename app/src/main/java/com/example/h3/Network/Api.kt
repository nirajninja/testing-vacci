package com.example.h3.Network

import com.example.h3.Adapter.Posts
import com.example.h3.modal2.post
import com.example.h3.modal2.postItem
import retrofit2.http.GET

interface Api {

//    @GET("posts")
//    suspend fun getpost():List<Posts>

    @GET("Bengaluru")
    suspend fun getpost():List<postItem>




}