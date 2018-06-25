package com.example.android.giantsandpilgrims;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class SongList extends AppCompatActivity {
    String albumTextID;
    ImageView backgroundImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list_layout);

        Bundle bundle = getIntent().getExtras();
        albumTextID = bundle.getString("albumID");

        getViewObjectIDs();
        setViews();
    }

    public void getViewObjectIDs() {
        backgroundImage=findViewById(R.id.background_image);
    }

    public void setViews() {
        Resources resource = getResources();
        backgroundImage.setImageResource(resource.getIdentifier("com.example.android.giantsandpilgrims.drawable/" + albumTextID + "_full", null, null));
    }

}
