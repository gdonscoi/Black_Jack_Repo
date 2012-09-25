package Baralho;

public class Carta {
	private String nome;
	private int valor;
	private String naipe;

	public Carta (String nome, String naipe, int valor) {
		this.nome = nome;
		this.valor = valor;
		this.naipe = naipe;
	}

	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getValor() {
		return this.valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getNaipe() {
		return this.naipe;
	}
	public void setNaipe(String naipe) {
		this.naipe = naipe;
	}

	public String toString() {
		return this.nome+" "+this.naipe;
	}
}
