package main.funcionalidades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import main.conexao.ConexaoDB;
import main.model.Funcionario;

public class ImprimirSalarioMinimo {
	
	public static void listarSalarios() throws SQLException {
		Connection connection = ConexaoDB.conectar();
		String query = "SELECT * FROM funcionarios";
		Statement stmt = connection.createStatement();
		ResultSet resultado = stmt.executeQuery(query);
		
		List<Funcionario> funcionarios = ListarFuncionarios.listarFuncionarios(resultado);
		
		System.out.println("______________________________");
		System.out.println("| Nome      | Salários Mínimos|");
		System.out.println("|___________|_________________|");

		for(Funcionario f: funcionarios) {
			double salarios = f.getSalario()/1212.00;
			BigDecimal quantidade = new BigDecimal(salarios).setScale(1, RoundingMode.HALF_EVEN);
			System.out.println("|"+ f.getNome()+"         "+quantidade);
			System.out.println("|___________|_________________|");
		}
	}
}
