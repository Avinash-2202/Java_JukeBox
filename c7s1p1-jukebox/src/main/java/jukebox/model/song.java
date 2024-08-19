package jukebox.model;

public class song {
    private int songId;
    private String songName;
    private String artist;
    private String genre;

    private float duration;
    private String url;

    public song(int songId, String songName, String artist, String genre,   float duration, String url) {
        this.songId = songId;
        this.songName = songName;
        this.artist = artist;
        this.genre = genre;
        this.duration = duration;
        this.url = url;
    }

    public void setSongId(int songId) {

        this.songId = songId;
    }

    public void setSongName(String songName) {

        this.songName = songName;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public int getSongId() {
        return songId;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }


    public float getDuration() {
        return duration;
    }

    public String geturl() {
        return url;
    }

    public void setURL(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", songName='" + songName + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", url='" + url + '\'' +
                '}';
    }
}
