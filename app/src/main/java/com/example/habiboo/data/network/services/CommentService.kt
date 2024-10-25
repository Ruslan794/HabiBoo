package com.example.habiboo.data.network.services

import com.example.habiboo.data.network.model.comment.CommentRequest
import com.example.habiboo.data.network.model.comment.CommentResponse
import retrofit2.Call
import retrofit2.http.*

interface CommentService {

    @GET("/comments")
    fun getComments(
        @Query("sort") sort: String? = null,
        @Query("pagination[withCount]") withCount: Boolean? = true,
        @Query("pagination[page]") page: Int? = 0,
        @Query("pagination[pageSize]") pageSize: Int? = 25,
        @Query("pagination[start]") start: Int? = 0,
        @Query("pagination[limit]") limit: Int? = 25,
        @Query("fields") fields: String? = null,
        @Query("populate") populate: String? = null,
        @Query("filters") filters: String? = null
    ): Call<CommentResponse>


    @POST("/comments")
    fun postComment(
        @Body commentRequest: CommentRequest
    ): Call<CommentResponse>


    @GET("/comments/{id}")
    fun getCommentById(
        @Path("id") id: Int
    ): Call<CommentResponse>


    @PUT("/comments/{id}")
    fun updateComment(@Path("id") id: Int): AnyMethodTODO

    @DELETE("/comments/{id}")
    fun deleteComment(@Path("id") id: Int): AnyMethodTODO
}