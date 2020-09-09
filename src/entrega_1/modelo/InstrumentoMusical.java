package entrega_1.modelo;

import java.util.concurrent.ThreadLocalRandom;

public class InstrumentoMusical {
	private String nome;
	private String marca;
	private String modelo;
	private Boolean afinado;
	private Boolean tocando;
	private Boolean possuiCordas; 
	
	public void afinar(){
		this.afinado = true;
		int v =(int) (ThreadLocalRandom.current().nextInt(1, 3));
		if (v % 2 == 0){
			System.out.println("Opa estourou uma corda :(");
			this.afinado = false;
			return;
		}
		this.afinado = true;
		System.out.println("Seu instrumento está ok!");
	}
	
	public void adicionarCordas(){
		this.possuiCordas = true;
	}
	
	public void tocar(){
		if (tocando){
			System.out.println("Você já está tocando!");
		}
		if (!this.afinado){
			System.out.println("Seu instrumento está desafinado :(");
			return;
		}
		this.tocando = true;
		System.out.println("Estamos ouvindo um belo som");
	}
	
	public InstrumentoMusical(String nome, String marca, String modelo, Boolean possuiCordas) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.modelo = modelo;
		this.tocando = false;
		this.afinado = false;
		this.possuiCordas = possuiCordas;
	}
	
	public Boolean getAfinado() {
		return afinado;
	}


	public Boolean getTocando() {
		return tocando;
	}


	public Boolean getPossuiCordas() {
		return possuiCordas;
	}


	public String getNome() {
		return nome;
	}
	
	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}
		
}
