package com.example.habiboo.data.network.services
import com.example.habiboo.data.network.model.upload.FileInfo
import com.example.habiboo.data.network.model.upload.FileResponse
import com.example.habiboo.data.network.model.upload.FileUploadResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*


interface UploadApiService {


    @POST("/upload")
    @Multipart
    fun uploadFile(
        @Part file: MultipartBody.Part,
        @Part("path") path : String,
        @Part("refId") refId: String,
        @Part("ref") ref :String,
        @Part("field") field: String
    ): Call<FileUploadResponse>


    @POST("/upload")
    @Multipart
    fun uploadFileWithId(
        @Query("id") id: String,
        @Part file: MultipartBody.Part,
        @Part("fileInfo") fileInfo: FileInfo
    ): Call<FileUploadResponse>

    @GET("/upload/files")
    fun getFiles(): Call<List<FileResponse>>

    @GET("/upload/files/{id}")
    fun getFileById(
        @Path("id") id: String
    ): Call<FileResponse>



    @DELETE("/upload/files/{id}")
    fun deleteFileById(
        @Path("id") id: String
    ): Call<FileResponse>
}