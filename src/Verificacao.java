import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Verificacao extends Thread {
	/*
	 * Verificacao e a classe Tread da aplicacao ela tem como paramentro o canal o
	 * nome do usuarios e ela se comunica com a classe controle que controla as
	 * entradas e saidas dos usuarios.
	 */

	private Controle usuariosOnline;
	private ObjectOutputStream saida;
	private ObjectInputStream entrada;
	private String nomeUsuario;
	private Socket canal;

	// Esse construtor tem como finalidade garantir que sempre tenha um canal aberto
	// para a entrada do usuarios
	public Verificacao(Socket canal, Controle usuario) {
		this.usuariosOnline = usuario;
		this.canal = canal;
		conectarUsuario(canal, usuario);
	}

	// Como proprio nome ja fala essa classe conecta um usuario ao servidor
	private void conectarUsuario(Socket canal, Controle usuario) {
		try {
			this.entrada = new ObjectInputStream(canal.getInputStream());
			this.saida = new ObjectOutputStream(canal.getOutputStream());
			this.nomeUsuario = (String) entrada.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Classe run vai inicialiazar toda a aplicacao
	public void run() {
		try {
			while (true) {
				Usuario usuario = (Usuario) entrada.readObject();
				System.out.println(usuario);
				usuariosOnline.comunicacaoUsuarios(usuario);
				System.out.print("Usuario: " + usuario + " estar conectado!");
			}
		} catch (IOException e) {
			usuariosOnline.removeUsuarioOnline(nomeUsuario);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				canal.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}