package com.example.android.giantsandpilgrims;

import android.app.Activity;
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
        AlbumInfo currentAlbum = (AlbumInfo) getItem(position);
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_info, parent, false);
        }

        RelativeLayout albumInfoViewGroup = listItemView.findViewById(R.id.album_info_view_group);
        albumInfoViewGroup.setTag(currentAlbum.getAlbumName() + "view_group");

        ImageView albumCoverArt = listItemView.findViewById(R.id.album_cover_image);
        albumCoverArt.setImageResource(currentAlbum.getCoverDrawableID());

        TextView albumName = listItemView.findViewById(R.id.album_name);
        albumName.setText(currentAlbum.getAlbumName());

        TextView albumYear = listItemView.findViewById(R.id.album_year);
        albumYear.setText(String.valueOf(currentAlbum.getAlbumYear()));

        return listItemView;
    }
}
