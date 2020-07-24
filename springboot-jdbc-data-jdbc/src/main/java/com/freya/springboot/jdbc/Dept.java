package com.freya.springboot.jdbc;

public class Dept {

    public int id;

    public String title;

    public String loc;

    public Dept() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept [id=" + id + ", title=" + title + ", loc=" + loc + "]";
    }


}