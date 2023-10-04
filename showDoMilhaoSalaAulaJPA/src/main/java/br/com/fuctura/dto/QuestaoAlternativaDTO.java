package br.com.fuctura.dto;

public class QuestaoAlternativaDTO {
	private String enunciado;
	private String descricao;
	private boolean isVerdadeira;

	public QuestaoAlternativaDTO(String enunciado, String descricao, boolean isVerdadeira) {
		super();
		this.enunciado = enunciado;
		this.descricao = descricao;
		this.isVerdadeira = isVerdadeira;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isVerdadeira() {
		return isVerdadeira;
	}

	public void setVerdadeira(boolean isVerdadeira) {
		this.isVerdadeira = isVerdadeira;
	}

}
