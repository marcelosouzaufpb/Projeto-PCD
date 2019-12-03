package RMI;

import java.io.OutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ClienteImpl implements Cliente {

    private List<OutputStream> listaImagens;
    private String nomePasta;
    private List<Trabalhador> tipoProcuraDisponivel;
    private String nomeZona;

    public ClienteImpl(String nomePasta, String nomeZona) {
        this.listaImagens = new ArrayList<>();
        this.tipoProcuraDisponivel = new ArrayList<>();
        this.nomePasta = nomePasta;
        this.nomeZona = nomeZona;
    }

    @Override
    public void enviarImagens() throws RemoteException {
    }

    @Override
    public List<Trabalhador> trabalhadoresMudarNome() throws RemoteException {
        return null;
    }

    @Override
    public void addImagem(OutputStream img) throws RemoteException {
        this.listaImagens.add(img);
    }

    @Override
    public void addTrabalhador(Trabalhador trabalhador) {
        this.tipoProcuraDisponivel.add(trabalhador);
    }

    @Override
    public String getNomeZona() {
        return this.nomeZona;
    }

    @Override
    public String getNomePasta() {
        return this.nomePasta;
    }
}
