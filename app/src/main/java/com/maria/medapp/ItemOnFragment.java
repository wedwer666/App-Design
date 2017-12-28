package com.maria.medapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.maria.medapp.API.model.User;
import com.maria.medapp.API.service.UserClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ItemOnFragment extends Fragment {

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
        final EditText description = (EditText) view.findViewById(R.id.editdescription);

        Button createAccountButton = (Button) view.findViewById(R.id.requestbutton);
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User(
                        name.getText().toString(),
                        desease.getText().toString(),
                        location.getText().toString(),
                        description.getText().toString().split(",")
                );
                sendNetworkRequest(user);
            }
        });
        return view;
    }

    private void sendNetworkRequest(User user) {
        //create retrofit instance
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://81.180.72.17/api/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        //get client & call object for the request
        UserClient client = retrofit.create(UserClient.class);
        Call<User> call = client.createAccount(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(getActivity(), "Date introduse corect:", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getActivity(), "Ceva a mers gresit", Toast.LENGTH_SHORT).show();
            }
        });
    }
}