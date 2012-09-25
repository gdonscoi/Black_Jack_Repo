package Jogador;
public class JogadorFactory {
	public static Jogador getJogador(String nome) {
		if(nome.toLowerCase().equals("cpu"))
			return new JogadorCPU(nome);
		else
			return new Jogador(nome);
	}
}