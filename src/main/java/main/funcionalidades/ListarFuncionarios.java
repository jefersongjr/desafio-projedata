package main.funcionalidades;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import main.conexao.ConexaoDB;
import main.model.Funcionario;

public class ListarFuncionarios {
	public static void imprimir() throws SQLException {

		Connection connection = ConexaoDB.conectar();
		String query = "select * from funcionarios";
		Statement stmt = connection.createStatement();
		ResultSet resultado = stmt.executeQuery(query);

		listarFuncionarios(resultado);
		
		stmt.close();
		connection.close();
	}

	public static List<Funcionario> listarFuncionarios(ResultSet resultado) throws SQLException {

		List<Funcionario> funcionarios = new ArrayList<>();

		while (resultado.next()) {
			int id = resultado.getInt("id");
			String nome = resultado.getString("nome");
			Date data = resultado.getDate("dataNascimento");
			Calendar calendario = Calendar.getInstance();
			calendario.setTime(data);
			int dia = calendario.get(Calendar.DAY_OF_MONTH);
			int mes = calendario.get(Calendar.MONTH);
			int ano = calendario.get(Calendar.YEAR);
			LocalDate newData = LocalDate.of(ano, mes, dia);
			double salario = resultado.getDouble("salario");
			String funcao = resultado.getString("funcao");
			funcionarios.add(new Funcionario(id, nome, newData, salario, funcao));
		}

		for (Funcionario f : funcionarios) {
			System.out.println("Nome: " + f.getNome() + " - Data de Nascimento: " + f.getDataDeNascimento()
					+ " - Salário: " + f.getSalario() + " - Função: " + f.getFuncao());
		}
		return funcionarios;
	}
}
