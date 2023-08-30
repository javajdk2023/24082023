package br.com.fuctura.eric;

public class Quadrado {
	
	private double lado;

	public Quadrado(double lado) {
		this.lado = lado;
	}

	public double getLado() {
		return lado;
	}

	//construtor
	
	
	//getters setters
	
	//comportamento
	public double calcularArea(){
		return lado * lado;
	}
	
}
