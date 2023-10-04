package br.com.fuctura.repositorio;

import java.util.List;

import br.com.fuctura.dto.AlternativaCategoriaDTO;
import br.com.fuctura.entidade.Questao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class QuestaoRepositorio {
	public List<AlternativaCategoriaDTO> findAll(EntityManager em) {
		String findAllJPQL = "SELECT new br.com.fuctura.dto.AlternativaCategoriaDTO(q.altenativas, q.categoria) FROM Questao q";
		TypedQuery<AlternativaCategoriaDTO> consultarPartidas = em.createQuery(findAllJPQL, AlternativaCategoriaDTO.class);

		List<AlternativaCategoriaDTO> resultado = consultarPartidas.getResultList();

		return resultado;
	}
	
	public List<Questao> findQuestaoByIsVerdadeira(EntityManager em, boolean isVerdadeira) {
		String findAllJPQL = "SELECT alt FROM Questao q JOIN q.altenativas alt WHERE alt.isVerdadeira = :isVerdadeira";
		TypedQuery<Questao> consultarPartidas = em.createQuery(findAllJPQL, Questao.class);

		consultarPartidas.setParameter("isVerdadeira", isVerdadeira);
		
		List<Questao> resultado = consultarPartidas.getResultList();

		return resultado;
	}
	
	public List<Questao> findQuestaoAlternativaDTOByIsVerdadeira(EntityManager em, boolean isVerdadeira) {
		String findAllJPQL = "SELECT new br.com.fuctura.dto.QuestaoAlternativaDTO(q.enunciado, alt.descrica, alt.isVerdadeira) FROM Questao q JOIN q.altenativas alt WHERE alt.isVerdadeira = :isVerdadeira";
		TypedQuery<Questao> consultarPartidas = em.createQuery(findAllJPQL, Questao.class);

		consultarPartidas.setParameter("isVerdadeira", isVerdadeira);
		
		List<Questao> resultado = consultarPartidas.getResultList();

		return resultado;
	}
	
	public List<Questao> findQuestaoByIsVerdadeiraLazy(EntityManager em, boolean isVerdadeira) {
		//eagerly loaded
		String findAllJPQL = "SELECT q FROM Questao q JOIN FETCH q.altenativas";
		TypedQuery<Questao> consultarPartidas = em.createQuery(findAllJPQL, Questao.class);
		List<Questao> resultado = consultarPartidas.getResultList();
		return resultado;
	}
	
	public void save(EntityManager em, Questao questao) {
		em.getTransaction().begin();
		em.persist(questao);
		em.getTransaction().commit();
	}
}
