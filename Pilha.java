package segundo;

import java.io.Serializable;
import java.util.*;
//ha aqui metodos que nao faz sentido darem return, depois temos de ver isto
public class Pilha implements Serializable
{
	private ArrayList<Carta> pilha;

	public Pilha() // pilha de transição, desde a 1 à 7
	{
		ArrayList<Carta> pilha = new ArrayList<Carta>();
		this.pilha = pilha;
	}
	
	public  ArrayList<Carta> addCarta(Carta carta)
	{
		this.pilha.add(carta);
		return this.pilha;
	}
	
	public ArrayList<Carta> addCP(Pilha pil_destino)
	{
		Carta carta = this.pilha.get(this.pilha.size()-1);
		return pil_destino.addCarta(carta);
	}

	public  ArrayList<Carta> removeCarta(Carta carta)
	{
		this.pilha.remove(carta);
		return this.pilha;
	}
	
	
	public ArrayList<Carta> addArmazem(ArrayList<Carta> pilhaA, Carta carta)
	{
		this.pilha = pilhaA;
		if (this.pilha.size() == 0 && carta.getRep() == "A") // o Às tem de ser a primeira nestas pilhas de
																// armazenamento
		{
			this.pilha.add(carta);
		}
		else if (this.pilha.size() > 0 && carta.getNaipe() == this.pilha.get(this.pilha.size() - 1).getNaipe()
				&& carta.getValor() - this.pilha.get(this.pilha.size() - 1).getValor() == 1)
		{
			this.pilha.add(carta);
		}
		else
		{
			System.out.println("Essa operação não é permitida.");
		}
		return this.pilha;
	}
	
	
	public void printPilha() // dá para fazer o printo na inicialização do jogo
	{ // usado apenas para teste
		for (int i = 0; i <= (this.pilha).size() - 1; i++)
		{
			System.out.println(this.pilha.get(i).toString());
		}
		return;
	}

	public ArrayList<Carta> getPilha()
	{
		return this.pilha;
	}
	
	
	public void setPilha(ArrayList<Carta> pilha)
	{
		this.pilha = pilha;
	}

	public void Baralhar()
	{
		Collections.shuffle(this.pilha);
	}
	
	public int Size()
	{
		return this.pilha.size();
	}
	
	public Pilha criaBaralho() 
	{
		String[] naipes = {"O", "C", "E", "P"};
		String[] representation = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		for(int x = 0; x < naipes.length; x++)
		{
			for (int y = 0; y < representation.length; y ++)
			{
				cartas.add(new Carta(representation[y], naipes[x]));		
			}
		}
		this.pilha = cartas;
		return this;
	}

}
