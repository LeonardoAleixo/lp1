package entrega_1.modelo;

import java.util.Calendar;
import java.util.Date;

import entrega_1.util.DateUtil;

public class Pessoa {

	private String nome;
	private Date dataNascimento;
	private Double altura;
	private String rg;
	private Boolean doouSangue;
	private Date ultimaDoacao;
	private Integer qtdFilho;

	public void doarSangue() {
		Calendar c = Calendar.getInstance();
		c.setTime(ultimaDoacao);
		Integer meses = DateUtil.getDifferenceBetweenDates(ultimaDoacao, new Date(), DateUtil.MONTHS);
		if (meses <= 3) {
			System.out.println("Você ainda não pode doar sangue!");
			return;
		}
		this.doouSangue = true;
		this.ultimaDoacao = new Date();
		System.out.println("Parabens, você doou sangue!");
	}

	public void terFilhos(Integer qtd) {
		this.qtdFilho += qtd;
		if (this.qtdFilho > 3) {
			System.out.println("Parabens você ganhou uma tv");
			System.out.println("Você tem uma ninhada :)");
		}
	}

	public Pessoa(String nome, Date dataNascimento, Double altura, String rg, Boolean doouSangue, Date ultimaDoacao) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.altura = altura;
		this.rg = rg;
		this.doouSangue = doouSangue;
		this.ultimaDoacao = ultimaDoacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Boolean getDoouSangue() {
		return doouSangue;
	}

	public void setDoouSangue(Boolean doouSangue) {
		this.doouSangue = doouSangue;
	}

	public Date getUltimaDoacao() {
		return ultimaDoacao;
	}

	public void setUltimaDoacao(Date ultimaDoacao) {
		this.ultimaDoacao = ultimaDoacao;
	}

	public Integer getQtdFilho() {
		return qtdFilho;
	}

	public void setQtdFilho(Integer qtdFilho) {
		this.qtdFilho = qtdFilho;
	}

}
