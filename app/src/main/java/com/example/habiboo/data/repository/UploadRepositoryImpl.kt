package com.example.habiboo.data.repository

import com.example.habiboo.data.network.model.upload.FileInfo
import com.example.habiboo.data.network.model.upload.FileResponse
import com.example.habiboo.data.network.model.upload.FileUploadResponse
import com.example.habiboo.data.network.services.UploadApiService
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UploadRepositoryImpl(private val apiService: UploadApiService) {

    fun uploadFile(
        file: MultipartBody.Part,
        path: String,
        refId: String,
        ref: String,
        field: String,
        onSuccess: (FileUploadResponse) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        apiService.uploadFile(file, path, refId, ref, field).enqueue(object : Callback<FileUploadResponse> {
            override fun onResponse(call: Call<FileUploadResponse>, response: Response<FileUploadResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let(onSuccess)
                } else {
                    onError(Throwable("Upload failed with code: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<FileUploadResponse>, t: Throwable) {
                onError(t)
            }
        })
    }

    fun uploadFileWithId(
        id: String,
        file: MultipartBody.Part,
        fileInfo: FileInfo,
        onSuccess: (FileUploadResponse) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        apiService.uploadFileWithId(id, file, fileInfo).enqueue(object : Callback<FileUploadResponse> {
            override fun onResponse(call: Call<FileUploadResponse>, response: Response<FileUploadResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let(onSuccess)
                } else {
                    onError(Throwable("Upload with ID failed with code: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<FileUploadResponse>, t: Throwable) {
                onError(t)
            }
        })
    }

    fun getFiles(
        onSuccess: (List<FileResponse>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        apiService.getFiles().enqueue(object : Callback<List<FileResponse>> {
            override fun onResponse(call: Call<List<FileResponse>>, response: Response<List<FileResponse>>) {
                if (response.isSuccessful) {
                    response.body()?.let(onSuccess)
                } else {
                    onError(Throwable("Fetching files failed with code: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<List<FileResponse>>, t: Throwable) {
                onError(t)
            }
        })
    }

    fun getFileById(
        id: String,
        onSuccess: (FileResponse) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        apiService.getFileById(id).enqueue(object : Callback<FileResponse> {
            override fun onResponse(call: Call<FileResponse>, response: Response<FileResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let(onSuccess)
                } else {
                    onError(Throwable("Fetching file by ID failed with code: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<FileResponse>, t: Throwable) {
                onError(t)
            }
        })
    }

    fun deleteFileById(
        id: String,
        onSuccess: (FileResponse) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        apiService.deleteFileById(id).enqueue(object : Callback<FileResponse> {
            override fun onResponse(call: Call<FileResponse>, response: Response<FileResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let(onSuccess)
                } else {
                    onError(Throwable("Deleting file failed with code: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<FileResponse>, t: Throwable) {
                onError(t)
            }
        })
    }
}
