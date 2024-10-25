package com.example.habiboo.data.repository

import com.example.habiboo.data.network.model.report.ReportRequest
import com.example.habiboo.data.network.model.report.ReportResponse
import com.example.habiboo.data.network.services.ReportService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReportRepositoryImp(
    private val reportService: ReportService
) {

    // Fetch reports with optional query parameters
    fun getReports(
        sort: String? = null,
        withCount: Boolean? = true,
        page: Int? = 0,
        pageSize: Int? = 25,
        start: Int? = 0,
        limit: Int? = 25,
        fields: String? = null,
        populate: String? = null,
        onSuccess: (ReportResponse?) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val call = reportService.getReports(sort, withCount, page, pageSize, start, limit, fields, populate)
        call.enqueue(object : Callback<ReportResponse> {
            override fun onResponse(call: Call<ReportResponse>, response: Response<ReportResponse>) {
                if (response.isSuccessful) {
                    onSuccess(response.body())
                } else {
                    onError(Throwable("Failed to fetch reports: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<ReportResponse>, t: Throwable) {
                onError(t)
            }
        })
    }

    // Create a new report
    fun createReport(
        reportRequest: ReportRequest,
        onSuccess: (ReportResponse?) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val call = reportService.createReport(reportRequest)
        call.enqueue(object : Callback<ReportResponse> {
            override fun onResponse(call: Call<ReportResponse>, response: Response<ReportResponse>) {
                if (response.isSuccessful) {
                    onSuccess(response.body())
                } else {
                    onError(Throwable("Failed to create report: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<ReportResponse>, t: Throwable) {
                onError(t)
            }
        })
    }

    // Fetch a report by its ID
    fun getReportById(
        id: Int,
        onSuccess: (ReportResponse?) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val call = reportService.getReportById(id)
        call.enqueue(object : Callback<ReportResponse> {
            override fun onResponse(call: Call<ReportResponse>, response: Response<ReportResponse>) {
                if (response.isSuccessful) {
                    onSuccess(response.body())
                } else {
                    onError(Throwable("Failed to fetch report: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<ReportResponse>, t: Throwable) {
                onError(t)
            }
        })
    }

    // Update a report by its ID
    fun updateReport(
        id: Int,
        reportRequest: ReportRequest,
        onSuccess: (ReportResponse?) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val call = reportService.updateReport(id, reportRequest)
        call.enqueue(object : Callback<ReportResponse> {
            override fun onResponse(call: Call<ReportResponse>, response: Response<ReportResponse>) {
                if (response.isSuccessful) {
                    onSuccess(response.body())
                } else {
                    onError(Throwable("Failed to update report: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<ReportResponse>, t: Throwable) {
                onError(t)
            }
        })
    }

    // Delete a report by its ID
    fun deleteReport(
        id: Int,
        onSuccess: () -> Unit,
        onError: (Throwable) -> Unit
    ) {
        val call = reportService.deleteReport(id)
        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    onSuccess()
                } else {
                    onError(Throwable("Failed to delete report: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                onError(t)
            }
        })
    }
}
