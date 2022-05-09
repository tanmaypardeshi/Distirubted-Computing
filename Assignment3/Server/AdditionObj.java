import AdditionApp.*;
import java.util.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

class AdditionObj extends AdditionPOA {
    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public void shutdown() {
        orb.shutdown(false);
    }
}