package co.edu.escuelaing.services;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.Date;
import java.util.UUID;

public class MongoDB {
    //Yo sé que esto no se debe hacer, pero es con fines académicos xd
    MongoClient client = MongoClients.create("mongodb+srv://JuankAREP:AREP0323@cluster0.9cn0l.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
    MongoDatabase database = client.getDatabase("LAB03");
    MongoCollection<Document> cadenas = database.getCollection("cadenas");

    public void agregar(){
        Document test = new Document("_id", UUID.randomUUID().toString()).append("contenido","la cuarta").append("fecha",String.valueOf(new Date()));
        cadenas.insertOne(test);
    }
}
