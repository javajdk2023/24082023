package br.com.fuctura;

import java.util.List;

import br.com.fuctura.entidade.Jogador;
import br.com.fuctura.entidade.Partida;
import br.com.fuctura.repositorio.PartidaRepositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Aplicacao {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("FUCTURA-PU");

		EntityManager em = fabrica.createEntityManager();

		// vou buscar do repositorio
		PartidaRepositorio repo = new PartidaRepositorio();

		Jogador j1 = new Jogador();
		j1.setNome("Caio");

		Partida p1 = new Partida();
		p1.setDuracao(123);
		p1.setPontuacao(0);

		repo.save(em, p1);
		
		var resultadoConsulta = repo.findById(em, 1);
		System.out.println("ID:" + resultadoConsulta);

		List<Partida> resultado = repo.findAll(em);
		exibirResultado(resultado);

		resultado = repo.findByDuracao(em, 20);
		exibirResultado(resultado);

		List<Integer> resultado2 = repo.findByPontuacao(em, 0);

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
