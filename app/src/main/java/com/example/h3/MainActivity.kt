package com.example.h3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.example.h3.hospitalResource.Adapter.CovidNews.MySingleton
import com.example.h3.hospitalResource.Adapter.CovidNews.News
import com.example.h3.hospitalResource.Adapter.CovidNews.NewsItemClicked
import com.example.h3.hospitalResource.Adapter.CovidNews.NewsListAdapter
import com.example.h3.hospitalResource.Adapter.hospital
import com.example.h3.tracker.covidmain_activity
import com.example.h3.vaccin.vaccination
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NewsItemClicked
{


    private lateinit var madapter: NewsListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        hospital.setOnClickListener {
//
//            val i= Intent(this,hospital_resource::class.java)
//            startActivity(i)
//
//
//        }

        vaccin.setOnClickListener {

            val i= Intent(this, vaccination::class.java)
            startActivity(i)

        }

        Tracker.setOnClickListener {

            val i= Intent(this, covidmain_activity::class.java)
            startActivity(i)


        }
        hospit.setOnClickListener {
            val i= Intent(this, hospital::class.java)
            startActivity(i)


        }

        StaggeredGridLayoutManager(
            2, // span count
            StaggeredGridLayoutManager.VERTICAL // orientation
        ).apply {
            // specify the layout manager for recycler view
            recyclerView.layoutManager = this
        }

        //recyclerView.layoutManager = LinearLayoutManager(this)
        fetchData()

        madapter = NewsListAdapter(this)
        recyclerView.adapter=madapter
    }

    private fun fetchData() {
        // val url="https://newsapi.org/v2/everything?q=Coronavirus&pageSize=100&sortBy=publishedAt&apiKey=6c5f7b1999b94638a0a2114da0825c10"
        val url="http://newsapi.org/v2/top-headlines?country=in&category=health&pageSize=100&apiKey=6c5f7b1999b94638a0a2114da0825c10"
        val jsonObjectRequest= object: JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener {
                val newsJsonArray=it.getJSONArray("articles")
                val newsArray=ArrayList<News>()
                for(i in 0 until newsJsonArray.length()){
                    val newsJsonObject=newsJsonArray.getJSONObject(i)
                    val news=News(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("author"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage"),
                        newsJsonObject.getString("description"),
                        newsJsonObject.getString("publishedAt")


                    )
                    newsArray.add(news)
                }
                madapter.updateNews(newsArray)

            },
            Response.ErrorListener {

            }
        )
        {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String>()
                headers["User-Agent"] = "Mozilla/5.0"
                return headers
            }
        }
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }

    override fun onItemClicked(item: News) {


        val builder= CustomTabsIntent.Builder();
        val customTabsIntent=builder.build()

        customTabsIntent.launchUrl(this, Uri.parse(item.url))
        //    Toast.makeText(this,"ClickedItem $item",Toast.LENGTH_SHORT).show()
    }
}