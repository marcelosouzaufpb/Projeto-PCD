import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Verificacao extends Thread {
	private Controle usuariosOnline;
	private ObjectOutputStream saida;
	private ObjectInputStream entrada;
	private String nomeUsuario;
	private Socket canal;

	public Verificacao(Socket canal, Controle usuario) {
		this.usuariosOnline = usuario;
		this.canal = canal;
		conectarCliente(canal, usuario);
	}

	private void conectarCliente(Socket canal, Controle usuario) {
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