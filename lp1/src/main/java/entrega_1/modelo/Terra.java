package entrega_1.modelo;

public class Terra extends Planeta{
	public Terra() {
		super.habitavel = true;
		setNome("Terra");
		super.qtdLua = 1;
		super.temperatura = 25;
	}
}
