package edu.eci.arep.database;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.*;

public class DB {

    MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://admin:lmp6hSME8cJ2gC5T@arepita.bd7fu.mongodb.net/sample_airbnb?retryWrites=true&w=majority");

    MongoClient mongoClient = new MongoClient(uri);
    MongoDatabase database = mongoClient.getDatabase("sample_airbnb");
    MongoCollection<Document> collection = database.getCollection("listingsAndReviews");
    ArrayList<reviewairbnb> reviewairbnbList = new ArrayList<>();

    public void start() {
        for (Document d : collection.find()
        ) {
            reviewairbnbList.add(new reviewairbnb(d.get("listing_url").toString(), d.get("name").toString(), d.get("notes").toString(), d.get("room_type").toString()));
        }
        for (reviewairbnb r: reviewairbnbList
             ) {
            System.out.println(r.name);
        }
    }

}
