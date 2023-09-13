package br.com.fuctura.model;

public class Alternativa {
	private String descricao;
	private boolean isVerdadeira;
	
	public Alternativa(String descricao, boolean isVerdadeira) {
		this.descricao = descricao;
		this.isVerdadeira = isVerdadeira;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public boolean isVerdadeira() {
		return isVerdadeira;
	}
	
}
