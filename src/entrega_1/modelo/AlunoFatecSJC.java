package entrega_1.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

import entrega_1.util.DateUtil;

public class AlunoFatecSJC {
	private String nome;
	private Date dataNascimento;
	private String ra;
	public Integer faltas;
	public Integer presencas;
	
	public AlunoFatecSJC(String nome, Date dataNascimento, String ra) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.ra = ra;
		this.faltas = 0;
		this.presencas = 0;
	}
	
	public void removerPresencas(Integer qtd){
		this.presencas -= qtd;
		mostrarDados();
	}
	
	public void removerFaltas(Integer qtd){
		this.faltas -= qtd;
		mostrarDados();
	}
	
	
	public void mostrarDados(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		StringBuilder dados = new StringBuilder();
		dados.append("Nome:");
		dados.append(nome);
		dados.append("\n");
		dados.append("RA: ");
		dados.append(ra);
		dados.append("\nData nasicmento: ");
		dados.append(dateFormat.format(this.dataNascimento));
		dados.append("\nFaltas: ");
		dados.append(faltas);
		dados.append("\nPresencas: ");
		dados.append(presencas);
		System.out.println(dados.toString());
	}
	
	public void acrescentarPresencas(Integer qtd){
		this.presencas += qtd;
		mostrarDados();
	}
	
	public void acrescentarFaltas(Integer qtd){
		this.faltas += qtd;
		mostrarDados();
	}
	
	public String verIdade(){
		 Integer qtd = DateUtil.getDifferenceBetweenDates(new Date(), new Date(), DateUtil.YEARS);
		 return "O aluno " + nome + " possui " + qtd + " anos.";
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
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}

	public Integer getFaltas() {
		return faltas;
	}

	public void setFaltas(Integer faltas) {
		this.faltas = faltas;
	}
	
	public Integer getPresencas(){
		return this.presencas;
	}
	
	
}
