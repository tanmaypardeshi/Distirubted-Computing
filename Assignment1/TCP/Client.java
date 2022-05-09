import java.net.*;
import java.io.*;

public class Client {
    public static void main(String args[]) throws IOException, UnknownHostException {
        Socket cs = new Socket("Predator", 5001);

        BufferedReader fromclient = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fromserver = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        PrintWriter toserver = new PrintWriter(cs.getOutputStream(), true);

        while(true) {
            String c = fromserver.readLine();
            System.out.println("From server " + c);

            if(c.equalsIgnoreCase("bye")) {
                break;
            }
            System.out.println("Enter distance in feet:- ");
            String feet = fromclient.readLine();
            toserver.println(feet);
            if(feet.equalsIgnoreCase("bye")) {
                break;
            }
        }
        toserver.close();
        fromserver.close();
        fromclient.close();
        cs.close();
    }
    
}