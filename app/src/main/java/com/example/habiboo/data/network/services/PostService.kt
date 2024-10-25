package com.example.habiboo.data.network.services

import com.example.habiboo.data.network.model.post.Post
import com.example.habiboo.data.network.model.post.PostData
import com.example.habiboo.data.network.model.post.PostRequest
import com.example.habiboo.data.network.model.post.PostResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface PostService {

    @GET("/posts")
    suspend fun getPosts(
        @Query("sort") sort: String? = null,
        @Query("pagination[withCount]") withCount: Boolean? = true,
        @Query("pagination[page]") page: Int? = 0,
        @Query("pagination[pageSize]") pageSize: Int? = 25,
        @Query("pagination[start]") start: Int? = 0,
        @Query("pagination[limit]") limit: Int? = 25,
        @Query("fields") fields: String? = null,
        @Query("populate") populate: String? = null
    ): Response<PostResponse>

    @POST("/posts")
    suspend fun createPost(@Body post: PostData): Response<PostData>

    @GET("/api/posts/{id}")
    suspend fun getPostById(
        @Path("id") id: Int
    ): Response<PostResponse>

    @PUT("/api/posts/{id}")
    suspend fun updatePost(
        @Path("id") id: Int,
        @Body postRequest: PostRequest
    ): Response<PostResponse>

    @DELETE("/api/posts/{id}")
    suspend fun deletePost(
        @Path("id") id: Int
    ): Response<PostResponse>

}