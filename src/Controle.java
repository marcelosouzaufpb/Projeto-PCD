import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Controle {
	private HashMap<String, ObjectOutputStream> usuariosOnline = new HashMap<String, ObjectOutputStream>();

	public synchronized void add(String nome, ObjectOutputStream out) {
		usuariosOnline.put(nome, out);
		adicionaUsuarioOnline();
	}

	private void adicionaUsuarioOnline() {
		String[] usuarios = usuariosOnline.keySet().toArray(new String[1]);
		Online listaDeUsuarios = new Online(usuarios);
		comunicacaoUsuarios(listaDeUsuarios);
	}

	public synchronized void comunicacaoUsuarios(Usuario usuario) {
		for (ObjectOutputStream out : usuariosOnline.values()) {
			try {
				out.writeObject(usuario);
			} catch (IOException e) {
			}
		}
	}

	public synchronized void removeUsuarioOnline(String nome) {
		usuariosOnline.remove(nome);
		Cliente usuario = new Cliente("SYSTEM", "O " + nome + " foi-se embora");
		comunicacaoUsuarios(usuario);
		adicionaUsuarioOnline();
	}
}
