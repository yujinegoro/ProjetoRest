package br.com.project.rest.model;

import java.util.Map;

public class Notas {

	private Integer id;
	private String cpf;
	private Map<String, String> notas;

	public Notas(Integer id, String cpf, Map<String, String> notas) {
		this.id = id;
		this.cpf = cpf;
		this.setNotas(notas);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Map<String, String> getNotas() {
		return notas;
	}

	public void setNotas(Map<String, String> notas) {
		this.notas = notas;
	}

}
