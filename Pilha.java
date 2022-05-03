package segundo;

import java.io.Serializable;
import java.util.*;
//Daniel Vieira uc:2019231996 e S�rgio Rodrigues uc:2019232338
public class Pilha implements Serializable
{
	private ArrayList<Carta> pilha;

	public Pilha()
	{
		ArrayList<Carta> pilha = new ArrayList<Carta>();
		this.pilha = pilha;
	}

	public ArrayList<Carta> addCarta(Carta carta)
	{
		this.pilha.add(carta);
		return this.pilha;
	}

	public ArrayList<Carta> removeCarta(Carta carta)
	{
		this.pilha.remove(carta);
		return this.pilha;
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
		String[] naipes = { "O", "C", "E", "P" };
		String[] representation = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

		ArrayList<Carta> cartas = new ArrayList<Carta>();
		int counter = 0;
		for (int x = 0; x < naipes.length; x++)
		{
			for (int y = 0; y < representation.length; y++)
			{
				cartas.add(new Carta(representation[y], naipes[x]));
				counter++;
			}
		}
		this.pilha = cartas;
		return this;
	}
}
