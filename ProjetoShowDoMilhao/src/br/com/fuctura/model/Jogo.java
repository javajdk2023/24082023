package br.com.fuctura.model;

import java.util.List;

public class Jogo {
	private List<Questao> questoes;
	private double pontuacaoTotal;
	
	public List<Questao> getQuestoes() {
		return questoes;
	}
	
	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}
	
	public double getPontuacaoTotal() {
		return pontuacaoTotal;
	}
	
	public void setPontuacaoTotal(double pontuacaoTotal) {
		this.pontuacaoTotal = pontuacaoTotal;
	}
	
	public boolean avaliar(Alternativa alternativa, boolean resposta) {
		return alternativa.isVerdadeira() == resposta;
	}
}
