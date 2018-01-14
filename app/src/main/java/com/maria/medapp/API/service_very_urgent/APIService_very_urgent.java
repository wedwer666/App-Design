package com.maria.medapp.API.service_very_urgent;

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

public interface APIService_very_urgent {
    @POST("/comments")
    @FormUrlEncoded
    Call<Post> savePost(@Field("titlu") String titlu,
                        @Field("bod") String bod,
                        @Field("loc") String loc);

    @POST("/comments")
    Call<Post> savePost(@Body Post post);

    @PUT("/comments/{id}")
    @FormUrlEncoded
    Call<Post> updatePost(@Path("id") long id,
                          @Field("titlu") String titlu,
                          @Field("bod") String bod,
                          @Field("loc") String loc);

    @DELETE("/comments/{id}")
    Call<Post> deletePost(@Path("id") long id);
}
