package com.maria.medapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.maria.medapp.API.model.Post;
import com.maria.medapp.API.service_register_user.APIService;
import com.maria.medapp.API.service_register_user.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ItemThreeFragment extends Fragment {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView tv_response_profile;

    private APIService mAPIService;
    public static ItemThreeFragment newInstance() {
        ItemThreeFragment fragment = new ItemThreeFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_three, container, false);

        final EditText name = (EditText) view.findViewById(R.id.editText5);
        final EditText day = (EditText) view.findViewById(R.id.editText4);
//        final EditText location = (EditText) view.findViewById(R.id.editlocation);
        // final EditText description = (EditText) view.findViewById(R.id.editdescription);
        Button submitprofile = (Button)view.findViewById(R.id.button3);
        tv_response_profile = (TextView)view.findViewById(R.id.tv_response_profile);
        mAPIService = ApiUtils.getAPIService();
        submitprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = name.getText().toString().trim();
                String body = day.getText().toString().trim();
//                String loc = location.getText().toString().trim();

                if(!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)) {
                    sendPost(title, body);
                }
            }
        });

        return view;
    }
    public void showErrorMessage() {
        Toast.makeText(getActivity(), R.string.mssg_error_submitting_post, Toast.LENGTH_SHORT).show();
    }

    public void sendPost(String title, String body) {

        mAPIService.savePost(title, body, 1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "Post trimis la API" + response.body().toString());
                }

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

                showErrorMessage();
                Log.e(TAG, "Nu pot trimite post la API");
            }
        });
    }

    public void updatePost(long id, String title, String body) {
        mAPIService.updatePost(id, title, body, 1).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if(response.isSuccessful()) {
                    showResponse(response.body().toString());
                    Log.i(TAG, "Update la date introduse" + response.body().toString());
                }
            }
            @Override
            public void onFailure(Call<Post> call, Throwable t) {

                showErrorMessage();
                Log.e(TAG, "Unable to update post.");
            }
        });
    }


    public void showResponse(String response) {
        if(tv_response_profile.getVisibility() == View.GONE) {
            tv_response_profile.setVisibility(View.VISIBLE);
        }
        tv_response_profile.setText(response);
    }

}
