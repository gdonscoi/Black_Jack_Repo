package Baralho;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import Jogador.Jogador;

public class ProxyBaralho implements Baralho {

	private RealBaralho baralho;
	
	public ProxyBaralho (ArrayList<Jogador> jogadores ) {
		if (jogadores.size() < 2) {
			JOptionPane.showMessageDialog(null, "Impossivel jogar com menos de 2 pessoas, o programa ser? fechado.");
			System.exit(0);
		}else 
			baralho = new RealBaralho();
	}
	
	public void embaralharCartas() {
		if (baralho.QuantidadeCartas() > 0)
			baralho.embaralharCartas();
	}


	public Carta sortearCarta() throws Exception {
        if(baralho.QuantidadeCartas() < 0) 
            throw new Exception("O baralho não possui mais cartas.");
        else 
        	return baralho.sortearCarta();
	}

}
