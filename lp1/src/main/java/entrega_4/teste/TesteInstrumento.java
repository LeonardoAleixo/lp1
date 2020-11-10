package entrega_4.teste;

import java.util.List;

import entrega_1.modelo.InstrumentoMusical;
import entrega_4.repository.InstrumentoRepository;

public class TesteInstrumento {
	public static void main(String[] args) {
		InstrumentoMusical instrumento = new InstrumentoMusical("Guitarra", "Epiphone", "SG", true);
		InstrumentoMusical instrumento2 = new InstrumentoMusical("Guitarra 2", "Epiphone 2", "SG 2", true);
		InstrumentoRepository instrumentoRepository = new InstrumentoRepository();
		instrumentoRepository.inserir(instrumento);
		instrumentoRepository.inserir(instrumento2);
		List<InstrumentoMusical> lista = instrumentoRepository.listarTodos();
		int i = 0;
		for (InstrumentoMusical ins : lista) {
			System.out.println(ins.getMarca());
			System.out.println(ins.getModelo());
			System.out.println(ins.getNome());
			if (i == 1) {
				ins.setNome("Mudei o nome");
				instrumentoRepository.editar(ins);
			} else {
				instrumentoRepository.delete(ins);
			}
			i++;
		}
	}
}
