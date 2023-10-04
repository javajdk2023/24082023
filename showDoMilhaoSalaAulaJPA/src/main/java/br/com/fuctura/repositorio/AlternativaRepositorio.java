package br.com.fuctura.repositorio;

import java.util.List;

import br.com.fuctura.entidade.Alternativa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class AlternativaRepositorio {
	public List<Alternativa> findAllXML(EntityManager em) {
		TypedQuery<Alternativa> consultarPartidas = em
				.createNamedQuery("Alternativa.findAllXML", Alternativa.class);
		List<Alternativa> resultado = consultarPartidas.getResultList();
		return resultado;
	}
	
	public List<Alternativa> findByDescricao(EntityManager em, String descricao) {
		TypedQuery<Alternativa> consultarPartidas = em
				.createNamedQuery("Alternativa.findByDescricao", Alternativa.class);
		
		consultarPartidas.setParameter("descrica", descricao);
		
		List<Alternativa> resultado = consultarPartidas.getResultList();
		return resultado;
	}
	
	public void save(EntityManager em, Alternativa alternativa) {
		em.getTransaction().begin();
		em.persist(alternativa);
		em.getTransaction().commit();
	}
}
