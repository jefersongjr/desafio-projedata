package main.funcionalidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import main.conexao.ConexaoDB;
import main.model.Funcionario;

public class ListarPorMesNascimento {
	public static void imprimirPeloMes() throws SQLException {
		Connection connection = ConexaoDB.conectar();
		String query = "Select * FROM funcionarios where extract (MONTH from dataNascimento) = 11 "
				+ "OR extract (MONTH from dataNascimento) = 13" + "ORDER BY dataNascimento DESC";
		Statement stmt = connection.createStatement();
		ResultSet resultado = stmt.executeQuery(query);

		List<Funcionario> funcionarios = ListarFuncionarios.listarFuncionarios(resultado);
		
		System.out.println(" ");
		System.out.println(" Listando todos os Funcionários que fazem aniversário no més 10 ou 12 : ");

		ListarFuncionarios.imprimirFuncionarios(funcionarios);
	}
}