package entrega_4.teste;

import java.util.List;

import entrega_1.modelo.Calcado;
import entrega_4.repository.CalcadoRepository;

public class TesteCalcado {

	public static void main(String[] args) {
		CalcadoRepository calcadoRepository = new CalcadoRepository();
		Calcado calcado = new Calcado(45, "Fabricante", "Preto", "Camel 45", true, true, 'F');
		Calcado calcado2 = new Calcado(39, "Fabricante 2", "Branco", "Camel 39", true, true, 'F');
		calcadoRepository.inserir(calcado);
		calcadoRepository.inserir(calcado2);
		List<Calcado> listaCalcado = calcadoRepository.listarTodos();
		int i = 0;
		for (Calcado cal : listaCalcado) {
			cal.mostrarDados();
			if (i == 1) {
				calcado.setCor("VERMELHO");
				calcadoRepository.editar(cal);
			} else {
				calcadoRepository.delete(cal);
			}
			i++;
		}
	}
}
