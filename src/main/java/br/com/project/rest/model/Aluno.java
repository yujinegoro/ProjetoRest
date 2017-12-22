package br.com.project.rest.model;


public class Aluno {

	private Integer id;
	private String documento;
	private String nome;
	private String endereco;
	private String cep;
	
	public Aluno(Integer id, String documento, String nome, String endereco, String cep) {
		this.id = id;
		this.documento = documento;
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
