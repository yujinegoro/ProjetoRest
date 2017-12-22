package br.com.project.rest.resource;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.rest.model.Aluno;
import br.com.project.rest.model.MalaDireta;
import br.com.project.rest.model.Notas;
import br.com.project.rest.services.AlunoService;

@RestController
public class AlunoResource {

	@Autowired
	private AlunoService alunoService;

	@PostConstruct
	public void generateMock() {
		alunoService.generateMock();
	}

	@RequestMapping(value = "/alunos", method = RequestMethod.GET)
	public ResponseEntity<List<Aluno>> listAll() {
		return new ResponseEntity<List<Aluno>>(alunoService.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/alunos/{cpf}/notas", method = RequestMethod.GET)
	public ResponseEntity<Notas> listByCpf(@PathVariable("cpf") String cpf) {
		Notas notas = alunoService.findOne(cpf);
		if (notas == null)
			return new ResponseEntity<Notas>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Notas>(notas, HttpStatus.OK);
	}

	@RequestMapping(value = "/maladireta", method = RequestMethod.POST)
	public ResponseEntity<Integer> malaDireta(@RequestBody List<MalaDireta> malaDiretas) {
		if (malaDiretas == null) {
			return new ResponseEntity<Integer>(0, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Integer>((alunoService.compareNotesAndSendEmail(malaDiretas).intValue()),
				HttpStatus.OK);
	}
}
