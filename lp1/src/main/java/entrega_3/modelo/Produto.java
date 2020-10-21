package entrega_3.modelo;

public class Produto {
	private String nome;
	private Double valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Produto(String nome, Double valor) {
		this.nome = nome;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return this.nome;
	}

}
