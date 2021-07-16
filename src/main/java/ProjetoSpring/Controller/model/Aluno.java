package ProjetoSpring.Controller.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Aluno {
	
	private String nome;
	private String cpf;
	private int idade;
	private Double codigocurso;
	private String nomecurso;	

}
