import java.rmi.*;
import java.util.*;

public class Client {
    public static void main(String args[]) {
        try {
            double feet, metres;
            Scanner sc = new Scanner(System.in);
            Converter converter = (Converter) Naming.lookup("rmi://localhost:1900/predator");
            System.out.println("Enter distance in feet:- ");
            feet = sc.nextDouble();
            metres = converter.convertFeet(feet);
            System.out.println("Distance in metres is " + metres);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}