package BlackJack;
import javax.swing.JOptionPane;

import Jogador.JogadorFactory;
import Jogador.Jogador;
import Jogo.Jogo;
import Jogo.JogoFactory;

public class Main {

	public static void main(String[] args) {
		JogoFactory jogoFactory;
		jogoFactory = new JogoFactory(Main.criarJogo());
		
		int jogarNovamente = 0;
		do {
			try {
				Jogo jogo = jogoFactory.getJogo();
				jogo.iniciar();
		
				jogo.novoTurno();
	
				JOptionPane.showMessageDialog(null, jogo.finalizar());
			
				jogarNovamente = JOptionPane.showConfirmDialog(null, "Deseja jogar novamente?");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		} while(jogarNovamente == 0);
	}

	public static Jogo criarJogo() {
		Jogo jogo = new Jogo();
		
		String nome = JOptionPane.showInputDialog("Digite seu nome:");
		Jogador jogador1 = JogadorFactory.getJogador(nome);
		jogo.adicionarJogador(jogador1);

		Jogador jogador2 = JogadorFactory.getJogador("CPU");		
		jogo.adicionarJogador(jogador2);

		return jogo;
	}
}
