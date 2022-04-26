package segundo;
import java.util.*;
//iniciado pelo Daniel

//2h nesta coisa +4h +1  +2+2+1.5 +2 +2 +2
//cenas para fazer no jogo:
//criar uma classe do jogo
//baralho, pilhas transicao e de armazenamento como atributos
//metodo de baralhar
//arraylist para cada pilha
//importar file input stream???
//rebobinar e por o baralho todo de novo
//objeto jogador para guardar as informacoes
//as pilhas mostram apenas a ultima ou a primeira
//conta movimentos, e conta movimentos errados e andar para tras

//metodo de leitura e escrita no ficheiro - metodo separado
//public arraylist<jogador> - escrita
// try catch, se estiver vazio retorna uma lista vazio

//escrita- public void write(arraylist<jogador>, registos)

public class Carta_Daniel
{
	protected int numero;
	protected String naipe; 
	protected String cor;
	protected String rep; 

	public Carta_Daniel()
	{
		
	}
	
	public Carta_Daniel(int numero, String naipe)
	{
		this.numero = numero;
		this.naipe = naipe;
		
		if (this.naipe.equals("C") || this.naipe.equals("O"))
		{
			this.cor = "vermelho";
		}
		else
		{
			this.cor = "preto";
		}
		
		if (numero == 1) {
			this.rep = "A";
		}
		else if(numero == 11) {
			this.rep = "J";
		}
		else if(numero == 12) {
			this.rep = "Q";
		}
		else if(numero == 13) {
			this.rep = "K";
		}
		else {
			this.rep = String.valueOf(numero);
		}		
	}
	
	public int getNumero()
	{
		return numero;
	}

	public void setNumero(int numero)
	{
		this.numero = numero;
	}

	public String getNaipe()
	{
		return naipe;
	}

	public void setNaipe(String naipe)
	{
		this.naipe = naipe;
	}

	public String getCor()
	{
		return cor;
	}

	public void setCor(String cor)
	{
		this.cor = cor;
	}

	public String getRep()
	{
		return rep;
	}

	public void setRep(String rep)
	{
		this.rep = rep;
	}

	public String toString() {
		if (numero != 10) {
			return "-----\n" + "| "+ rep + " |\n" + "| "+ naipe + " |\n" + "-----";
		}
		else {
			return "-----\n" + "| "+ rep + "|\n" + "| "+ naipe + " |\n" + "-----";
		}
	}
	
	public String cartaOculta()
	{
		return "-----\n" + "|   |\n" + "|   |\n" + "-----";
	}
	
	public boolean isimmediategreaterthan(Carta_Daniel outracarta){
		if (this.numero == outracarta.numero + 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isimmediatesmallerthan(Carta_Daniel outracarta){
		if (this.numero == outracarta.numero - 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean compareNaipe(Carta_Daniel outraCarta)
	{
		if (this.getNaipe() == outraCarta.getNaipe()){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean compareCor(Carta_Daniel outraCarta)
	{
		if (this.getCor() == outraCarta.getCor()){
			return true;
		}
		else {
			return false;
		}
	}

	//passar para uma pilha
	/*public static ArrayList<Carta> Baralho() {
		String[] naipes = {"O", "C", "E", "P"};
		int[] representation = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		int counter = 0;
		for(int x = 0; x < naipes.length; x++){
			for (int y = 0; y < representation.length; y ++){
				cartas.add(new Carta(representation[y], naipes[x]));		
				counter ++;
			}
		}
		
		ArrayList<Carta> baralho = new ArrayList<Carta>();
		
		for (int i = 0; i<52; i++) {
			int randomnum = (int)(Math.random()*cartas.size());
			baralho.add(cartas.get(randomnum));
			cartas.remove(randomnum);
		}		
		return baralho;
	}
	*/
	/*
	public static void main(String arg[])
	{
	ArrayList<Carta> baralho = Baralho();
	/*for(int i = 0; i < baralho.size(); i++){
		System.out.println(baralho.get(i));	
	}
	
	//inicio do jogo
	
	ArrayList<Carta> parm1 = new ArrayList<Carta>(0);
	ArrayList<Carta> parm2 = new ArrayList<Carta>(0);
	ArrayList<Carta> parm3 = new ArrayList<Carta>(0);
	ArrayList<Carta> parm4 = new ArrayList<Carta>(0);
	
	ArrayList<Carta> ptra1 = new ArrayList<Carta>(1);
	ptra1.add(baralho.get(0));
	baralho.remove(0);
	ArrayList<Carta> ptra2 = new ArrayList<Carta>(2);
	Collections.addAll(ptra2, baralho.get(0), baralho.get(1));
	baralho.remove(0);
	baralho.remove(0);
	ArrayList<Carta> ptra3 = new ArrayList<Carta>(3);
	Collections.addAll(ptra3, baralho.get(0), baralho.get(1), baralho.get(2));
	baralho.remove(0);
	baralho.remove(0);
	baralho.remove(0);	
	ArrayList<Carta> ptra4 = new ArrayList<Carta>(4);
	Collections.addAll(ptra4, baralho.get(0), baralho.get(1), baralho.get(2), baralho.get(3));
	baralho.remove(0);
	baralho.remove(0);
	baralho.remove(0);
	baralho.remove(0);
	ArrayList<Carta> ptra5 = new ArrayList<Carta>(5);
	Collections.addAll(ptra5, baralho.get(0), baralho.get(1), baralho.get(2), baralho.get(3), baralho.get(4));
	baralho.remove(0);
	baralho.remove(0);
	baralho.remove(0);
	baralho.remove(0);
	baralho.remove(0);
	ArrayList<Carta> ptra6 = new ArrayList<Carta>(6);
	Collections.addAll(ptra6, baralho.get(0), baralho.get(1), baralho.get(2), baralho.get(3), baralho.get(4), baralho.get(5));
	baralho.remove(0);
	baralho.remove(0);
	baralho.remove(0);
	baralho.remove(0);
	baralho.remove(0);
	baralho.remove(0);
	ArrayList<Carta> ptra7 = new ArrayList<Carta>(7);
	Collections.addAll(ptra7, baralho.get(0), baralho.get(1), baralho.get(2), baralho.get(3), baralho.get(4), baralho.get(5), baralho.get(6));
	baralho.remove(0);
	baralho.remove(0);
	baralho.remove(0);
	baralho.remove(0);
	baralho.remove(0);
	baralho.remove(0);
	baralho.remove(0);
	
	ArrayList<Carta> naoutilizado1 = new ArrayList<Carta>();
	ArrayList<Carta> naoutilizado2 = new ArrayList<Carta>();
	
	}*/
}