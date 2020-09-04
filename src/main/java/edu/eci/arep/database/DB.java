package edu.eci.arep.database;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.*;

/**
 * The type Db.
 */
public class DB {

    /**
     * The Uri.
     */
    MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://admin:lmp6hSME8cJ2gC5T@arepita.bd7fu.mongodb.net/sample_airbnb?retryWrites=true&w=majority");

    /**
     * The Mongo client.
     */
    MongoClient mongoClient = new MongoClient(uri);
    /**
     * The Database.
     */
    MongoDatabase database = mongoClient.getDatabase("sample_airbnb");
    /**
     * The Collection.
     */
    MongoCollection<Document> collection = database.getCollection("listingsAndReviews");
    /**
     * The Reviewairbnb list.
     */
    ArrayList<reviewairbnb> reviewairbnbList = new ArrayList<>();

    /**
     * Start.
     */
    public void start() {
        for (Document d : collection.find()
        ) {
            reviewairbnbList.add(new reviewairbnb(d.get("listing_url").toString(), d.get("name").toString(), d.get("notes").toString(), d.get("room_type").toString()));
        }
        for (reviewairbnb r : reviewairbnbList
        ) {
            System.out.println(r.name);
        }
    }

}
