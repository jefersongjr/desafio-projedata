package main;


import java.sql.SQLException;
import main.conexao.ConexaoDB;
import main.funcionalidades.AtualizarSalario;
import main.funcionalidades.CriarTabela;
import main.funcionalidades.InserirFuncionarios;
import main.funcionalidades.ListandoPorFuncao;
import main.funcionalidades.ListarEmOrdemAlfabetica;
import main.funcionalidades.ListarFuncionarios;
import main.funcionalidades.ListarMaisVelho;
import main.funcionalidades.ListarPorMesNascimento;
import main.funcionalidades.ListarSomaSalario;
import main.funcionalidades.RemovendoFuncionario;


public class App {
	public static void main(String[] args) throws SQLException {
//		ConexaoDB.conectar();
//		CriarTabela.criar();
//		InserirFuncionarios.inserir();
//		RemovendoFuncionario.remover();
//		ListarFuncionarios.imprimir();
//		AtualizarSalario.aumentoSalario();
//		ListandoPorFuncao.listarMap();
//		ListarPorMesNascimento.imprimirPeloMes();
		ListarMaisVelho.imprimirMaisVelho();
    ListarEmOrdemAlfabetica.listarOrdenado();
		ListarSomaSalario.imprimirSoma();
	}
}
