package Sistema;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Servidor extends Thread {
	public Socket usuario;
	private DataOutputStream out = null;
	private DataInputStream in = null;

	public Servidor(Socket usuario) {
		this.usuario = usuario;
	}

	public void run() {
		try {
			System.out.println("Porta 12345 aberta!");
			System.out.println("Aguardando conexao do cliente...");
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
						System.out.println("Nao existe esse tipo de usuario...");
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
 * } else { System.out.println("N�o existe esse tipo de usuario...");
 * out.writeUTF("ok"); }
 * 
 * } System.out.println("Closing connection");
 * 
 * // close connection cliente.close(); in.close(); } catch (IOException i) {
 * System.out.println(i); } }
 */