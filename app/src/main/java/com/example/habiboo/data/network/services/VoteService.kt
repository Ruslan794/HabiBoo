package com.example.habiboo.data.network.services

import com.example.habiboo.data.network.model.vote.VoteRequest
import com.example.habiboo.data.network.model.vote.VoteResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface VoteService {
    @GET("votes")
    fun getVotes(
        @Query("sort") sort: String? = null,
        @Query("pagination[withCount]") withCount: Boolean? = null,
        @Query("pagination[page]") page: Int? = null,
        @Query("pagination[pageSize]") pageSize: Int? = null,
        @Query("pagination[start]") start: Int? = null,
        @Query("pagination[limit]") limit: Int? = null,
        @Query("fields") fields: String? = null,
        @Query("populate") populate: String? = null,
        @Query("filters") filters: Map<String, Any>? = null
    ): Call<VoteResponse>

    // POST /votes
    @POST("votes")
    fun createVote(@Body voteRequest: VoteRequest): Call<VoteResponse>

    // GET /votes/{id}
    @GET("votes/{id}")
    fun getVoteById(@Path("id") id: Int): Call<VoteRequest>

    @PUT("votes/{id}")
    fun updateVote(
        @Path("id") id: Int,
        @Body voteRequest: VoteRequest
    ): Call<VoteResponse>

    // DELETE /votes/{id}
    @DELETE("votes/{id}")
    fun deleteVote(@Path("id") id: Int): Call<Void>
}