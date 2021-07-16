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

import ProjetoSpring.Controller.model.Professor;

@RestController
@RequestMapping("/professor")
public class ControllerProfessor {

	private List<Professor> professores = new ArrayList<Professor>();

	@PostMapping("/publicar")
	public String publicar(@RequestBody Professor professor) {
		professores.add(professor);
		return "Inserido com Sucesso!";
	}

	@GetMapping("/visualizar")
	public List<Professor> visualizar() {
		return professores;
	}

	@GetMapping("/procurar/{cpf}")
	public Professor procurar(@PathVariable("cpf") String cpf) {
		Professor professorencontrado = null;
		for (Professor professor : professores) {
			if (professor.getCpf().equals(cpf)) {
				professorencontrado = professor;
			}
		}
		return professorencontrado;
	}

	@PutMapping("/atualizar/{cpf}")
	public String atualizar(@PathVariable("cpf") String cpf, @RequestBody Professor professor) {
		Professor professorencontrado = null;
		for (Professor professor1 : professores) {
			if (professor1.getCpf().equals(cpf)) {
				professorencontrado = professor1;
				professores.remove(professorencontrado);
				Professor professor2 = new Professor(professor.getNome(), professor.getCpf(), professor.getIdade(),
						professor.getSalario());
				professores.add(professor2);
				break;
			}

		}
		return "Dados alterados com sucesso!";
	}

	@DeleteMapping("/remover/{cpf}")
	public String remover(@PathVariable("cpf") String cpf) {
		Professor professorencontrado = null;
		for (Professor professor : professores) {
			if (professor.getCpf().equals(cpf)) {
				professorencontrado = professor;
				professores.remove(professorencontrado);
				break;
			}
		}
		return "Professor removido!";
	}
}