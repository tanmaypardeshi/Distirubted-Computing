import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
    public static final int PORT = 5001;

    public static void main(String args[]) throws IOException {
        try {
            System.out.println("Started client...");
            Scanner sc = new Scanner(System.in);
            byte[] sendingDataBuffer = new byte[1024];
            byte[] receivingDataBuffer = new byte[1024];

            DatagramSocket socket = new DatagramSocket();
            InetAddress ip = InetAddress.getByName("Predator");
            
            System.out.println("Enter distance in feet:- ");
            double feet = sc.nextDouble();
            String feetString = String.valueOf(feet);
            sendingDataBuffer = feetString.getBytes();

            DatagramPacket sendingPacket = new DatagramPacket(sendingDataBuffer, sendingDataBuffer.length, ip, PORT);
            socket.send(sendingPacket);

            DatagramPacket receivingPacket = new DatagramPacket(receivingDataBuffer, receivingDataBuffer.length);
            socket.receive(receivingPacket);
            
            String metres = new String(receivingPacket.getData());
            System.out.println("Distance in metres is = " + metres);
            socket.close();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}