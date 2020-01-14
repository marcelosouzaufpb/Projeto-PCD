
public class Cliente extends Usuario {
	private String nome;
	private String pesquisa;

	public Cliente(String nome, String pesquisa) {
		super();
		this.nome = nome;
		this.pesquisa = pesquisa;
	}

	public String toString() {
		return "Cliente: " + nome + " Tipo de pesquia: " + this.pesquisa;
	}
}
