package br.com.fuctura.eric;

import br.com.fuctura.kevyn.Quadrado;

public class Aplicacao {

	public static void main(String[] args) {
		
		// utilizar uma classe com mesmo nome utilizando
		// especificar o caminho completo da classe
		var retAdalberto = new br.com.fuctura.Adalberto.Retangulo(2.0,9.0); 
		var retEric = new br.com.fuctura.eric.Retangulo(2.0,9.0);
		
		// informando através do import
		var retkevyn = new Retangulo(2.0,9.0); 
		
		System.out.println(retkevyn.calcularArea());
		System.out.println(retEric.calcularArea());
		System.out.println(retAdalberto.CalcularArea());
	}

}
