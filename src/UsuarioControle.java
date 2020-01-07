import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class UsuarioControle {
	private HashMap<String, ObjectOutputStream> outs = new HashMap<String, ObjectOutputStream>();

	public synchronized void add(String nick, ObjectOutputStream out) {
		outs.put(nick, out);
		sendUserList();
	}

	private void sendUserList() {
		String[] usuarios = outs.keySet().toArray(new String[1]);
		ListaDeUsuarios listaDeUsuarios = new ListaDeUsuarios(usuarios);
		broadcastUsuarios(listaDeUsuarios);
	}

	public synchronized void broadcastUsuarios(Online listaDeUsuarios) {
		for (ObjectOutputStream out : outs.values()) {
			try {
				out.writeObject(listaDeUsuarios);
			} catch (IOException e) {

			}
		}
	}

	public synchronized void remove(String nick) {
		outs.remove(nick);
		Usuario usuario = new Usuario("SYSTEM", "O " + nick + " foi-se embora");
		broadcastUsuarios(usuario);
		sendUserList();
	}
}
