package br.com.project.rest.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.rest.model.Aluno;
import br.com.project.rest.model.MalaDireta;
import br.com.project.rest.model.Notas;
import br.com.project.rest.util.SendEmail;

@Service
public class AlunoServiceImpl implements AlunoService {

	private static Map<Integer, Aluno> alunos;
	private static Map<Integer, Notas> notas;

	Logger logger = LoggerFactory.getLogger(AlunoServiceImpl.class);

	@Autowired
	SendEmail send;

	/**
	 * Metodo responsavel por gerar os dados para teste Popula os mapas de alunos e
	 * notas
	 */
	@Override
	public void generateMock() {

		try {
			alunos = new HashMap<Integer, Aluno>();
			notas = new HashMap<Integer, Notas>();

			for (int i = 1; i < 15; i++) {
				Aluno a1 = new Aluno(i, "111.111.111-" + i, "Joao", "Rua " + i, "11111-0" + i);

				alunos.put(i, a1);

				Map<String, String> notasDisc = new HashMap<String, String>();

				notasDisc.put("Portugues", i + ".7");
				notasDisc.put("Matematica", i + ".7");
				notasDisc.put("Artes", i + ".7");
				notasDisc.put("Historia", i + ".7");
				notasDisc.put("Geografia", i + ".7");

				Notas nota = new Notas(i, "111111111" + i, notasDisc);
				notas.put(i, nota);

			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	/**
	 * Metodo responsavel por retornar todos os alunos cadastrados
	 */
	@Override
	public List<Aluno> findAll() {
		return new ArrayList<Aluno>(alunos.values());
	}

	/**
	 * Metodo responsavel por achar somente um aluno, de acordo com o cpf passado
	 * pela URL no processo de GET
	 */
	@Override
	public Notas findOne(String cpf) {
		Notas notasFound = null;

		for (Map.Entry<Integer, Notas> entry : notas.entrySet()) {
			if (entry.getValue().getCpf().equalsIgnoreCase(cpf)) {
				notasFound = entry.getValue();
				break;
			}
		}
		return notasFound;
	}
	
	
	/**
	 * Metodo responsavel por comparar as notas e chamar o envio de emails
	 */
	@Override
	public Integer compareNotesAndSendEmail(List<MalaDireta> malaDiretas) {

		Integer mailSendCount = 0;
		for (MalaDireta malaDireta : malaDiretas) {
			for (Entry<Integer, Aluno> alunoId : alunos.entrySet()) {
				Aluno aluno = alunoId.getValue();

				if (aluno.getNome().equalsIgnoreCase(malaDireta.getNome())
						&& aluno.getCep().equalsIgnoreCase(malaDireta.getCep())
						&& aluno.getEndereco().equalsIgnoreCase(malaDireta.getEndereco())) {

					for (Entry<Integer, Notas> nota : notas.entrySet()) {

						if (nota.getValue().getCpf()
								.equalsIgnoreCase(aluno.getDocumento().replace(".", "").replace("-", ""))) {

							Map<String, String> notasDisciplinas = nota.getValue().getNotas();
							for (Map.Entry<String, String> notaDisc : notasDisciplinas.entrySet()) {
								if (Float.valueOf(notaDisc.getValue()).floatValue() <= 7.0) {
									if (send.send(malaDireta.getMensagem())) {
										mailSendCount++;
									}
									break;
								}
							}
						}
					}
				}
			}
		}

		return mailSendCount;
	}

}
