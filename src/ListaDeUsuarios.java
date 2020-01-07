
public class ListaDeUsuarios extends Online {
	private String[] usuarios;

	public ListaDeUsuarios(String[] usuarios) {
		super();
		this.usuarios = usuarios;
	}

	public String[] getUsuarios() {
		return usuarios;
	}

	@Override
	public String toString() {
		String string = "";
		for (String s : usuarios) {
			string += s + ",";
		}
		return "Usuarios online: " + string;
	}

}
