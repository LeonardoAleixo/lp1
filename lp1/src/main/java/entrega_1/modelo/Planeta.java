package entrega_1.modelo;

public class Planeta {
	private String nome;
	Boolean habitavel;
	Integer qtdLua;
	Integer temperatura;
	
	public String viajarPara(){
		StringBuilder builder = new StringBuilder();
		builder.append("Você chegou ao planeta ");
		builder.append(this.nome);
		if (this.habitavel){
			builder.append(" Ufa ele possui zona habitavel");
			
		}else if (temperatura < 0){
			builder.append(" Este planeta é muito frio, não vamos durar muito");
		}else if (temperatura > 56){
			builder.append(" Mas que planeta quente, vamos derreter, vamos embora");
		}
		return builder.toString();
	}
	
	public String quantasLuasPossui(){
		return this.qtdLua.toString();
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
}
