import java.io.*;
import java.net.*;

public class Server {

    public static final int PORT = 5001;

    public static void main(String args[]) throws IOException {
        try {
            
            DatagramSocket socket = new DatagramSocket(PORT);
            byte[] sendBuffer = new byte[1024];
            byte[] receiveBuffer = new byte[1024];
            System.out.println("Server started, Waiting for client to connect...");
            
            while(true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                socket.receive(receivePacket);
                
                String feetString = new String(receivePacket.getData());
                InetAddress ip = receivePacket.getAddress();
                int port = receivePacket.getPort();

                double feet = Double.parseDouble(feetString);
                double metres = feet * 0.3048;

                System.out.println("Sending result = " + metres + " metres to client");
                String metresString = String.valueOf(metres);
                sendBuffer = metresString.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, ip, port);
                socket.send(sendPacket);
            }

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}