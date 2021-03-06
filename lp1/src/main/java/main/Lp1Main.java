package main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entrega_1.modelo.AlunoFatecSJC;
import entrega_1.modelo.Calcado;
import entrega_1.modelo.InstrumentoMusical;
import entrega_1.modelo.Lugar;
import entrega_1.modelo.Profissional;

public class Lp1Main {
	
	public static void main(String[] args){
		// Testando AlunoFatecSJC
		
		List<AlunoFatecSJC> listaAlunos = new ArrayList<AlunoFatecSJC>();
		listaAlunos.add(new AlunoFatecSJC("Leonardo", new Date(1999, 01, 01), "123465789"));
		listaAlunos.add(new AlunoFatecSJC("Mauricio", new Date(1999, 01, 01), "123465789"));
		listaAlunos.add(new AlunoFatecSJC("J�nior", new Date(1999, 01, 01), "123465789"));
		for(AlunoFatecSJC alunoFatecSJC : listaAlunos){
			alunoFatecSJC.acrescentarPresencas(1 + listaAlunos.indexOf(alunoFatecSJC) * (listaAlunos.indexOf(alunoFatecSJC) + 1));
			alunoFatecSJC.acrescentarFaltas(5);
			alunoFatecSJC.mostrarDados();
			alunoFatecSJC.removerFaltas(4);
			alunoFatecSJC.removerPresencas(alunoFatecSJC.getPresencas());
			alunoFatecSJC.mostrarDados();
		}
		
		//Testando cal�ado
		List<Calcado> listaCalcados = new ArrayList<Calcado>();
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
		List<InstrumentoMusical> listaInstrumentoMusical =  new ArrayList<InstrumentoMusical>();
		listaInstrumentoMusical.add(new InstrumentoMusical("Guitarra ", "Gibson", "SG", true));
		listaInstrumentoMusical.add(new InstrumentoMusical("Flauta", "Yamaha", "Transversal", false));
		listaInstrumentoMusical.add(new InstrumentoMusical("Piano Digital", "Casio", "N�o possui", false));
		for(InstrumentoMusical instrumentoMusical : listaInstrumentoMusical){
			instrumentoMusical.afinar();
			instrumentoMusical.tocar();
		}
		
		//Testando Lugar
		List<Lugar> listaLugar = new ArrayList<Lugar>();
		listaLugar.add(new Lugar("Floreanopolis", "Brazil", false, "Portugu�s", false));
		listaLugar.add(new Lugar("Praia grande", "Brazil", false, "Portugu�s", true));
		listaLugar.add(new Lugar("Torre Eiffel", "Fran�a", true, "Franc�s", false));
		for(Lugar lugar : listaLugar){
			lugar.verPaisagem();
			lugar.nadar();
		}
		
		
		//testando Profissional
		List<Profissional> listaProfissional = new ArrayList<Profissional>();
		listaProfissional.add(new Profissional("Analista Java", 10000.00, "Desenvolvimento"));
		listaProfissional.add(new Profissional("CEO", 500000.0, "Diretoria"));
		
	}
}
