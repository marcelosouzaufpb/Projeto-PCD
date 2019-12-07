package Sistema;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.sun.glass.ui.View;

public class Usuario implements Runnable {

	private Socket usuario;
	private DataInputStream input = null;
	private DataOutputStream out = null;
	private DataInputStream in = null;
	private View view = null;

	public Usuario(Socket usuario) {
		this.usuario = usuario;
	}

	public static void main(String args[]) throws UnknownHostException, IOException {

		// para se conectar ao servidor, cria-se objeto Socket.
		// O primeiro parâmetro é o IP ou endereço da máquina que
		// se quer conectar e o segundo é a porta da aplicação.
		// Neste caso, usa-se o IP da máquina local (127.0.0.1)
		// e a porta da aplicação ServidorDeEco (12345).
		Socket socket = new Socket("127.0.0.1", 12345);

		/*
		 * Cria um novo objeto Cliente com a conexão socket para que seja executado em
		 * um novo processo. Permitindo assim a conexão de vário clientes com o
		 * servidor.
		 */
		Usuario c = new Usuario(socket);
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