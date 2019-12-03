package RMI;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Trabalhador extends Remote, Serializable {

    void search() throws RemoteException;
}
