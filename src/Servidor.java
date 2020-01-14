import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private static final int PORT = 123;

	private void init() {
		Controle usuario = new Controle();
		ServerSocket servidor = null;
		try {
			servidor = new ServerSocket(PORT);
			System.out.println("Servidor Online na porta: " + PORT);
			while (true) {
				Socket canal = servidor.accept();
				Verificacao online = new Verificacao(canal, usuario);
				online.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				servidor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		new Servidor().init();
	}
}