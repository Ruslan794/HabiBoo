package com.example.habiboo.data.network.services

import com.example.habiboo.data.network.model.report.ReportRequest
import com.example.habiboo.data.network.model.report.ReportResponse
import retrofit2.Call
import retrofit2.http.*

interface ReportService {

    @GET("/reports")
    fun getReports(
        @Query("sort") sort: String? = null,
        @Query("pagination[withCount]") withCount: Boolean? = true,
        @Query("pagination[page]") page: Int? = 0,
        @Query("pagination[pageSize]") pageSize: Int? = 25,
        @Query("pagination[start]") start: Int? = 0,
        @Query("pagination[limit]") limit: Int? = 25,
        @Query("fields") fields: String? = null,
        @Query("populate") populate: String? = null
    ): Call<ReportResponse>

    @POST("/reports")
    fun createReport(@Body reportRequest: ReportRequest): Call<ReportResponse>



    @GET("/reports/{id}")
    fun getReportById(@Path("id") id: Int): Call<ReportResponse>


    @PUT("/reports/{id}")
    fun updateReport(
    @Path("id") id: Int,
    @Body reportRequest: ReportRequest
    ): Call<ReportResponse>

    @DELETE("/reports/{id}")
    fun deleteReport(@Path("id") id: Int): Call<Void>


}
