package br.com.project.rest.services;

import java.util.List;

import br.com.project.rest.model.Aluno;
import br.com.project.rest.model.MalaDireta;
import br.com.project.rest.model.Notas;

public interface AlunoService {

	public void generateMock();
	public List<Aluno> findAll();
	public Notas findOne(String cpf);
	Integer compareNotesAndSendEmail(List<MalaDireta> malaDiretas);
	
	
}
