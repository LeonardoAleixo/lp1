package entrega_1.modelo;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import entrega_1.util.DateUtil;
import entrega_2.constantes.Constante;
import junit.framework.Assert;

public class Pessoa {

	private String nome;
	private Date dataNascimento;
	private Double altura;
	private String rg;
	private Boolean doouSangue;
	private Date ultimaDoacao;
	private Integer qtdFilho;

	public String doarSangue() {
		Calendar c = null;
		if (ultimaDoacao != null) {
			c = Calendar.getInstance();
			c.setTime(ultimaDoacao);
			Integer meses = DateUtil.getDifferenceBetweenDates(ultimaDoacao, new Date(), DateUtil.MONTHS);
			if (meses <= 3) {
				return "Voc� ainda n�o pode doar sangue!";
				
			}
		}
		this.doouSangue = true;
		this.ultimaDoacao = new Date();
		return "Parabens, voc� doou sangue!";
	}

	public void aumentarFilho(Integer qtd) {
		if (qtdFilho == null){
			this.qtdFilho = qtd;
		}
		this.qtdFilho += qtd;
	}
	
	public  String mostrarInformacoes(SimpleDateFormat dMA){
		StringBuilder informacoes = new StringBuilder("");
		informacoes.append("<html>Nome: ");
		Assert.assertNotNull(this.getNome());
		informacoes.append(this.getNome());
		informacoes.append("<br>Data de nascimento: ");
		Assert.assertNotNull(this.getDataNascimento());
		informacoes.append(dMA.format(this.getDataNascimento()));
		informacoes.append("<br>Altura: ");
		Assert.assertNotNull(this.getAltura());
		informacoes.append(this.getAltura().toString());
		informacoes.append("<br>RG: ");
		Assert.assertNotNull(this.getRg());
		informacoes.append(this.getRg());
		informacoes.append("<br>Doou sangue: ");
		Assert.assertNotNull(this.getDoouSangue());
		informacoes.append(this.getDoouSangue() ? "Sim" : "N�o");
		informacoes.append("<br>Última doação: ");
		Assert.assertNotNull(this.getUltimaDoacao());
		informacoes.append(this.getUltimaDoacao() != null ? dMA.format(this.getUltimaDoacao()) : "N�o informado");
		informacoes.append("<br>Qtd. Filhos: ");
		Assert.assertNotNull(this.getQtdFilho());
		informacoes.append(this.getQtdFilho().toString());
		informacoes.append("<br>");
		informacoes.append(this.getQtdFilho() >= 5  ? "Voc� ganhou um presente" : "");
		informacoes.append("</html>");
		return informacoes.toString();
		
	}

	public Pessoa(String nome, Date dataNascimento, Double altura, String rg, Boolean doouSangue, Date ultimaDoacao) {
		super();
		this.nome = nome;	
		this.dataNascimento = dataNascimento;
		this.altura = altura;
		this.rg = rg;
		this.doouSangue = doouSangue;
		this.ultimaDoacao = ultimaDoacao;
		this.qtdFilho = 0;
	}
	
	public File getImagePresente(){
		return new File(Constante.URI_PRESENTE);
	}
	
	public File getImageTv(){
		return new File(Constante.URI_TV);
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
