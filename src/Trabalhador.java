
public class Trabalhador extends Usuario {
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
