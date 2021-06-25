package com.example.h3.hospitalResource.Adapter.Network

import com.example.h3.hospitalResource.Adapter.modal2.postItem
import retrofit2.http.GET

interface Api {

//    @GET("posts")
//    suspend fun getpost():List<Posts>

    @GET("Bengaluru")
    suspend fun getpost():List<postItem>




}