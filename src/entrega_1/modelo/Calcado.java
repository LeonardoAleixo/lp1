package entrega_1.modelo;

public class Calcado {
	private Integer numero;
	private String fabricante;
	private String cor;
	private String modelo;
	private Boolean amarrado;
	private Boolean aberto;
	private Character genero;
	private Boolean limpo;
	private Boolean mataBarata;

	public void mostrarDados() {
		StringBuilder dados = new StringBuilder();
		dados.append("Número: ");
		dados.append(numero);
		dados.append("\nFabricante: ");
		dados.append(fabricante);
		dados.append("\nCor: ");
		dados.append(cor);
		dados.append("\nModelo: ");
		dados.append(modelo);
		dados.append("\nGênero: ");
		dados.append(genero == 'M' ? "Masculino" : "Feminino");
		dados.append("\nEstá amarrado: ");
		dados.append(amarrado ? " Sim " : "Não");
		dados.append("\nAberto?");
		dados.append(aberto ? "Aberto" : "Fechado");
		dados.append("Está amarrado?");
		dados.append(amarrado ? "Sim" : "Não");
		System.out.println(dados.toString());
	}

	public void mostrarLimpo() {
		if (this.limpo) {
			System.out.println("Agora seu calçado está sujo");
		} else {
			System.out.println("Agora seu calçado está limpo");
		}
	}

	public void matarBarata() {
		if (mataBarata) {
			System.out.println("Barata morta");
			this.limpo = false;
		} else {
			System.out.println("Seu calçado não pode matar baratas :(");
		}
		mostrarLimpo();
	}

	public void lavar() {
		this.limpo = true;
		mostrarLimpo();
	}

	public Calcado(Integer numero, String fabricante, String cor, String modelo, Boolean aberto, Boolean mataBarata) {
		super();
		this.numero = numero;
		this.fabricante = fabricante;
		this.cor = cor;
		this.modelo = modelo;
		this.amarrado = true;
		this.aberto = aberto;
		this.mataBarata = mataBarata;
		this.limpo = true;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Boolean getAberto() {
		return aberto;
	}

	public void setAberto(Boolean aberto) {
		this.aberto = aberto;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Boolean getAmarrado() {
		return amarrado;
	}

	public void setAmarrado(Boolean amarrado) {
		this.amarrado = amarrado;
	}

	public Boolean getLimpo() {
		return limpo;
	}

	public void setLimpo(Boolean limpo) {
		this.limpo = limpo;
	}

	public Boolean getMataBarata() {
		return mataBarata;
	}

	public void setMataBarata(Boolean mataBarata) {
		this.mataBarata = mataBarata;
	}

	public void alterarAmarracao() {
		this.amarrado = !this.amarrado;
		mostrarDados();
	}

	public Character getGenero() {
		return genero;
	}

	public void setGenero(Character genero) {
		this.genero = genero;
	}

}
