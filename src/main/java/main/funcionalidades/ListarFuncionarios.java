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

		List<Funcionario> listFuncionario = listarFuncionarios(resultado);
		imprimirFuncionarios(listFuncionario);
		stmt.close();
		connection.close();
	}

	public static List<Funcionario> listarFuncionarios(ResultSet resultado) throws SQLException {

		List<Funcionario> funcionarios = new ArrayList<>();

		while (resultado.next()) {
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
			funcionarios.add(new Funcionario(nome, newData, salario, funcao));
		}

		return funcionarios;
	}

	public static void imprimirFuncionarios(List<Funcionario> funcionarios) throws SQLException {
		System.out.println("__________________________________________________________________");
		System.out.println("| Nome      | Data De Nascimento | Salário       |   Função       |");
		System.out.println("__________________________________________________________________");

		for (Funcionario f : funcionarios) {
			System.out.println("|"+f.getNome() + "          " + f.getDataDeNascimento() + "             " + f.getSalario()
					+ "        " + f.getFuncao()+"|");
			System.out.println("|___________|____________________|_______________|________________|");

		}
	}
}
