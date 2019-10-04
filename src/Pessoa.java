public class Pessoa {

	private String nome;
	private Integer idade;

	public Pessoa(String nome, Integer idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public Integer getIdade() {
		return this.idade;
	}

	public String getNome() {
		return this.nome;
	}

}
