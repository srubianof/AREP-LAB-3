package edu.eci.arep.database;

public class reviewairbnb {
    String url, name, notes, roomtype;

    public reviewairbnb(String url, String name, String notes, String roomtype) {
        this.url = url;
        this.name = name;
        this.notes = notes;
        this.roomtype = roomtype;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }


}
