package main.funcionalidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import main.conexao.ConexaoDB;
import main.model.Funcionario;

public class ListarEmOrdemAlfabetica {
	
	public static void listarOrdenado() throws SQLException {
		Connection connection = ConexaoDB.conectar();
		String query = "SELECT * FROM funcionarios ORDER BY nome";
		Statement stmt = connection.createStatement();
		ResultSet resultado = stmt.executeQuery(query);

		List<Funcionario> funcionarios = ListarFuncionarios.listarFuncionarios(resultado);
		
		System.out.println(" ");
		System.out.println("Todos os salários foram atualizadosListar Funcionários em ordem alfabética: ");

		ListarFuncionarios.imprimirFuncionarios(funcionarios);
	}
}
