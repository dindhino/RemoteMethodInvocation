
import java.net.MalformedURLException;
import java.rmi.*;

public class MyServer {

    public static void main(String args[]) {
        try {
            Adder stub = new AdderRemote();
            Naming.rebind("rmi://localhost:5000/testrmi", stub);
        } catch (MalformedURLException | RemoteException e) {
            System.out.println(e);
        }
    }
}
