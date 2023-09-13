package br.com.fuctura;

import java.util.List;

import br.com.fuctura.model.Alternativa;
import br.com.fuctura.model.Jogo;
import br.com.fuctura.model.Questao;

public class Aplicacao {

	public static void main(String[] args) {
		
		var jogo = new Jogo();
		
		var alternativa = new Alternativa("Java é orientada a objetos", true);
		var alternativa2 = new Alternativa("Java não é orientada a objetos", false);

		
		var questao = new Questao();
		questao.setEnunciado("Escolha a opção verdadeira abaixo:");
		questao.setAlternativas(List.of(alternativa, alternativa2));
		
		jogo.setQuestoes(List.of(questao));
		
		for (Questao q : jogo.getQuestoes()) {
			System.out.println("Enunciado - " + questao.getEnunciado());
			q.getAlternativas().stream().forEach( a -> System.out.println("Alternativa - " + a.getDescricao()) );
			
		}
		
	}

}
