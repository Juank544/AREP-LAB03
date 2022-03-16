package co.edu.escuelaing.services;

import com.mongodb.client.*;
import com.mongodb.client.model.Sorts;
import org.bson.Document;

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

        FindIterable<Document> findIterable =cadenasCollection.find().sort(Sorts.descending("fecha")).limit(-10);

//        Iterator<Document> iterator = findIterable.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

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
