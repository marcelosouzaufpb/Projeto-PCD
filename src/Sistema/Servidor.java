package Sistema;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javafx.concurrent.Worker;

public class Servidor implements Runnable {
	public Socket usuario;
	private DataOutputStream out = null;
	private DataInputStream in = null;
	private static int cont = 0;

	public Servidor(Socket usuario) {
		this.usuario = usuario;
	}

	public static void main(String[] args) throws IOException {

		// Cria um socket na porta 12345
		ServerSocket servidor = new ServerSocket(12345);
		System.out.println("Porta 12345 aberta!");

		// Aguarda alguém se conectar. A execução do servidor
		// fica bloqueada na chamada do método accept da classe
		// ServerSocket. Quando alguém se conectar ao servidor, o
		// método desbloqueia e retorna com um objeto da classe
		// Socket, que é uma porta da comunicação.
		System.out.println("Aguardando conexão do cliente...");

		while (true) {
			Socket usuario = servidor.accept();
			// Cria uma thread do servidor para tratar a conexão
			Servidor tratamento = new Servidor(usuario);
			Thread t = new Thread(tratamento);
			// Inicia a thread para o cliente conectado
			t.start();
			cont++;
			System.out.println(cont);
		}
	}

	/*
	 * A classe Thread, que foi instancia no servidor, implementa Runnable. Então
	 * você terá que implementar sua lógica de troca de mensagens dentro deste
	 * método 'run'.
	 */
	public void run() {
		try {
			out = new DataOutputStream(usuario.getOutputStream());
			in = new DataInputStream(new BufferedInputStream(usuario.getInputStream()));
			String line = "";

			// reads message from client until "Over" is sent
			while (!line.equals("OVER")) {
				try {
					line = in.readUTF();
					if (line.equals("BTN90")) {
						System.out.println("ADD TRAB 90");
						out.writeUTF("ok");

					} else if (line.equals("btn180")) {
						System.out.println("ADD TRAB 180");

					} else if (line.equals("btnSIMPLES")) {
						System.out.println("ADD TRAB SIMPLES");

					} else if (line.equals("BTNCLIENTE")) {
						System.out.println("Cliente add...");
					} else {
						System.out.println("Não existe esse tipo de usuario...");
						out.writeUTF("nao");
					}

				}

				catch (IOException i) {
					System.out.println(i);
				}
			}
			System.out.println("Closing connection");

		} catch (

		IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// close connection
		try {
			usuario.close();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

/*
 * try { in = new DataInputStream(new
 * BufferedInputStream(cliente.getInputStream())); out = new
 * DataOutputStream(cliente.getOutputStream()); String line = "";
 * 
 * // reads message from client until "Over" is sent while
 * (!line.equals("OVER")) {
 * 
 * line = in.readUTF(); if (line.equals("BTN90")) {
 * System.out.println("ADD TRAB 90"); out.writeUTF("ok");
 * 
 * } else if (line.equals("btn180")) { System.out.println("ADD TRAB 180");
 * 
 * } else if (line.equals("btnSIMPLES")) {
 * System.out.println("ADD TRAB SIMPLES");
 * 
 * } else if (line.equals("BTNCLIENTE")) { System.out.println("Cliente add...");
 * } else { System.out.println("Não existe esse tipo de usuario...");
 * out.writeUTF("ok"); }
 * 
 * } System.out.println("Closing connection");
 * 
 * // close connection cliente.close(); in.close(); } catch (IOException i) {
 * System.out.println(i); } }
 */
