package br.com.fuctura;

import br.com.fuctura.entidade.Alternativa;
import br.com.fuctura.entidade.Questao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AplicacaoConsulta {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("FUCTURA-PU");

		EntityManager em = fabrica.createEntityManager();
		
		var consulta = em.find(Questao.class, 1);

		for (Alternativa a : consulta.getAltenativas()) {
			System.out.println("Descricao: " + a.getDescrica());
		}

		fabrica.close();
		em.close();
	}
}
