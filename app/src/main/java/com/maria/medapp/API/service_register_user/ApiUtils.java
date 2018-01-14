package com.maria.medapp.API.service_register_user;

/**
 * Created by Maria on 05.01.2018.
 */

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://jsonplaceholder.typicode.com/posts/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}