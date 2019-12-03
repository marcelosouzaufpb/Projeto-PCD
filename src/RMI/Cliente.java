package RMI;

import java.io.OutputStream;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Cliente extends Remote, Serializable {

    void enviarImagens() throws RemoteException;

    List<Trabalhador> trabalhadoresMudarNome() throws RemoteException;

    void addImagem(OutputStream img) throws RemoteException;

    void addTrabalhador(Trabalhador trabalhador);

    String getNomeZona();

    String getNomePasta();
}
