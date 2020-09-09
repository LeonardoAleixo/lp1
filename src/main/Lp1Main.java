package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entrega_1.modelo.AlunoFatecSJC;
import entrega_1.modelo.Calcado;
import entrega_1.modelo.InstrumentoMusical;
import entrega_1.modelo.Lugar;
import entrega_1.modelo.Pessoa;
import entrega_1.modelo.Profissional;

public class Lp1Main {
	
	public static void main(String[] args){
		// Testando AlunoFatecSJC
		
		List<AlunoFatecSJC> listaAlunos = new ArrayList<>();
		listaAlunos.add(new AlunoFatecSJC("Leonardo", new Date(1999, 01, 01), "123465789"));
		listaAlunos.add(new AlunoFatecSJC("Mauricio", new Date(1999, 01, 01), "123465789"));
		listaAlunos.add(new AlunoFatecSJC("Júnior", new Date(1999, 01, 01), "123465789"));
		for(AlunoFatecSJC alunoFatecSJC : listaAlunos){
			alunoFatecSJC.acrescentarPresencas(1 + listaAlunos.indexOf(alunoFatecSJC) * (listaAlunos.indexOf(alunoFatecSJC) + 1));
			alunoFatecSJC.acrescentarFaltas(5);
			alunoFatecSJC.mostrarDados();
			alunoFatecSJC.removerFaltas(4);
			alunoFatecSJC.removerPresencas(alunoFatecSJC.getPresencas());
			alunoFatecSJC.mostrarDados();
		}
		
		//Testando calçado
		List<Calcado> listaCalcados = new ArrayList<>();
		listaCalcados.add(new Calcado(42, "Havaianas", "Branca", "Guga", true, true, 'M'));
		listaCalcados.add(new Calcado(35, "Rasteirinha", "Vermelha", "Xuxa", true, true, 'F'));
		listaCalcados.add(new Calcado(39, "Converse", "Preto", "AllStar", false, true, 'F'));
		listaCalcados.add(new Calcado(35, "Sandalia Nobuck", "Preto", "AREZZO FASHION", true, false, 'F'));
		for(Calcado calcado : listaCalcados){
			calcado.alterarAmarracao();
			calcado.matarBarata();
			calcado.lavar();
		}
		
		//Testando Instrumento Musical
		List<InstrumentoMusical> listaInstrumentoMusical =  new ArrayList<>();
		listaInstrumentoMusical.add(new InstrumentoMusical("Guitarra ", "Gibson", "SG", true));
		listaInstrumentoMusical.add(new InstrumentoMusical("Flauta", "Yamaha", "Transversal", false));
		listaInstrumentoMusical.add(new InstrumentoMusical("Piano Digital", "Casio", "Não possui", false));
		for(InstrumentoMusical instrumentoMusical : listaInstrumentoMusical){
			instrumentoMusical.afinar();
			instrumentoMusical.tocar();
		}
		
		//Testando Lugar
		List<Lugar> listaLugar = new ArrayList<>();
		listaLugar.add(new Lugar("Floreanopolis", "Brazil", false, "Português", false));
		listaLugar.add(new Lugar("Praia grande", "Brazil", false, "Português", true));
		listaLugar.add(new Lugar("Torre Eiffel", "França", true, "Francês", false));
		for(Lugar lugar : listaLugar){
			lugar.verPaisagem();
			lugar.nadar();
		}
		
		//Testando Pessoa
		List<Pessoa> listaPessoas = new ArrayList<>();
		listaPessoas.add(new Pessoa("Victor", new Date(1995, 11, 21), 1.73, "12345789", false, null));
		listaPessoas.add(new Pessoa("Leonardo", new Date(1999, 01, 01), 1.78, "654987321", true, new Date()));
		listaPessoas.add(new Pessoa("Paulo", new Date(1994, 02, 03), 1.97, "77777777", false, null));
		listaPessoas.add(new Pessoa("Jeison", new Date(1995, 03, 18), 1.67, "88888888", false, null));
		for(Pessoa pessoa : listaPessoas){
			pessoa.doarSangue();
			pessoa.terFilhos(4 + listaPessoas.indexOf(pessoa));
		}
		
		//testando Profissional
		List<Profissional> listaProfissional = new ArrayList<>();
		listaProfissional.add(new Profissional("Analista Java", 10000.00, "Desenvolvimento"));
		listaProfissional.add(new Profissional("CEO", 500000.0, "Diretoria"));
		
	}
}
