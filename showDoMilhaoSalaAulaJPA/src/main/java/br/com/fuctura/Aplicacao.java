package br.com.fuctura;

import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.entidade.Alternativa;
import br.com.fuctura.entidade.Categoria;
import br.com.fuctura.entidade.Partida;
import br.com.fuctura.entidade.Questao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Aplicacao {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("FUCTURA-PU");

		EntityManager em = fabrica.createEntityManager();

		
		Alternativa a1 = new Alternativa();
		a1.setDescrica("Não orientado");
		a1.setVerdadeira(false);
		
		Alternativa a2 = new Alternativa();
		a2.setDescrica("É orientado");
		a2.setVerdadeira(true);
		
		
		
		Questao q1 = new Questao();
		q1.setEnunciado("Java é orientado a objetos?");
		q1.setValor(10.0);
		
		ArrayList<Alternativa> alternativas = new ArrayList<Alternativa>();
		alternativas.add(a1);
		alternativas.add(a2);
		
		
		q1.setAltenativas(alternativas);
		
		Categoria c1 = new Categoria();
		c1.setNome("Diversos");
		
		q1.setCategoria(c1);
		
		em.getTransaction().begin();
		em.persist(q1);
		em.getTransaction().commit();

		em.detach(q1);
		
		var consulta = em.find(Questao.class, 1);
		
		
		System.out.println(consulta.getEnunciado());
		System.out.println(consulta.getCategoria().getNome());
		
		for(Alternativa a : consulta.getAltenativas()) {
			System.out.println("Descricao: " + a.getDescrica());
		}
		
		fabrica.close();
		em.close();
	}

	public static void exibirResultado(List<Partida> resultado) {
		for (Partida minhaPartida : resultado) {
			System.out.println("Codigo: " + minhaPartida.getCodigo());
			System.out.println("Duracao: " + minhaPartida.getDuracao());
		}
	}

}
