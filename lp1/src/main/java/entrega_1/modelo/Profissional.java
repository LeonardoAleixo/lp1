package entrega_1.modelo;

public class Profissional {
	private String cargo;
	private Double salario;
	private String area;
	private Boolean fezRelatorio;
	
	public Profissional(String cargo, Double salario, String area){
		this.cargo = cargo;
		this.salario = salario;
		this.area = area;
	}

	public void fazerRelatorio() {
		System.out.println("Relatório completo, você deve entregar para seu chefe");
		fezRelatorio = true;
	}

	public void entregarParaOChefe() {
		this.fezRelatorio = false;
		System.out.println("Bom relatório!!");
	}

	public void gastarDinheiro(Double valor) {
		this.salario -= valor;
		if (salario < 100) {
			System.out.println("calma lá, tem conta pra pagar!!");
		}
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Boolean getFezRelatorio() {
		return fezRelatorio;
	}

	public void setFezRelatorio(Boolean fezRelatorio) {
		this.fezRelatorio = fezRelatorio;
	}

}
