package Jogador;

import java.util.ArrayList;

import Baralho.Carta;

public class JogadorCPU extends Jogador {
	public JogadorCPU(String nome) {
		super(nome.toUpperCase());
	}

	public ArrayList<Carta> getUnicaCarta() {
		ArrayList<Carta> unicaCarta = new ArrayList<Carta>();
		unicaCarta.add(cartas.get(0));

		return unicaCarta;
	}

	public String toString() {		
		String jogador = "A carta do jogador "+this.getNome()+" são: ";
		int pontuacao = 0;
		for(Carta carta : this.getUnicaCarta()) {
			jogador += carta+", ";
			pontuacao += carta.getValor();
		}
		
		jogador += "e a pontuação é de: "+pontuacao+" pontos.\n\n";
		
		return jogador;
	}
}