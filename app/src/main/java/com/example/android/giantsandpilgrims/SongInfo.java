package com.example.android.giantsandpilgrims;

public class SongInfo {

    private String mSongName;
    private String mSongLength;

    //Constructor
    public SongInfo(String songName , String songLength) {
        mSongName = songName;
        mSongLength = songLength;
    }

    //Return the name of the song.
    public String getSongName() {
        return mSongName;
    }

    //Return the length of the song.
    public String getSongLength() {
        return mSongLength;
    }

}
