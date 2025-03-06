package database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MongoDBExample {

    public static void main(String[] args) {
        try {
            MongoClient mongoClient = MongoClients.create("mongodb://root:QweAsdZxc!23@localhost:27020");


            mongoClient
                    .getDatabase("java")
                    .getCollection("users")
                    .insertOne(new Document("id", 1)
                            .append("email", "keeper@ninydev.com")
                            .append("name", "Oleksandr Nykytin")
                    );

            mongoClient
                    .getDatabase("java")
                    .getCollection("users")
                    .insertOne(new Document("id", 2)
                            .append("web", "https://ninydev.com")
                            .append("phone", "+380965747708")
                    );

            Document user = mongoClient
                    .getDatabase("java")
                    .getCollection("users")
                    .find(new Document("id", 1))
                    .first();


            System.out.println(user.toJson());


        } catch (Exception e) {
            System.out.println(e.getMessage());
            //throw new RuntimeException(e);
        }
    }
}
