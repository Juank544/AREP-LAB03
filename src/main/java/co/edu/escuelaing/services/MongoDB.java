package co.edu.escuelaing.services;

import com.mongodb.client.*;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.*;

import static com.mongodb.client.model.Aggregates.limit;

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

        Bson projectionFields = Projections.fields(
                Projections.include("contenido","fecha"),
                Projections.excludeId());

        MongoCursor<Document> cursor = cadenasCollection.find().projection(projectionFields).sort(Sorts.descending("fecha")).limit(-10).iterator();

        try {
            while (cursor.hasNext()){
                cadenasList.add(cursor.next().toJson());
            }
        } finally {
            cursor.close();
        }

        System.out.println(cadenasList);
        return cadenasList;
    }
}
