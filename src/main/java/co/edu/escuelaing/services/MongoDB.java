package co.edu.escuelaing.services;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.*;

public class MongoDB {
    //Yo sé que esto no se debe hacer, pero es con fines académicos xd
    MongoClient client = MongoClients.create("mongodb+srv://JuankAREP:AREP0323@cluster0.9cn0l.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
    MongoDatabase database = client.getDatabase("LAB03");
    MongoCollection<Document> cadenasCollection = database.getCollection("cadenas");

    public void agregar(){
        Document test = new Document("_id", UUID.randomUUID().toString())
                .append("contenido","quince")
                .append("fecha",String.valueOf(new Date()));
        cadenasCollection.insertOne(test);
    }

    public List<String> getCadenas(){
        List<String> cadenasList = new ArrayList<>();

        FindIterable<Document> findIterable =cadenasCollection.find().limit(10);
        Iterator<Document> iterator = findIterable.iterator();

        ArrayList<Document> temp = new ArrayList<>();
        findIterable.into(temp);
        temp.forEach(document -> {
            String cadena = document.toJson();
            cadenasList.add(cadena);
        });

        System.out.println(cadenasList);

        return cadenasList;
    }
}
