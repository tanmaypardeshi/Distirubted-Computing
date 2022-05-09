import java.rmi.*;
import java.rmi.server.*;

public class ConverterImplementation extends UnicastRemoteObject implements Converter {
    ConverterImplementation() throws RemoteException {
        super();
    }

    public double convertFeet(double feet) throws RemoteException {
        System.out.println("Distance received in feet is " + feet + " feet.");
        return feet * 0.3048;
    }
}