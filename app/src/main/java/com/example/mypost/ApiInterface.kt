package com.example.mypost


import org.w3c.dom.Comment
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
    @GET("posts/{id}")
    fun  getPostById(@Path("id") postId:Int):Call<Post>

    @GET("posts/{id}/comments")
    fun getCommentsById(@Path("id")postId: Int):Call<List<Comments>>



}