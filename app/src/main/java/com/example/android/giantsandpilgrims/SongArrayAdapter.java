package com.example.android.giantsandpilgrims;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongArrayAdapter extends ArrayAdapter {

    public SongArrayAdapter (Activity context , ArrayList<SongInfo> songInfo){
        super(context, 0 , songInfo);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final SongInfo currentSong = (SongInfo) getItem(position);
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_info, parent, false);
        }

        //Set the song name view
        TextView songNameView = listItemView.findViewById(R.id.song_name);
        songNameView.setText(String.valueOf(currentSong.getSongName()));

        //Set the song length view
        TextView songLengthView = listItemView.findViewById(R.id.song_length);
        songLengthView.setText(String.valueOf(currentSong.getSongLength()));

        return listItemView;
    }
}
