package com.example.android.giantsandpilgrims;

public class AlbumInfo {

    private int mCoverDrawableID;
    private String mAlbumName;
    private int mAlbumYear;
    private String mAlbumIdentifier;

    //Constructor
    public AlbumInfo(int drawableID , String albumName, int albumYear , String albumIdentifier) {
        mCoverDrawableID = drawableID;
        mAlbumName = albumName;
        mAlbumYear = albumYear;
        mAlbumIdentifier = albumIdentifier;
    }

    //Return the album cover drawable resource ID
    public int getCoverDrawableID () {
        return mCoverDrawableID;
    }

    //Return the album name
    public String getAlbumName () {
        return mAlbumName;
    }

    //Return the album year
    public int getAlbumYear () {
        return mAlbumYear;
    }

    //Return the album identifier
    public String getAlbumTextIdentifier() {return mAlbumIdentifier;}

}
