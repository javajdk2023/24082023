package br.com.fuctura.model;

import java.util.List;

public class Questao {
	private String enunciado;
	private double valor;
	private List<Alternativa> alternativas;
	
	public String getEnunciado() {
		return enunciado;
	}
	
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public List<Alternativa> getAlternativas() {
		return alternativas;
	}
	
	public void setAlternativas(List<Alternativa> alternativas) {
		this.alternativas = alternativas;
	}
}
