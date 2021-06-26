package com.example.h3.hospitalResource.Adapter.Repository

import com.example.h3.hospitalResource.Adapter.Network.RetrofitBuilder
import com.example.h3.hospitalResource.Adapter.modal2.postItem
import com.example.test.UPItem

class PostRepository {
   // suspend fun getPost():List<postItem> = RetrofitBuilder.api.getpost()

    suspend fun getPost():List<postItem> = RetrofitBuilder.api.getpost()


    suspend fun getUP():List<UPItem> = RetrofitBuilder.api.getUP()

}