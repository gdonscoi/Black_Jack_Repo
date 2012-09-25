package Jogador;

import java.util.ArrayList;

import Baralho.Carta;

public class Jogador {
	protected String nome;
	protected int pontuacao;
	protected ArrayList<Carta> cartas;

	public Jogador(String nome) {
		this.nome = nome;
		this.cartas = new ArrayList<Carta>();
	}

	public String getNome() {
		return this.nome;
	}

	public int getPontuacao() {
		int pontuacao = 0;
		for(Carta carta : this.cartas)
			pontuacao += carta.getValor();

		return pontuacao;
	}

	public void adicionarCarta(Carta carta) {
		this.cartas.add(carta);
	}

	public ArrayList<Carta> getCartas() {
		return this.cartas;
	}
	
	public void dispensarCartas() {
		this.cartas.clear();
	}

	public String toString() {
		String jogador = "As cartas do jogador "+this.getNome()+" são: ";
		for(Carta carta : this.getCartas()) {
			jogador += carta+", ";
		}
		
		jogador += "e a pontuação é de: "+this.getPontuacao()+" pontos.\n\n";
		
		return jogador;
	}
}