package main.funcionalidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import main.conexao.ConexaoDB;

public class ListarSomaSalario {
	public static void imprimirSoma() throws SQLException {
		Connection connection = ConexaoDB.conectar();
		String query = "SELECT SUM(SALARIO) FROM funcionarios";
		Statement stmt = connection.createStatement();
		ResultSet resultado = stmt.executeQuery(query);

		while(resultado.next()) {
			double soma = resultado.getDouble("SUM(salario)");
			System.out.println(" ");
			System.out.println("A Soma do salário de todos os funcionários é: " + soma);
		}
		
	}
}
