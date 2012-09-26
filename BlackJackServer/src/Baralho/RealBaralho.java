package Baralho;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Baralho implements Proxy {
    private ArrayList<Carta> cartas;

    public Baralho() {
        this.cartas = new ArrayList<Carta>();
        ArrayList<String> nomes = new ArrayList<String>();
        ArrayList<String> naipes = new ArrayList<String>();
        int valor = 1;

        nomes.add("A");
        nomes.add("2");
        nomes.add("3");
        nomes.add("4");
        nomes.add("5");
        nomes.add("6");
        nomes.add("7");
        nomes.add("8");
        nomes.add("9");
        nomes.add("10");
        nomes.add("Q");
        nomes.add("J");
        nomes.add("K");

        naipes.add("♦");
        naipes.add("♠");
        naipes.add("♥");
        naipes.add("♣");

        for (String nome : nomes) {
            for (String naipe : naipes)
                this.cartas.add(new Carta(nome, naipe, valor));

            if(valor < 10)
                valor++;
        }
    }

    public void embaralharCartas() {        
        Collections.shuffle(this.cartas);
    }

    public Carta sortearCarta() throws Exception {
        Random generator = new Random();
        
        int maximo = this.cartas.size();
        int posicao = generator.nextInt(maximo);

        Carta carta = this.cartas.get(posicao);
        this.cartas.remove(posicao);

        return carta;
    }
    
    public String toString() {
    	for (Carta carta : this.cartas)
		    System.out.println(carta + "\t");
    	
    	return null;
    }
    
    public int QuantidadeCartas(){
    	return cartas.size();
    }
}