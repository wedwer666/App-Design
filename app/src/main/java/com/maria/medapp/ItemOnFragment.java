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
import com.maria.medapp.API.service_very_urgent.API_Utils_very_urgent;
import com.maria.medapp.API.service_very_urgent.APIService_very_urgent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ItemOnFragment extends Fragment {
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView mResponseTv_urgent;

    private APIService mAPIService;

    public static ItemOnFragment newInstance() {
        ItemOnFragment itemOnFragment = new ItemOnFragment();
        return itemOnFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_item_one, container, false);

        final EditText name = (EditText) view.findViewById(R.id.editname);
        final EditText desease = (EditText) view.findViewById(R.id.editdesease);
        final EditText location = (EditText) view.findViewById(R.id.editlocation);
        // final EditText description = (EditText) view.findViewById(R.id.editdescription);
        Button submitBtn = (Button)view.findViewById(R.id.requestbutton);
        mResponseTv_urgent = (TextView)view.findViewById(R.id.tv_response_very_urgent);
        mAPIService = ApiUtils.getAPIService();
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = name.getText().toString().trim();
                String body = desease.getText().toString().trim();
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
        if(mResponseTv_urgent.getVisibility() == View.GONE) {
            mResponseTv_urgent.setVisibility(View.VISIBLE);
        }
        mResponseTv_urgent.setText(response);
    }

}