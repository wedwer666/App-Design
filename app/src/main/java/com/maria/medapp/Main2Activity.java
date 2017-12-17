package com.maria.medapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    int pos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        Intent intent = getIntent();
        pos =intent.getExtras().getInt("Position");
        final CustomAdapter adapter = new CustomAdapter(this);
        final ImageView img = (ImageView)findViewById(R.id.imgid);
        final TextView name = (TextView)findViewById(R.id.personame);
        final TextView type = (TextView)findViewById(R.id.type);

        // set data
        img.setImageResource(adapter.image[pos]);
        name.setText(adapter.names[pos]);
        type.setText(adapter.descritipion[pos]);
        Button btnnext = (Button)findViewById(R.id.buttonnext);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int position = pos+1;
                name.setText("Name:" + adapter.names[position]);
                type.setText("Description: " + adapter.descritipion[position]);
                img.setImageResource(adapter.image[position]);

                if (!(position > adapter.getCount() - 1))
                {
                    pos +=1;
                }
                else
                {
                    pos= -1;
                }
            }
        });
    }
}
