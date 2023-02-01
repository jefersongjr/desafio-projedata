package main.funcionalidades;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import main.conexao.ConexaoDB;

public class CriarTabela {
	public static void criar() throws SQLException {
		try {
			Connection connection = ConexaoDB.conectar();
			Statement stmt = connection.createStatement();
			String query = " create table funcionarios( nome VARCHAR(40) NOT NULL," + " dataNascimento DATE NOT NULL,"
					+ " salario DECIMAL NOT NULL ," + " funcao VARCHAR(20) NOT NULL" + ")";
			stmt.execute(query);
			System.out.println("Tabela criada com sucesso!");
			System.out.println(" ");
		} catch (Exception e) {
			throw new SQLException(e);
		}

	}
}
