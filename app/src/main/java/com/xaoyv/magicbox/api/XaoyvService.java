package com.xaoyv.magicbox.api;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface XaoyvService {
    /**
     * GET请求
     *
     * @param path 网址
     * @param map  参数
     * @return Observable
     */
    @GET
    Observable<ResponseBody> getInfo(@Url String path, @QueryMap HashMap<String, Object> map);

    @GET
    Call<ResponseBody> downLoadFile(@Url String filePath);

    @Multipart
    @POST
//    Observable<ResponseBody> uploadHd(@Url String path, @Part MultipartBody.Part part);
    Observable<ResponseBody> uploadHd(@Url String path, @Part MultipartBody.Part part);

    @Multipart
    @POST
    Observable<ResponseBody> uploadHd(@Url String path, @Part MultipartBody.Part part, @Query("author") String author, @Query("author_phone") String author_phone);

    @POST
    Observable<ResponseBody> postInfo(@Url String path, @QueryMap HashMap<String, Object> map);

    @POST
    Observable<ResponseBody> postInfoWithBody(@Url String path, @Body RequestBody body);

    @PUT
    Observable<ResponseBody> putInfo(@Url String path, @QueryMap HashMap<String, Object> map);

    @PUT
    Observable<ResponseBody> putInfoWithBody(@Url String path, @Body RequestBody body);

    @DELETE
    Observable<ResponseBody> deleteInfo(@Url String path, @QueryMap HashMap<String, Object> map);

    @DELETE
    Observable<ResponseBody> deleteInfoWithBody(@Url String path, @Body RequestBody body);
}
