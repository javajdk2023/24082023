package br.com.fuctura;

import br.com.fuctura.dto.AlternativaCategoriaDTO;
import br.com.fuctura.entidade.Questao;
import br.com.fuctura.repositorio.QuestaoRepositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JoinAplicacao {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("FUCTURA-PU");

		EntityManager em = fabrica.createEntityManager();

		QuestaoRepositorio questaoRepositorio = new QuestaoRepositorio();
		var questoesVerdadeiras = questaoRepositorio.findQuestaoByIsVerdadeira(em, true);
		//var dto = questaoRepositorio.findQuestaoAlternativaDTOByIsVerdadeira(em, true);
		//var eagerly = questaoRepositorio.findQuestaoByIsVerdadeiraLazy(em, true);
		var all = questaoRepositorio.findAll(em);
		
		for(Questao questao : questoesVerdadeiras) {
			System.out.println(questao.getCodigo());
		}
		
		for(AlternativaCategoriaDTO q : all) {
			System.out.println(q.getCategoria());
			System.out.println(q.getAlternativa());
		}
		
		fabrica.close();
		em.close();
	}
}
