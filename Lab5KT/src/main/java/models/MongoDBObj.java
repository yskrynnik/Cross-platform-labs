package models;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBObj {
    static private MongoDatabase db;

    public static MongoDatabase getDB() {
        if (db == null) {
            var mongoClient = MongoClients.create();
            MongoDBObj.db = mongoClient.getDatabase("Lab5KT");
        }

        return db;
    }
}
