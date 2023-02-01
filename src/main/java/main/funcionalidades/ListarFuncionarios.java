package main.funcionalidades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import main.conexao.ConexaoDB;
import main.model.Funcionario;

public class ListarFuncionarios {
	public static void imprimir() throws SQLException {

		Connection connection = ConexaoDB.conectar();
		String query = "select * from funcionarios";
		Statement stmt = connection.createStatement();
		ResultSet resultado = stmt.executeQuery(query);

		List<Funcionario> listFuncionario = listarFuncionarios(resultado);
		System.out.println("Imprimindo Funcionários Cadastrados");	
		System.out.println(" ");

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
			String data = formataData(f.getDataDeNascimento());
			String salario = formataSalario(f.getSalario());
			System.out.println("|"+f.getNome() + "          " + data + "           " + salario
					+ "     " + f.getFuncao()+"");
			System.out.println("|___________|____________________|_______________|________________|");

		}
	}
	
	public static String formataSalario(double salario) throws SQLException {
		BigDecimal salarioFormatado = new BigDecimal(salario).setScale(2, RoundingMode.HALF_EVEN);
		Locale ptBr = new Locale("pt","BR");
		String valor = NumberFormat.getCurrencyInstance(ptBr).format(salarioFormatado);
		return valor;
		}
	
	public static String formataData(LocalDate data) throws SQLException {
			int ano = data.getYear();
			int mes = data.getMonthValue();
			int dia = data.getDayOfMonth();
			String dataCompleta = ""+dia+"/"+mes+"/"+ano+"";
			return dataCompleta;
			} 
}
