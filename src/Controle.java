import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Controle {
	/*
	 * Controle e a classe que controla as entradas e saídas da lista de usuarios online
	 */

	// Essa variavel guarda uma lista com o nome do usuario e o objeto de entrada e
	// saida
	private HashMap<String, ObjectOutputStream> usuariosOnline = new HashMap<String, ObjectOutputStream>();

	// Esse metodo adiciona um objeto a lista
	public synchronized void add(String nome, ObjectOutputStream out) {
		usuariosOnline.put(nome, out);
		adicionaUsuarioOnline();
	}

	// Esse metodo adiciona um usuario a lista de usuarios online
	private void adicionaUsuarioOnline() {
		String[] usuarios = usuariosOnline.keySet().toArray(new String[1]);
		Online listaDeUsuarios = new Online(usuarios);
		comunicacaoUsuarios(listaDeUsuarios);
	}

	// Esse metodo é responsavel pela comunicacao entre os usuarios
	public synchronized void comunicacaoUsuarios(Usuario usuario) {
		for (ObjectOutputStream out : usuariosOnline.values()) {
			try {
				out.writeObject(usuario);
			} catch (IOException e) {
			}
		}
	}
	
	//Essa classe remove o usuario da lista de usuarios online 
	public synchronized void removeUsuarioOnline(String nome) {
		usuariosOnline.remove(nome);
		Cliente usuario = new Cliente("SYSTEM", "O " + nome + " foi-se embora");
		comunicacaoUsuarios(usuario);
		adicionaUsuarioOnline();
	}
}
