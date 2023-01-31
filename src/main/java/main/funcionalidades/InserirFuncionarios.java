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
		String query = "insert into funcionarios (id ,nome, dataNascimento, salario, funcao)"
				+ "values (?, ? ,? ,?, ?)";
		PreparedStatement pstm = connection.prepareStatement(query);
		List<Funcionario> funcionarios = listaDeFuncionario();
		for (Funcionario f : funcionarios) {
			pstm.setInt(1, f.getId());
			pstm.setString(2, f.getNome());
			pstm.setDate(3, Date.valueOf(f.getDataDeNascimento()));
			pstm.setDouble(4, f.getSalario());
			pstm.setString(5, f.getFuncao());

			pstm.execute();
		}
	}

	public static List<Funcionario> listaDeFuncionario() {
		List<Funcionario> list = new ArrayList<>();
		list.add(new Funcionario(1, "Maria", LocalDate.of(2000, 11, 10), 2009.44, "Operador"));
		list.add(new Funcionario(2, "João", LocalDate.of(2001, 6, 12), 2284.38, "Operador"));
		list.add(new Funcionario(3, "Caio", LocalDate.of(1961, 7, 02), 9836.14, "Coordenador"));
		list.add(new Funcionario(4, "Miguel", LocalDate.of(1988, 11, 14), 19119.88, "Diretor"));
		list.add(new Funcionario(5, "Alice", LocalDate.of(1995, 03, 05), 2234.68, "Recepcionista"));
		list.add(new Funcionario(6, "Heitor", LocalDate.of(1999, 12, 19), 1582.72, "Operador"));
		list.add(new Funcionario(7, "Arthur", LocalDate.of(1993, 2, 28), 4071.84, "Contador"));
		list.add(new Funcionario(8, "Laura", LocalDate.of(1994, 5, 8), 3017.45, "Gerente"));
		list.add(new Funcionario(9, "Heloísa", LocalDate.of(2003, 06, 24), 1606.85, "Eletricista"));
		list.add(new Funcionario(10, "Helena", LocalDate.of(1996, 7, 02), 2799.93, "Gerente"));
		return list;
	}
}
