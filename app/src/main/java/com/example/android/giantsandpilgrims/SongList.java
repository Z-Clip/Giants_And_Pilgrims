package com.example.android.giantsandpilgrims;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SongList extends AppCompatActivity {
    String albumTextID;
    String albumName;
    ImageView backgroundImage;
    TextView header;
    TextView backView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list_layout);

        Bundle bundle = getIntent().getExtras();
        albumTextID = bundle.getString("albumID");
        albumName = bundle.getString("albumName");

        getViewObjectIDs();
        setViews();

        backView.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songListIntent = new Intent(SongList.this, MainActivity.class);
                startActivity(songListIntent);
            }
        }));
    }

    public void getViewObjectIDs() {
        backgroundImage = findViewById(R.id.background_image);
        header = findViewById(R.id.header_view);
        backView = findViewById(R.id.back_button);
    }

    public void setViews() {
        backgroundImage.setImageResource(getResources().getIdentifier("com.example.android.giantsandpilgrims:drawable/" + albumTextID + "_full", null, null));
        header.setText(albumName);
    }

}
