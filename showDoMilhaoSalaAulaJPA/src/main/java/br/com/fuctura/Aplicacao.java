package br.com.fuctura;

import br.com.fuctura.entidade.Jogador;
import br.com.fuctura.entidade.Partida;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Aplicacao {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("FUCTURA-H2");

		EntityManager em = fabrica.createEntityManager();

		Jogador j1 = new Jogador();
		j1.setNome("Caio");

		Partida p1 = new Partida();
		p1.setDuracao(123);
		p1.setPontuacao(0);

		em.getTransaction().begin();
		em.persist(j1);
		em.persist(p1);
		em.getTransaction().commit();

		var resultadoConsulta = em.find(Partida.class, 1);

		System.out.println("ID:" + resultadoConsulta);
	}

}
