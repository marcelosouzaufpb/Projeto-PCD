package Sistema;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente implements Runnable {

	private Socket usuario;
	private DataInputStream input = null;
	private DataOutputStream out = null;
	private DataInputStream in = null;

	public Cliente(Socket usuario) {
		this.usuario = usuario;
	}

	public static void main(String args[]) throws UnknownHostException, IOException {

		// para se conectar ao servidor, cria-se objeto Socket.
		// O primeiro par�metro � o IP ou endere�o da m�quina que
		// se quer conectar e o segundo � a porta da aplica��o.
		// Neste caso, usa-se o IP da m�quina local (127.0.0.1)
		// e a porta da aplica��o ServidorDeEco (12345).
		Socket socket = new Socket("127.0.0.1", 12345);

		/*
		 * Cria um novo objeto Cliente com a conex�o socket para que seja executado em
		 * um novo processo. Permitindo assim a conex�o de v�rio clientes com o
		 * servidor.
		 */
		Cliente c = new Cliente(socket);
		Thread t = new Thread(c);
		t.start();
		System.out.println(t);

	}

	public void run() {

		// establish a connection
		try {

			System.out.println("Connected");

			// takes input from terminal
			input = new DataInputStream(System.in);

			// sends output to the socket
			out = new DataOutputStream(usuario.getOutputStream());
			in = new DataInputStream(new BufferedInputStream(usuario.getInputStream()));

		} catch (UnknownHostException u) {
			System.out.println(u);
		} catch (IOException i) {
			System.out.println(i);
		}

		// string to read message from input
		String line = "";

		// keep reading until "Over" is input
		while (!line.equals("OVER")) {
			try {
				line = input.readLine();
				line = line.toUpperCase();
				out.writeUTF(line);

				System.out.println(in.readUTF());

			} catch (IOException i) {
				System.out.println(i);
			}
		}

		// close the connection
		try {
			input.close();
			out.close();
			usuario.close();
		} catch (IOException i) {
			System.out.println(i);
		}
	}

	public Socket socket() {
		return this.usuario;
	}
}