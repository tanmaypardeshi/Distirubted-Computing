import java.net.*;
import java.io.*;

public class Server {
    ServerSocket ss = new ServerSocket(5001);
    int id = 0;

    public static void main(String args[]) throws IOException {
        new Server();
    }

    Server() throws IOException {
        while(true) {
            id++;
            ClientThread ct = new ClientThread(ss.accept(), id);
            Thread t = new Thread(ct);
            t.start();       
        }
    }
}

class ClientThread implements Runnable {
    Socket cs;
    int id;

    ClientThread(Socket cs, int id) {
        this.cs = cs;
        this.id = id;
    }

    public void run() {
        try {
            BufferedReader fromclient = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            PrintWriter toclient = new PrintWriter(cs.getOutputStream(), true);
            toclient.println("Welcome client " + id);
            while(true) {
                String c  = fromclient.readLine();
                if(c.contains("bye")) {
                    break;
                }

                try {
                    double feet = Double.parseDouble(c);
                    double metres = 0.3048 * feet;
                    System.out.println(metres);
                    System.out.println("From client " + id + " distance in feet is:- " + c);
                    System.out.println("Converted " + c + " feet to metres and sent to client " + id);
                    toclient.println("Distance in metres is " + String.valueOf(metres));

                } catch(Exception e) {
                    System.out.println(e.getMessage());
                    toclient.println(e.getMessage());
                }
            }
            System.out.println("Communication with client " + id + " closed");
            toclient.close();
            fromclient.close();
            cs.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}

    

    

    

    

    

    

    

    

             