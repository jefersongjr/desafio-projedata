package main.funcionalidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.conexao.ConexaoDB;

public class RemovendoFuncionario {
	public static void remover() throws SQLException {
		Connection connection = ConexaoDB.conectar();
		String query = "DELETE FROM funcionarios WHERE nome = ?";
		PreparedStatement pstm = connection.prepareStatement(query);
		pstm.setString(1, "João");

		int contador = pstm.executeUpdate();

		if (contador > 0) {
			System.out.println("Funcionário(s) Excluído(s) com sucesso!");
			System.out.println("Linhas afetadas: " + contador);
			System.out.println("");
		}

		connection.close();
	}
}
