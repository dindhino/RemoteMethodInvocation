
import java.rmi.*;

public interface Adder extends Remote {

    public long tambah(int x, int y) throws RemoteException;

    public int kurang(int x, int y) throws RemoteException;

    public String bagi(int x, int y) throws RemoteException;

    public long kali(int x, int y) throws RemoteException;
}
