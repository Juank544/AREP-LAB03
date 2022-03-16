package co.edu.escuelaing;

import co.edu.escuelaing.services.MongoDB;

import static spark.Spark.*;

/**
 * Hello world!
 * @author Juank544
 */
public class App 
{
    static MongoDB mongoDB = new MongoDB();

    public static void main( String[] args )
    {
        port(getPort());

        get("/", ((request, response) -> "Hello Docker!"));

        path("/api/v1",()->{
            get("/cadenas", ((request, response) -> {
                response.type("application/json");

                return mongoDB.getCadenas();
            }));

            post("/cadena",((request, response) -> {
                response.type("application/json");

                if (request.body() != null){
                    mongoDB.agregar(request.body());
                }
                return mongoDB.getCadenas();
            }));
        });
    }

    private static int getPort(){
        if (System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
