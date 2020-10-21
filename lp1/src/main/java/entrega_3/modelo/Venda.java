package entrega_3.modelo;

public class Venda {
	private Produto produto;
	private String cliente;

	public Venda(Produto produto, String cliente) {
		this.produto = produto;
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

}
