package br.com.project.rest.model;

public class MalaDireta {

	private String nome;
	private String endereco;
	private String cep;
	private String mensagem;

	public MalaDireta( String nome, String endereco, String cep, String mensagem) {
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.mensagem = mensagem;
	}
	
	public MalaDireta() {
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

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
