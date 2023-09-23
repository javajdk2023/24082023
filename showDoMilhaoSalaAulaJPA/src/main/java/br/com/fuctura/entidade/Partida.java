package br.com.fuctura.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_partida", schema = "public")
public class Partida {
	@Id
	@GeneratedValue
	private int codigo;

	@Column(nullable = true)
	private int pontuacao;

	@Column(nullable = true)
	private int duracao;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	@Override
	public String toString() {
		return "Partida [codigo=" + codigo + ", pontuacao=" + pontuacao + ", duracao=" + duracao + "]";
	}
}
