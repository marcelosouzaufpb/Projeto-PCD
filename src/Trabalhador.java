
public class Trabalhador extends Usuario {
	/*
	 * Trabalhador e uma classe que é do tipo usuario ele tem como atributo o nome e
	 * o trabalho que e a acao que ele realiza
	 */
	private String nome;
	private String trabalha;

	public Trabalhador(String nome, String trabalha) {
		super();
		this.nome = nome;
		this.trabalha = trabalha;
	}

	public String toString() {
		return "Trabalhador: " + nome + " Tipo de trabalho: " + this.trabalha;
	}
}
