package RMI;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class ServidorImpl implements Servidor {

    private Map<String, Trabalhador> listaTrabalhadores;
    private Map<String, Cliente> listaCliente;


    public ServidorImpl() {
        this.listaCliente = new HashMap<String, Cliente>();
        this.listaTrabalhadores = new HashMap<String, Trabalhador>();
    }

    @Override
    public Object conecta(Object object) throws RemoteException {
        if (object instanceof Cliente) {

            Cliente c = this.listaCliente.get(((Cliente) object).getNomeZona());
            if (c != null) return c;
            Cliente objUsuario = new ClienteImpl(c.getNomePasta(), c.getNomeZona());
            Cliente refRemotaCliente = (Cliente) UnicastRemoteObject.exportObject(objUsuario, 0);
            listaCliente.put(c.getNomeZona(), refRemotaCliente);

        }
        return null;
    }

    @Override
    public Map<String, Trabalhador> getTrabalhador() throws RemoteException {
        return null;
    }

    @Override
    public Map<String, Cliente> getCliente() throws RemoteException {
        return null;
    }
}
