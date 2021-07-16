package ProjetoSpring.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetoSpring.Controller.model.Aluno;


@RestController
@RequestMapping("/aluno")
public class ControllerAluno {

	private List<Aluno> alunos = new ArrayList<Aluno>();

	@PostMapping("/publicar")
	public String publicar(@RequestBody Aluno aluno) {
		alunos.add(aluno);
		return "Inserido com Sucesso!";
	}

	@GetMapping("/visualizar")
	public List<Aluno> visualizar() {
		return alunos;
	}

	@GetMapping("/procurar/{cpf}")
	public Aluno procurar(@PathVariable("cpf") String cpf) {
		Aluno alunoencontrado = null;
		for (Aluno aluno : alunos) {
			if (aluno.getCpf().equals(cpf)) {
				alunoencontrado = aluno;
			}
		}
		return alunoencontrado;
	}

	@PutMapping("/atualizar/{cpf}")
	public String atualizar(@PathVariable("cpf") String cpf, @RequestBody Aluno aluno) {
		Aluno alunoencontrado = null;
		for (Aluno aluno1 : alunos) {
			if (aluno1.getCpf().equals(cpf)) {
				alunoencontrado = aluno1;
				alunos.remove(alunoencontrado);
				Aluno aluno2 = new Aluno(aluno.getNome(), aluno.getCpf(), aluno.getIdade(), aluno.getCodigocurso(), aluno.getNomecurso());
				alunos.add(aluno2);
				break;
			}
			
		}
		return "Dados alterados com sucesso!";
	}

	@DeleteMapping("/remover/{cpf}")
	public String remover(@PathVariable("cpf") String cpf) {
		Aluno alunoencontrado = null;
		for (Aluno aluno : alunos) {
			if (aluno.getCpf().equals(cpf)) {
				alunoencontrado = aluno;
				alunos.remove(alunoencontrado);
				break;
			}
		}
		return "Aluno removido!";
	}
}