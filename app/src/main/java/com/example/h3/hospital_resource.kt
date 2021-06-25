package com.example.h3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.h3.hospitalResource.Adapter.PostAdapter
import com.example.h3.hospitalResource.Adapter.Repository.PostRepository
import com.example.h3.hospitalResource.Adapter.ViewModel.PostViewModel
import com.example.h3.hospitalResource.Adapter.ViewModel.PostViewModelFactory
import com.example.h3.hospitalResource.Adapter.modal2.postItem

class hospital_resource : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_resource)


        initRecyclerView()

        val postRepository = PostRepository()
        val viewModelFactory = PostViewModelFactory(postRepository)
        postViewModel = ViewModelProvider(this,viewModelFactory)[PostViewModel::class.java]
        postViewModel.getPost()
        postViewModel.postMutableLiveData.observe(this, Observer {
            postAdapter.setData(it as ArrayList<postItem>)
            recyclerView.visibility= View.VISIBLE

        })
    }


    private fun initRecyclerView() {

        recyclerView = findViewById(R.id.recyclerView)
        postAdapter= PostAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@hospital_resource)
            adapter = postAdapter

        }
    }


    }
