package com.maria.medapp.API.service_register_user;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Maria on 28.12.2017.
 */

public interface UserClient {

//    @POST("user")
//    Call<User> createAccount(@Body User user);
    @POST("UserReg")
    Call<ResponseBody> sendMessage(@Body String UserReg);

}
