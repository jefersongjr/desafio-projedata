package main.funcionalidades;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import main.conexao.ConexaoDB;
import main.model.Funcionario;

public class ListarMaisVelho {
	public static void imprimirMaisVelho() throws SQLException {
		Connection connection = ConexaoDB.conectar();
		String query = "SELECT * FROM funcionarios "
				+ "WHERE (extract (YEAR from dataNascimento)) = (SELECT min(extract (YEAR from dataNascimento)) "
				+ "FROM funcionarios)";

		Statement stmt = connection.createStatement();
		ResultSet resultado = stmt.executeQuery(query);

		List<Funcionario> funcionarios = ListarFuncionarios.listarFuncionarios(resultado);
		System.out.println(" ");
		System.out.println(" Listando o Nome e a Idade do Funcionário mais Velho.");
		for (Funcionario f : funcionarios) {
			int idade = LocalDate.now().getYear() - f.getDataDeNascimento().getYear();
			System.out.println("_______________________");
			System.out.println("|Nome      | Idade    |");
			System.out.println("|__________|__________|");
			System.out.println("|"+f.getNome() + "      | " + idade +"       |");
			System.out.println("|__________|__________|");

		}

	}

}
