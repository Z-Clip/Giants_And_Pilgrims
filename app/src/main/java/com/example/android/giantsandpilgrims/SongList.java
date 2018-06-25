package com.example.android.giantsandpilgrims;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SongList extends AppCompatActivity {
    String albumTextID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list_layout);
        Bundle bundle = getIntent().getExtras();
        albumTextID = bundle.getString("albumID");
    }

}
