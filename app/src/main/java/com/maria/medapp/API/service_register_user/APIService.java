package com.maria.medapp.API.service_register_user;

import com.maria.medapp.API.model.Post;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Maria on 05.01.2018.
 */

public interface APIService {

    @POST("/posts")
    @FormUrlEncoded
    Call<Post> savePost(@Field("title") String title,
                        @Field("body") String body,
                        @Field("userId") long userId);

    // RxJava
   /* @POST("/posts")
    @FormUrlEncoded
    Observable<Post> savePost(@Field("title") String title,
                              @Field("body") String body,
                              @Field("userId") long userId);*/

    @POST("/posts")
    Call<Post> savePost(@Body Post post);

    @PUT("/posts/{id}")
    @FormUrlEncoded
    Call<Post> updatePost(@Path("id") long id,
                          @Field("title") String title,
                          @Field("body") String body,
                          @Field("userId") long userId);

    @DELETE("/posts/{id}")
    Call<Post> deletePost(@Path("id") long id);

}

