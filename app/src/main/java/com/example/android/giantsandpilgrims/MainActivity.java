package com.example.android.giantsandpilgrims;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public String[] albumTitles;
    public int[] albumYears;
    public String[] albumCoverResourceNames;
    public int[] albumCoverResourceIDs;
    public ArrayList<AlbumInfo> albumInfo = new ArrayList<>();
    public RelativeLayout bellwether;
    public RelativeLayout joyousMysteries;
    public RelativeLayout becoming;
    public RelativeLayout almanac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.album_layout);

        createArrays();

        AlbumArrayAdapter albumAdapter = new AlbumArrayAdapter(this , albumInfo);
        ListView listView = (ListView) findViewById(R.id.album_list);
        listView.setAdapter(albumAdapter);
    }

    public void createArrays() {
        Resources resource = getResources();
        albumCoverResourceNames = resource.getStringArray(resource.getIdentifier("album_cover_names", "array", getPackageName()));
        albumTitles = resource.getStringArray(resource.getIdentifier("album_titles", "array", getPackageName()));
        albumYears = resource.getIntArray(resource.getIdentifier("album_year" , "array" , getPackageName()));

        albumCoverResourceIDs = new int[albumCoverResourceNames.length];
        for (int i = 0 ; i < albumCoverResourceNames.length ; i++) {
            albumCoverResourceIDs[i] = getResources().getIdentifier("com.example.android.giantsandpilgrims:drawable/" + albumCoverResourceNames[i] , null, null);
        }

        for (int i = 0 ; i < albumTitles.length ; i++) {
            albumInfo.add(i , new AlbumInfo(albumCoverResourceIDs[i] , albumTitles[i] , albumYears[i]));
        }
    }
}