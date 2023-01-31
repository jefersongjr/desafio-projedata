package main.model;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.format.annotation.DateTimeFormat;

public class Pessoa {

	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;
	protected String nome;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataDeNascimento;	

	public Pessoa(String nome, LocalDate dataDeNascimento2) {
		super();
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

}
