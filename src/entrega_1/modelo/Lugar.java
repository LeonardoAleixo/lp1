package entrega_1.modelo;

public class Lugar {

	private String nome;
	private String pais;
	private Boolean ePaisagem;
	private String idioma;
	private Boolean podeNadar;

	public Lugar(String nome, String pais, Boolean ePaisagem, String idioma, Boolean podeNadar) {
		super();
		this.nome = nome;
		this.pais = pais;
		this.ePaisagem = ePaisagem;
		this.idioma = idioma;
		this.podeNadar = podeNadar;
	}

	public void nadar() {
		if (this.podeNadar) {
			System.out.println("Nadando, cuidado para não morrer afogado :)");
			return;
		}
		System.out.println("Você não pode nadar aqui!!!");
	}

	public void verPaisagem() {
		System.out.println("Nossa, que paisagem !!!");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Boolean getPaisagem() {
		return ePaisagem;
	}

	public void setePaisagem(Boolean ePaisagem) {
		this.ePaisagem = ePaisagem;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public Boolean getPodeNadar() {
		return podeNadar;
	}

	public void setPodeNadar(Boolean podeNadar) {
		this.podeNadar = podeNadar;
	}

}
