package br.com.fuctura;

import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Alternativa;
import br.com.fuctura.entidade.Questao;
import br.com.fuctura.repositorio.AlternativaRepositorio;
import br.com.fuctura.repositorio.QuestaoRepositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CicloVidaAplicacao {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("FUCTURA-PU");

		EntityManager em1 = fabrica.createEntityManager();
		
		EntityManager em2 = em1;

		AlternativaRepositorio repo = new AlternativaRepositorio();

		QuestaoRepositorio questaoRepo = new QuestaoRepositorio();
		
		Alternativa a = new Alternativa();
		a.setDescrica("Azul");
		a.setVerdadeira(true);
		
		repo.save(em1, a);
		
		Questao q = new Questao();
		q.setEnunciado("Qual a cor do céu?");
		
		List<Alternativa> alternativas = new ArrayList<Alternativa>();
		alternativas.add(a);
		
		q.setAltenativas(alternativas);
		
		questaoRepo.save(em1, q);
		
		//repo.save(em1, a);
		
		System.out.println("EM1 enxerga a alternativa?" + em1.contains(a));
		System.out.println("EM2 enxerga a alternativa?" + em2.contains(a));
		
		em1.detach(q);
		
		var q2 = em1.find(Questao.class, q.getCodigo());
		
		em1.getTransaction().begin();
		em1.remove(q2);
		em1.persist(q2);
		em1.getTransaction().commit();
		
		em1.close();
		em2.close();
		fabrica.close();
	}
}
