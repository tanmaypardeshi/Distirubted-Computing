import java.rmi.*;

public interface Converter extends Remote {
    public double convertFeet(double feet) throws RemoteException;
}