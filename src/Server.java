import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket serverSocket;

	private void criarServerSocket(int porta) throws IOException {
		this.serverSocket = new ServerSocket(porta);
	}

	private Socket esperaConexao() throws IOException {
		Socket socket = serverSocket.accept();
		return socket;
	}

	private void tratarConexao(Socket socket) {
		/*
		 * Protocolo da aplicação
		 */
		try {
			/* 3 - Criar streams de entrada e saida; */

			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

			/*
			 * Protocolo Cliente --> Hello Serve <--- Hello World
			 * 
			 * 4 - Tratar a conversção entre cliente e servidor
			 */

			String msg = input.readUTF();
			System.out.println("Mensagem recebida...");
			output.writeUTF("HELLO WORLD!");

			// 4.2 - Fechar streams de entrada e saida
			input.close();
			output.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			/* 4.1 - Fechar soket de comunicação entre cliente/servidor */
			fecharSocket(socket);
		}
	}

	private void fecharSocket(Socket s) {
		try {
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		try {
			System.out.print("Aguarddando conexao...");
			server.criarServerSocket(5555);
			System.out.print("Cliente conectado...");
			Socket socket = server.esperaConexao();
			server.tratarConexao(socket);
			System.out.print("Cliente finalizado...");
			// Protocolo de gerenciamneto de comunicação
		} catch (IOException e) {
			e.printStackTrace();
			// Tratar exeção
		}

	}
}