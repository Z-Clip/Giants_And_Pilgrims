package com.example.android.giantsandpilgrims;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumArrayAdapter extends ArrayAdapter {

    public AlbumArrayAdapter (Activity context , ArrayList<AlbumInfo> albumInfo){
        super(context, 0 , albumInfo);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final AlbumInfo currentAlbum = (AlbumInfo) getItem(position);
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_info, parent, false);
        }

        //Populate the album cover thumbnail
        ImageView albumCoverArt = listItemView.findViewById(R.id.album_cover_image);
        albumCoverArt.setImageResource(currentAlbum.getCoverDrawableID());

        //Populate the album name textview
        final TextView albumName = listItemView.findViewById(R.id.album_name);
        final String mAlbumName = currentAlbum.getAlbumName();
        albumName.setText(mAlbumName);

        //Populate the album year textview
        TextView albumYear = listItemView.findViewById(R.id.album_year);
        albumYear.setText(String.valueOf(currentAlbum.getAlbumYear()));

        //Define the text ID to pass in the on-click listener
        final String mAlbumTextID = currentAlbum.getAlbumTextIdentifier();

        //Create on-click listener
        listItemView.setTag(position);
        listItemView.setOnClickListener((new View.OnClickListener() {
            // The code in this method will be executed when the family category is clicked on.
            @Override
            public void onClick(View view) {
                Context context = getContext();
                Intent songListIntent = new Intent(context, SongList.class);
                songListIntent.putExtra("albumID" , mAlbumTextID);
                songListIntent.putExtra("albumName" , mAlbumName);
                context.startActivity(songListIntent);
            }
        }));
        return listItemView;
    }
}
