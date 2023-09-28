package br.com.fuctura.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_alternativa")
public class Alternativa {
	@Id
	@GeneratedValue
	private int codigo;
	private String descrica;
	private boolean isVerdadeira;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescrica() {
		return descrica;
	}

	public void setDescrica(String descrica) {
		this.descrica = descrica;
	}

	public boolean isVerdadeira() {
		return isVerdadeira;
	}

	public void setVerdadeira(boolean isVerdadeira) {
		this.isVerdadeira = isVerdadeira;
	}
}
