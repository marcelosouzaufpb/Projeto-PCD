package RMI;



import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface Servidor extends Remote, Serializable {

     Object conecta(Object object ) throws RemoteException;

     Map<String, Trabalhador> getTrabalhador() throws RemoteException;

     Map<String, Cliente> getCliente() throws RemoteException;

}
