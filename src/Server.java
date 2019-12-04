
// A Java program for a Server 
import java.net.*;
import java.io.*;

public class Server {
	// initialize socket and input stream
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream in = null;

	// constructor with port
	public Server(int port) {
		// starts server and waits for a connection
		try {
			server = new ServerSocket(port);
			System.out.println("Server started");

			System.out.println("Waiting for a client ...");

			socket = server.accept();
			System.out.println("Client accepted");

			// takes input from the client socket
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

             
			String line = "";
			

			// reads message from client until "Over" is sent
			while (!line.equals("OVER")) {
				try {
					line = in.readUTF();

					System.out.println(line);
					if (line.equals("BTN90")) {
						System.out.println("ADD TRAB 90");
						
					} else if (line.equals("btn180")) {
						System.out.println("ADD TRAB 180");

					} else if (line.equals("btnSIMPLES")) {
						System.out.println("ADD TRAB SIMPLES");
						
					} else if (line.equals("BTNCLIENTE")) {
						System.out.println("Cliente add...");
					} else {
						System.out.println("Não existe esse tipo de usuario...");
					}

				} catch (IOException i) {
					System.out.println(i);
				}
			}
			System.out.println("Closing connection");

			// close connection
			socket.close();
			in.close();
		} catch (IOException i) {
			System.out.println(i);
		}
	}

	public static void main(String args[]) {
		Server server = new Server(12345);
	}
}