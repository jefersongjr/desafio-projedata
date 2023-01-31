package main;

import java.sql.SQLException;

import main.conexao.ConexaoDB;
import main.funcionalidades.CriarTabela;
import main.funcionalidades.InserirFuncionarios;
import main.funcionalidades.RemovendoFuncionario;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException 
    {
    	ConexaoDB.conectar();
    	CriarTabela.criar();
    	InserirFuncionarios.inserir();
    	RemovendoFuncionario.remover();
    }
}
