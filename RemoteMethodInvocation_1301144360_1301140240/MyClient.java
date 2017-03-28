
import java.net.MalformedURLException;
import java.rmi.*;

public class MyClient {

    public static void main(String args[]) {
        try {
            Adder stub = (Adder) Naming.lookup("rmi://localhost:5000/testrmi");
            System.out.print("34 + 4 = ");
            System.out.println(stub.tambah(34, 4));

            System.out.print("2147483646 + 2147483646 = ");
            System.out.println(stub.tambah(2147483646, 2147483646));

            System.out.print("2147483646 - 0 = ");
            System.out.println(stub.kurang(2147483646, 0));

            System.out.print("0 - 2147483646 = ");
            System.out.println(stub.kurang(0, 2147483646));

            System.out.print("1 / 8 = ");
            System.out.println(stub.bagi(1, 8));

            System.out.print("1 / 0 = ");
            System.out.println(stub.bagi(1, 0));
            
            System.out.print("0 / 0 = ");
            System.out.println(stub.bagi(0, 0));

            System.out.print("2147483646 x 2147483646 = ");
            System.out.println(stub.kali(2147483646, 2147483646));
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
        }
    }
}
