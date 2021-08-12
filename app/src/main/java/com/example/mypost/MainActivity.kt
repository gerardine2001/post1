package com.example.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var rvUser:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchPost()
    }
    fun fetchPost(){
        var retrofit=ApiClient.buildService(ApiInterface::class.java)
        var request=retrofit.getPosts()
        request.enqueue(object : Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful){
                    var postList=response.body()
                    if (postList!=null) {
                        rvUser = findViewById(R.id.rvUser)
                        rvUser.layoutManager = LinearLayoutManager(baseContext)
                        var userAdapter = MyAdapter(baseContext, postList)
                        rvUser.adapter = userAdapter
                    }



//                    Toast.makeText(baseContext,postList!!.size.toString(),Toast.LENGTH_LONG).show()
                }

            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext,t.message, Toast.LENGTH_LONG).show()
            }

        })
    }
}