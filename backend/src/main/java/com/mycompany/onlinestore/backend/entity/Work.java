package com.mycompany.onlinestore.backend.entity;

public class Work {
    private long id;
    private static int lastId = 1;
    private String title;
    private String genre;
    private int release;
    private String summary;
    private Artist mainArtist;

    public Work(String title) {
        this.title = title;
        this.id = lastId++;
    }

    public Work() {
        this.id = lastId++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Artist getMainArtist() {
        return mainArtist;
    }

    public void setMainArtist(Artist mainArtist) {
        this.mainArtist = mainArtist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
