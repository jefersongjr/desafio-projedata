package main.model;

import java.time.LocalDate;

public class Funcionario extends Pessoa {

	private double salario;
	private String funcao;

	public Funcionario(int id, String nome, LocalDate dataDeNascimento,
			double salario, String funcao) {
		super(nome, dataDeNascimento);
		this.salario = salario;
		this.funcao = funcao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
}