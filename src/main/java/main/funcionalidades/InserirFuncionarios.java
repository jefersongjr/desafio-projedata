package main.funcionalidades;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.conexao.ConexaoDB;
import main.model.Funcionario;

public class InserirFuncionarios {
	public static void inserir() throws SQLException {
		Connection connection = ConexaoDB.conectar();
		String query = "insert into funcionarios (nome, dataNascimento, salario, funcao)"
				+ "values (?, ? ,? ,?)";
		PreparedStatement pstm = connection.prepareStatement(query);
		List<Funcionario> funcionarios = listaDeFuncionario();
		for (Funcionario f : funcionarios) {
			pstm.setString(1, f.getNome());
			pstm.setDate(2, Date.valueOf(f.getDataDeNascimento()));
			pstm.setDouble(3, f.getSalario());
			pstm.setString(4, f.getFuncao());

			pstm.execute();
		}
		
		System.out.println("Todos Funcionários foram cadastrados com sucesso");
		System.out.println(" ");
		pstm.close();
		connection.close();
	}

	public static List<Funcionario> listaDeFuncionario() {
		List<Funcionario> list = new ArrayList<>();
		list.add(new Funcionario("Maria", LocalDate.of(2000, 11, 18), 2009.44, "Operador"));
		list.add(new Funcionario("João", LocalDate.of(2001, 6, 12), 2284.38, "Operador"));
		list.add(new Funcionario("Caio", LocalDate.of(1961, 6, 02), 9836.14, "Coordenador"));
		list.add(new Funcionario("Miguel", LocalDate.of(1988, 11, 14), 19119.88, "Diretor"));
		list.add(new Funcionario("Alice", LocalDate.of(1995, 02, 05), 2234.68, "Recepcionista"));
		list.add(new Funcionario("Heitor", LocalDate.of(1999, 12, 19), 1582.72, "Operador"));
		list.add(new Funcionario("Arthur", LocalDate.of(1993, 04, 30), 4071.84, "Contador"));
		list.add(new Funcionario("Laura", LocalDate.of(1994, 8, 8), 3017.45, "Gerente"));
		list.add(new Funcionario("Heloísa", LocalDate.of(2003, 06, 24), 1606.85, "Eletricista"));
		list.add(new Funcionario("Helena", LocalDate.of(1996, 10, 02), 2799.93, "Gerente"));
		return list;
	}
}
