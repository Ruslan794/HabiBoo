package com.example.habiboo.data.repository

import com.example.habiboo.data.network.model.vote.VoteRequest
import com.example.habiboo.data.network.model.vote.VoteResponse
import com.example.habiboo.data.network.services.VoteService
import retrofit2.Call

class VoteRepository(private val voteService: VoteService) {

    // Function to get a list of votes with optional query parameters
    fun getVotes(
        sort: String? = null,
        withCount: Boolean? = null,
        page: Int? = null,
        pageSize: Int? = null,
        start: Int? = null,
        limit: Int? = null,
        fields: String? = null,
        populate: String? = null,
        filters: Map<String, Any>? = null
    ): Call<VoteResponse> {
        return voteService.getVotes(sort, withCount, page, pageSize, start, limit, fields, populate, filters)
    }

    // Function to create a new vote
    fun createVote(voteRequest: VoteRequest): Call<VoteResponse> {
        return voteService.createVote(voteRequest)
    }

    // Function to get a vote by its ID
    fun getVoteById(id: Int): Call<VoteRequest> {
        return voteService.getVoteById(id)
    }

    // Function to update a vote by its ID
    fun updateVote(id: Int, voteRequest: VoteRequest): Call<VoteResponse> {
        return voteService.updateVote(id, voteRequest)
    }

    // Function to delete a vote by its ID
    fun deleteVote(id: Int): Call<Void> {
        return voteService.deleteVote(id)
    }
}