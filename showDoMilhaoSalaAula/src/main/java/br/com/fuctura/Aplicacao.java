package br.com.fuctura;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Properties;

import br.com.fuctura.entidade.Aluno;
import br.com.fuctura.repositorio.AlunoRepositorio;

public class Aplicacao {

	public static void main(String[] args) throws SQLException {

		try (InputStream input = Aplicacao.class.getClassLoader().getResourceAsStream("config.properties")) {

			var prop = new Properties();
			prop.load(input);

			var url = prop.get("url").toString();
			var username = prop.get("username").toString();
			var password = prop.get("password").toString();

			var conexao = DriverManager.getConnection(url, username, password);
			
			AlunoRepositorio repo = new AlunoRepositorio();
			
			Aluno a1 = new Aluno();
			a1.setCodigo(93);
			a1.setNome("DS87");
			a1.setEmail("s87@gmail");
			a1.setPeso(100.0);
			a1.setIdade(39);
			
			repo.inserir(conexao, a1);	
			
			Aluno a2 = new Aluno();
			a2.setCodigo(1);
			
			repo.excluir(conexao, a2);
			System.out.println("DELETE FROM aluno EXECUTADO COM SUCESSO!");
						
			
			var resuldadoConsulta = repo.consultar(conexao);
			
			
			for (Aluno aluno : resuldadoConsulta) {
				System.out.println("Idade: " + aluno.getIdade());
			}
			
			//CRUD
			//READ - executeQuery 
			//CREATE,UPDATE e DELETE - execute
			
		} catch (IOException io) {
			io.printStackTrace();
		}

	}

}
