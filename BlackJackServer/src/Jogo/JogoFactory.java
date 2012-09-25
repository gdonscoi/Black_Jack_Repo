package Jogo;

public class JogoFactory {
	private Jogo prototype;
	
	public JogoFactory(Jogo prototype) {
		this.prototype = prototype;
	}
	
	public Jogo getJogo() throws CloneNotSupportedException {
		return this.prototype.clone();
	}
}