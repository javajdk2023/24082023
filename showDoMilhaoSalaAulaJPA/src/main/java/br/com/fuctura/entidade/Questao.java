package br.com.fuctura.entidade;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_questao")
public class Questao {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questao-seq")
	@SequenceGenerator(name = "questao-seq", allocationSize = 1)	private int codigo;
	private String enunciado;
	private double valor;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_questao")
	List<Alternativa> altenativas;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Categoria categoria;
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Alternativa> getAltenativas() {
		return altenativas;
	}

	public void setAltenativas(List<Alternativa> altenativas) {
		this.altenativas = altenativas;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

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

	@Override
	public String toString() {
		return "Questao [codigo=" + codigo + ", enunciado=" + enunciado + ", valor=" + valor + ", altenativas="
				+ altenativas + ", categoria=" + categoria + "]";
	}
}
