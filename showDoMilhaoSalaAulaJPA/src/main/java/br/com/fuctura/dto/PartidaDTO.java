package br.com.fuctura.dto;

//DTO => Data Transfer Object
public class PartidaDTO {
	private int duracao;
	private int pontuacao;

	//construtor
	public PartidaDTO(int duracao, int pontuacao) {
		this.duracao = duracao;
		this.pontuacao = pontuacao;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	//getters e setter
	
	
}
