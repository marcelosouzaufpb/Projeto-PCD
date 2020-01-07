
public class Usuario extends Online {
	private String tipoDeUsuario;
	private String tipoDeAcao;

	public Usuario(String usuario, String acao) {
		super();
		this.tipoDeUsuario = usuario;
		this.tipoDeAcao = acao;
	}

	@Override
	public String toString() {
		return tipoDeUsuario + ": " + tipoDeAcao;
	}
}