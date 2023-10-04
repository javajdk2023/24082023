package br.com.fuctura.dto;

import br.com.fuctura.entidade.Alternativa;
import br.com.fuctura.entidade.Categoria;

public class AlternativaCategoriaDTO {
	private Alternativa alternativa;
	private Categoria categoria;
	public AlternativaCategoriaDTO(Alternativa alternativa, Categoria categoria) {
		super();
		this.alternativa = alternativa;
		this.categoria = categoria;
	}
	public Alternativa getAlternativa() {
		return alternativa;
	}
	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
