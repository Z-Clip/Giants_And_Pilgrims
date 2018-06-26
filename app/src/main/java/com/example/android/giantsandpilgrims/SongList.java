package com.example.android.giantsandpilgrims;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongList extends AppCompatActivity {
    String albumTextID;
    String albumName;
    ImageView backgroundImage;
    TextView header;
    TextView backView;
    String[] songNameArray;
    String[] songLengthArray;
    public ArrayList<SongInfo> songInfo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list_layout);

        //Grab the album name and text ID out of the bundle
        Bundle bundle = getIntent().getExtras();
        albumTextID = bundle.getString("albumID");
        albumName = bundle.getString("albumName");

        getViewObjectIDs();
        setViews();
        enableBackButtonListener();
        createArrays();
        populateArrayList();

        //Create array adapter
        SongArrayAdapter songAdapter = new SongArrayAdapter(this , songInfo);
        ListView listView = findViewById(R.id.song_list);
        listView.setAdapter(songAdapter);
    }

    //On click listener for the "back" textview
    public void enableBackButtonListener() {
        backView.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songListIntent = new Intent(SongList.this, MainActivity.class);
                startActivity(songListIntent);
            }
        }));
    }

    //Define variables for the objects associated with the views
    public void getViewObjectIDs() {
        backgroundImage = findViewById(R.id.background_image);
        header = findViewById(R.id.header_view);
        backView = findViewById(R.id.back_button);
    }

    //Populate the views
    public void setViews() {
        backgroundImage.setImageResource(getResources().getIdentifier("com.example.android.giantsandpilgrims:drawable/" + albumTextID + "_full", null, null));
        header.setText(albumName);
    }

    //Create the song name and song length arrays
    public void createArrays() {
        Resources resource = getResources();
        songNameArray = resource.getStringArray(resource.getIdentifier(albumTextID + "_song_title_array", "array", getPackageName()));
        songLengthArray = resource.getStringArray(resource.getIdentifier(albumTextID + "_song_length_array", "array", getPackageName()));
    }

    //Populate the array list
    public void populateArrayList(){
        for (int i = 0 ; i < songNameArray.length ; i++) {
            songInfo.add(i , new SongInfo(songNameArray[i] , songLengthArray[i]));
        }
    }

}
