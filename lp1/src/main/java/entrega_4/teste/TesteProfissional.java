package entrega_4.teste;

import java.util.List;

import entrega_1.modelo.Profissional;
import entrega_4.repository.ProfissionalRepository;

public class TesteProfissional {

	public static void main (String[] args){
		ProfissionalRepository profissionalRepository = new ProfissionalRepository();
		Profissional profissional = new Profissional("Analista Java Jr", 2.500, "Desenvolvimento");
		Profissional profissional2 = new Profissional("Analista java Pl", 4.200, "Desenvolvimento");
		profissionalRepository.inserir(profissional);
		profissionalRepository.inserir(profissional2);
		int i = 0;
		List<Profissional> lista = profissionalRepository.listarTodos();
		for(Profissional pro : lista){
			System.out.println(pro.toString());
			if (i == 1){
				pro.setSalario(3.200);
				profissionalRepository.editar(pro);
			}else{
				profissionalRepository.delete(pro);
			}
			i++;
		}
	}
}
