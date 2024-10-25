package com.example.habiboo.data.repository

import com.example.habiboo.data.network.model.post.Post
import com.example.habiboo.data.network.model.post.PostRequest
import com.example.habiboo.data.network.model.post.PostResponse
import com.example.habiboo.data.network.services.PostService
import retrofit2.Response

class PostRepository(private val postService: PostService) {

    // Method to fetch posts with optional filters
    suspend fun getPosts(
        sort: String? = null,
        withCount: Boolean? = true,
        page: Int? = 0,
        pageSize: Int? = 25,
        start: Int? = 0,
        limit: Int? = 25,
        fields: String? = null,
        populate: String? = null
    ): Response<PostResponse> {
        return postService.getPosts(
            sort,
            withCount,
            page,
            pageSize,
            start,
            limit,
            fields,
            populate
        )
    }

    // Method to create a new post
    suspend fun createPost(post: Post): Response<Post> {
        return postService.createPost(post)
    }

    // Method to fetch a post by its ID
    suspend fun getPostById(id: Int): Response<PostResponse> {
        return postService.getPostById(id)
    }

    // Method to update a post by its ID
    suspend fun updatePost(id: Int, postRequest: PostRequest): Response<PostResponse> {
        return postService.updatePost(id, postRequest)
    }

    // Method to delete a post by its ID
    suspend fun deletePost(id: Int): Response<PostResponse> {
        return postService.deletePost(id)
    }
}
