package br.com.fuctura.repositorio;

import java.util.List;

import br.com.fuctura.dto.PartidaDTO;
import br.com.fuctura.entidade.Partida;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class PartidaRepositorio {
	
	public void save(EntityManager em, Partida partida) {
		em.getTransaction().begin();
		em.persist(partida);
		em.getTransaction().commit();
	}
	
	public void delete(EntityManager em, Partida partida) {
		em.getTransaction().begin();
		em.remove(partida);
		em.getTransaction().commit();
	}
	
	public Partida findById(EntityManager em, int id) {
		return em.find(Partida.class, id);
	}
	
	public List<Partida> findAll(EntityManager em) {
		String findAllJPQL = "SELECT p FROM Partida p";
		TypedQuery<Partida> consultarPartidas = em.createQuery(findAllJPQL, Partida.class);

		List<Partida> resultado = consultarPartidas.getResultList();

		return resultado;
	}

	public List<Partida> findAllXML(EntityManager em) {
		// findAll => select * from tb_jogador tj;
		TypedQuery<Partida> consultarPartidas = em.createNamedQuery("Alternativa.findAllXML", Partida.class);

		List<Partida> resultado = consultarPartidas.getResultList();

		return resultado;
	}
	
	public List<Partida> findByDuracao(EntityManager em, int duracao) {
		// findByDuracao => select * from tb_partida where duracao = ?;
		 String findByDuracaoJPQL = "SELECT p FROM Partida p where p.duracao = :duracao";
		TypedQuery<Partida> partidasPorDuracao = em.createQuery(findByDuracaoJPQL, Partida.class);

		partidasPorDuracao.setParameter("duracao", duracao);

		List<Partida> resultadoPorDuracao = partidasPorDuracao.getResultList();
		
		return resultadoPorDuracao;
	}
	
	public List<Integer> findByPontuacao(EntityManager em, int pontuacao) {
		String findByDuracaoJPQL = "SELECT p.pontuacao FROM Partida p where p.pontuacao = :pontuacao";
		TypedQuery<Integer> partidasPorDuracao = em.createQuery(findByDuracaoJPQL, Integer.class);

		partidasPorDuracao.setParameter("pontuacao", pontuacao);

		List<Integer> resultadoPorDuracao = partidasPorDuracao.getResultList();
		
		return resultadoPorDuracao;
	}
	
	public List<PartidaDTO> findPartidaDTOByPontuacao(EntityManager em, int pontuacao) {
		String findByDuracaoJPQL = "SELECT "
				+ "new br.com.fuctura.dto.PartidaDTO(p.duracao, p.pontuacao) "
				+ "FROM Partida p where p.pontuacao = :pontuacao";
		
		TypedQuery<PartidaDTO> partidasPorDuracao = em.createQuery(findByDuracaoJPQL, PartidaDTO.class);

		partidasPorDuracao.setParameter("pontuacao", pontuacao);

		List<PartidaDTO> resultadoPorDuracao = partidasPorDuracao.getResultList();
		
		return resultadoPorDuracao;
	}
	
}
