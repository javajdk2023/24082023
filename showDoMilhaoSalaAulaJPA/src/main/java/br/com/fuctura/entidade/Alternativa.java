package br.com.fuctura.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@NamedQueries({
		@NamedQuery(name = "Alternativa.findAllXML2", 
				query = "SELECT a FROM Alternativa a"),
		@NamedQuery(name = "Alternativa.findByDescricao",
				query = "SELECT a FROM Alternativa a WHERE descrica = :descrica"	
				)
		

})
@Entity
@Table(name = "tb_alternativa")
public class Alternativa {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alternativa-seq")
	@SequenceGenerator(name = "alternativa-seq", allocationSize = 1)
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

	@Override
	public String toString() {
		return "Alternativa [codigo=" + codigo + ", descrica=" + descrica + ", isVerdadeira=" + isVerdadeira + "]";
	}
}
