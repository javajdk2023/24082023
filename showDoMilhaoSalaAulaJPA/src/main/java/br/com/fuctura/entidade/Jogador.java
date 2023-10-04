package br.com.fuctura.entidade;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_jogador", schema = "public")
public class Jogador {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogador-seq")
	@SequenceGenerator(name = "jogador-seq", allocationSize = 1)
	private int codigo;

	@Column(name = "aluno_nome", length = 20, nullable = false)
	private String nome;

	// getter e setter

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
