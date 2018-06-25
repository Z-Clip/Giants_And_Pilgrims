package com.example.android.giantsandpilgrims;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class SongList extends AppCompatActivity {
    String albumTextID;
    String albumName;
    ImageView backgroundImage;
    TextView header;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list_layout);

        Bundle bundle = getIntent().getExtras();
        albumTextID = bundle.getString("albumID");
        albumName = bundle.getString("albumName");

        getViewObjectIDs();
        setViews();
    }

    public void getViewObjectIDs() {
        backgroundImage = findViewById(R.id.background_image);
        header = findViewById(R.id.header_view);
    }

    public void setViews() {
        backgroundImage.setImageResource(getResources().getIdentifier("com.example.android.giantsandpilgrims:drawable/" + albumTextID + "_full", null, null));
        header.setText(albumName);
    }

}
