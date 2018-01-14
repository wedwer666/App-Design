package com.maria.medapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Maria on 28.12.2017.
 */

public class WelcomeActivity extends AppCompatActivity {

    public Button butlog;

    public void init()
    {
        butlog = (Button)findViewById(R.id.loginbtn);
        butlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, ItemFiveFragment.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
        init();
    }
}
