import java.util.ArrayList;

public class Online extends Usuario {
	private String[] listaDeUsuariosOnline;

	public Online(String[] usuarios) {
		super();
		this.listaDeUsuariosOnline = usuarios;
	}

	public String[] getUsuarios() {
		return this.listaDeUsuariosOnline;
	}

	public String toString() {
		String string = "";
		for (String s : this.listaDeUsuariosOnline) {
			string += s + ",";
		}
		return "Usuarios online: " + string;
	}
}
