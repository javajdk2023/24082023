package br.com.fuctura;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Aplicacao {

	public static void main(String[] args) throws SQLException {

		try (InputStream input = Aplicacao.class.getClassLoader().getResourceAsStream("config.properties")) {

			var prop = new Properties();
			prop.load(input);

			var url = prop.get("url").toString();
			var username = prop.get("username").toString();
			var password = prop.get("password").toString();

			var conexao = DriverManager.getConnection(url, username, password);
			
			//preparar
			var comandoSQLINSERT = "INSERT INTO aluno VALUES (?, ?, ?, ?, ?)";
			var ps = conexao.prepareStatement(comandoSQLINSERT);

			var codigoAluno = 4;
			var nomeAluno = "joao";
			var idadeAluno = 20;
			var emailAluno = "j@gmail";
			var pesoAluno = 60;
			
			//atribuir valores
			ps.setInt(1, codigoAluno);
			ps.setString(2, nomeAluno);
			ps.setInt(3, idadeAluno);
			ps.setString(4, emailAluno);
			ps.setDouble(5, pesoAluno);
			
			//executar
			ps.execute();
			
			System.out.println("INSERT INTO aluno EXECUTADO COM SUCESSO!");
				
			
			var comandoSQLDELETE = "DELETE FROM aluno WHERE codigo = ?";
			
			ps = conexao.prepareStatement(comandoSQLDELETE);
		
			ps.setInt(1, codigoAluno);
			
			ps.execute();
			
			
			System.out.println("DELETE FROM aluno EXECUTADO COM SUCESSO!");
			
		} catch (IOException io) {
			io.printStackTrace();
		}

	}

}
