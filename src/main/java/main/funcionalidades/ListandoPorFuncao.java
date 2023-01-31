package main.funcionalidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import main.conexao.ConexaoDB;
import main.model.Funcionario;
import util.Tipos;

public class ListandoPorFuncao {

	public static void listarMap() throws SQLException {

		Connection connection = ConexaoDB.conectar();
		String query = "select * from funcionarios where funcao = ?";

		for (Tipos tipo : Tipos.values()) {
			PreparedStatement psmt = connection.prepareStatement(query);
			psmt.setString(1, tipo.toString());
			ResultSet resultado = psmt.executeQuery();

			List<Funcionario> funcionarios = ListarFuncionarios.listarFuncionarios(resultado);

			HashMap<String, List<Funcionario>> mapPorFuncao = new HashMap<>();
			for (Funcionario f : funcionarios) {
				mapPorFuncao.put(f.getFuncao(), funcionarios);

			}

			for (String key : mapPorFuncao.keySet()) {

				List<Funcionario> value = mapPorFuncao.get(key);
				System.out.println(key + ":");
				ListarFuncionarios.imprimirFuncionarios(value);
			}
		}
	}
}