package com.maria.medapp;


import android.os.Bundle;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemFiveFragment extends Fragment {
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView mResponseTv;
    private APIService mAPIService;

    public ItemFiveFragment() {
        // Required empty public constructor
    }

    public static ItemFiveFragment newInstance()
    {
        ItemFiveFragment fragment = new ItemFiveFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_five, container, false);
        final EditText titleEt = (EditText)view.findViewById(R.id.et_title);
        final EditText bodyEt = (EditText)view.findViewById(R.id.et_body);
        Button submitBtn = (Button)view.findViewById(R.id.btn_submit);
        mResponseTv = (TextView)view.findViewById(R.id.tv_response);
        mAPIService = ApiUtils.getAPIService();
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleEt.getText().toString().trim();
                String body = bodyEt.getText().toString().trim();
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

//    public void updatePost(long id, String title, String body) {
//        mAPIService.updatePost(id, title, body, 1).enqueue(new Callback<Post>() {
//            @Override
//            public void onResponse(Call<Post> call, Response<Post> response) {
//
//                if(response.isSuccessful()) {
//                    showResponse(response.body().toString());
//                    Log.i(TAG, "Update la date introduse" + response.body().toString());
//                }
//            }
//            @Override
//            public void onFailure(Call<Post> call, Throwable t) {
//
//                showErrorMessage();
//                Log.e(TAG, "Unable to update post.");
//            }
//        });
//    }


    public void showResponse(String response) {
        if(mResponseTv.getVisibility() == View.GONE) {
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(response);
    }
}


