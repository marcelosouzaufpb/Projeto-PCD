package RMI;

import java.rmi.RemoteException;

public class TrabalhadorImpl implements Trabalhador {

    private String anguloRotacao;

    public String getAnguloRotacao() {
        return anguloRotacao;
    }

    public void setAnguloRotacao(String anguloRotacao) {
        this.anguloRotacao = anguloRotacao;
    }

    public TrabalhadorImpl(String anguloRotacao) {
        this.anguloRotacao = anguloRotacao;
    }

    @Override
    public void search() throws RemoteException {

    }
}
