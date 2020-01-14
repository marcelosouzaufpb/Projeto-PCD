
public class Cliente extends Usuario {
	/*
	 * Cliente e uma classe que é do tipo usuario ele tem como atributo o nome e
	 * a pesquisa que e a acao que ele realiza
	 */
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
