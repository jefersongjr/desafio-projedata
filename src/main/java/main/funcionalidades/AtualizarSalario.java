package main.funcionalidades;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import main.conexao.ConexaoDB;

public class AtualizarSalario {
	public static void aumentoSalario() throws SQLException {

		Connection connection = ConexaoDB.conectar();
		String query = "UPDATE funcionarios SET salario = salario * 1.10 ";
		Statement stmt = connection.createStatement();
		stmt.execute(query);
		
		System.out.println(" ");
		System.out.println("Todos os salários foram atualizados: ");
		
		ListarFuncionarios.imprimir();

		stmt.close();
		connection.close();
	}

}
