import java.rmi.*;
import java.rmi.registry.*;

public class Server {
    public static void main(String args[]) {
        try {
            Converter converter = new ConverterImplementation();
            LocateRegistry.createRegistry(1900);
            Naming.rebind("rmi://localhost:1900/predator", converter);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}