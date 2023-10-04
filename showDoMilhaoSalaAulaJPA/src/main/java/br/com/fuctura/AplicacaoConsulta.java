package br.com.fuctura;

import br.com.fuctura.entidade.Alternativa;
import br.com.fuctura.repositorio.AlternativaRepositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AplicacaoConsulta {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("FUCTURA-PU");

		EntityManager em = fabrica.createEntityManager();

		AlternativaRepositorio repo = new AlternativaRepositorio();

		var resultado = repo.findAllXML(em);

		for (Alternativa a : resultado) {
			System.out.println(a.getCodigo());
		}
		
		
		var byDescricao = repo.findByDescricao(em, "É orientado");
		
		for (Alternativa a : byDescricao) {
			System.out.println(a.getCodigo());
		}
		
		fabrica.close();
		em.close();
	}
}
