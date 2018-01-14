package com.maria.medapp.API.service_very_urgent;

import com.maria.medapp.API.service_register_user.APIService;
import com.maria.medapp.API.service_register_user.RetrofitClient;

/**
 * Created by Maria on 05.01.2018.
 */

public class API_Utils_very_urgent {

    private API_Utils_very_urgent() {}

    public static final String BASE_URL = "http://jsonplaceholder.typicode.com/posts/";

    public static APIService getAPIService_urgent() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
