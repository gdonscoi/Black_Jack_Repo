package Jogo;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Baralho.Baralho;
import Baralho.Carta;
import Baralho.ProxyBaralho;
import Jogador.Jogador;


public class Jogo implements Cloneable {
	private ArrayList<Jogador> jogadores;
	private Baralho baralho;
	
	public Jogo() {
		this.jogadores = new ArrayList<Jogador>();
	}
	
	public Jogo clone() throws CloneNotSupportedException {
        return (Jogo) super.clone();
	}
	
	public void adicionarJogador(Jogador jogador) {
		this.jogadores.add(jogador);
	}
	
	public void iniciarBaralho() {
		this.baralho = new ProxyBaralho(jogadores);
		this.baralho.embaralharCartas();
	}
	
	public void iniciar() {
		this.iniciarBaralho();
		
		for(Jogador jogador : this.jogadores) {		
			try {
				Carta carta1 = this.baralho.sortearCarta();
				jogador.adicionarCarta(carta1);
				
				Carta carta2 = this.baralho.sortearCarta();
				jogador.adicionarCarta(carta2);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void novoTurno() {
		Jogador jogador = this.jogadores.get(0);
		int resposta = this.exibirCartas();
		while (resposta == 0) {
			if(!this.sortearNovaCarta(jogador)) {
				JOptionPane.showMessageDialog(null, "Você estourou o limite de pontos!");
				break;
			}

			resposta = this.exibirCartas();
		}
	}
	
	public boolean sortearNovaCarta(Jogador jogador) {
		try {
			Carta carta = this.baralho.sortearCarta();
			
			jogador.adicionarCarta(carta);

			int pontuacao = jogador.getPontuacao();
			if(pontuacao > 21)
				throw new Exception("O jogador estourou a pontuação.");
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public int exibirCartas() {
		String mensagem = "";
		for(Jogador jogador : this.jogadores) {
			mensagem += jogador;
		}
		mensagem += "Deseja receber outra carta?";
		
		return JOptionPane.showConfirmDialog(null, mensagem);
	}
	
	public String finalizar() {
		Jogador ganhador = null;
		boolean empate = false;
		String resultado = "";
		
		for(Jogador jogador : this.jogadores) {
			resultado += jogador;
			int pontuacao = jogador.getPontuacao();
			if(pontuacao <= 21) {
				if(ganhador != null && pontuacao == ganhador.getPontuacao())
					empate = true;
				
				else if(ganhador == null || pontuacao > ganhador.getPontuacao())
					ganhador = jogador;
			}
		}

		if(empate == true || ganhador == null)
			resultado += "O jogo empatou!";
		else
			resultado += "O ganhador foi "+ganhador.getNome()+"!!!";

		return resultado;
	}
}