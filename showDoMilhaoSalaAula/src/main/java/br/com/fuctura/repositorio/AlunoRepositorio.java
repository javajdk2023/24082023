package br.com.fuctura.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fuctura.entidade.Aluno;

public class AlunoRepositorio {
	public void inserir(Connection conexao, Aluno aluno) throws SQLException {
		//preparar
		var comandoSQLINSERT = "INSERT INTO aluno VALUES (?, ?, ?, ?, ?)";
		var ps = conexao.prepareStatement(comandoSQLINSERT);

		
		//atribuir valores
		ps.setInt(1, aluno.getCodigo()); 
		ps.setString(2, aluno.getNome());
		ps.setInt(3, aluno.getIdade());
		ps.setString(4, aluno.getEmail());
		ps.setDouble(5, aluno.getPeso());
		
		//executar
		ps.execute();
		
		System.out.println("INSERT INTO aluno EXECUTADO COM SUCESSO!");
	}
	
	public void excluir(Connection conexao, Aluno aluno) throws SQLException {
		var comandoSQLDELETE = "DELETE FROM aluno WHERE codigo = ?";
		
		var ps = conexao.prepareStatement(comandoSQLDELETE);
	
		ps.setInt(1, aluno.getCodigo());
		
		ps.execute();
	}
	
	public ArrayList<Aluno> consultar(Connection conexao) throws SQLException {
		var comandoSQLConsulta = "SELECT * FROM aluno";
		
		PreparedStatement ps = conexao.prepareStatement(comandoSQLConsulta);
		
		var resultadoConsulta = ps.executeQuery();
		
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		
		while(resultadoConsulta.next()){
			var idade = resultadoConsulta.getInt("idade");
			var peso = resultadoConsulta.getDouble("peso");

			Aluno a = new Aluno();
			a.setIdade(idade);
			a.setPeso(peso);
			
			alunos.add(a);
		}
		
		return alunos;
	}
	
	public void consultarConsultarPorCodigo(Connection conexao, Aluno aluno) throws SQLException {
		var comandoSQLConsulta = "SELECT * FROM aluno where codigo = ?";
		
		PreparedStatement ps = conexao.prepareStatement(comandoSQLConsulta);
				
		ps.setInt(1, aluno.getCodigo());
		
		var resultadoConsulta = ps.executeQuery();
		
		while(resultadoConsulta.next()){
			var idade = resultadoConsulta.getInt("idade");
			System.out.println("Idade: " + idade);
		}
	}
}
