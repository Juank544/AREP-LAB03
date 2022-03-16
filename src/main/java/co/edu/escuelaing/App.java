package co.edu.escuelaing;

import co.edu.escuelaing.services.MongoDB;

import static spark.Spark.port;

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
        mongoDB.getCadenas();
    }

    private static int getPort(){
        if (System.getenv("PORT") != null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
