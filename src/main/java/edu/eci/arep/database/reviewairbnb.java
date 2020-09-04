package edu.eci.arep.database;

/**
 * The type Reviewairbnb.
 */
public class reviewairbnb {
    /**
     * The Url.
     */
    String url, /**
     * The Name.
     */
    name, /**
     * The Notes.
     */
    notes, /**
     * The Roomtype.
     */
    roomtype;

    /**
     * Instantiates a new Reviewairbnb.
     *
     * @param url      the url
     * @param name     the name
     * @param notes    the notes
     * @param roomtype the roomtype
     */
    public reviewairbnb(String url, String name, String notes, String roomtype) {
        this.url = url;
        this.name = name;
        this.notes = notes;
        this.roomtype = roomtype;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {

        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets notes.
     *
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets notes.
     *
     * @param notes the notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Gets roomtype.
     *
     * @return the roomtype
     */
    public String getRoomtype() {
        return roomtype;
    }

    /**
     * Sets roomtype.
     *
     * @param roomtype the roomtype
     */
    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }


}
