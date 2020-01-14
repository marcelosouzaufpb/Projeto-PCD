import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	/*
	 * O servidor e uma classe muito simples ela tem uma porta que se conecta a um
	 * canal que passa pela classe controle
	 */

	private static final int PORT = 123;

	private void init() {
		Controle usuario = new Controle();
		ServerSocket servidor = null;
		try {
			servidor = new ServerSocket(PORT);
			System.out.println("Servidor Online na porta: " + PORT + "\n");
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