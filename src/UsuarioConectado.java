import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class UsuarioConectado extends Thread {
	public UsuarioControle outs;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private String nick;
	private Socket socket;

	public UsuarioConectado(Socket socket, UsuarioControle outs) {
		this.outs = outs;
		this.socket = socket;
		connectToUsuario(socket, outs);
	}

	private void connectToUsuario(Socket socket, UsuarioControle outs) {
		try {
			in = new ObjectInputStream(socket.getInputStream());
			out = new ObjectOutputStream(socket.getOutputStream());
			nick = (String) in.readObject();
			outs.add(nick, out);
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				Online operacao = (Online) in.readObject();
				outs.broadcastUsuarios(operacao);
			}
		} catch (IOException e) {
			outs.remove(nick);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}