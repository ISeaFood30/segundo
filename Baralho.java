package segundo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baralho
{
	private ArrayList<Carta_Daniel> baralho;
	public Baralho()
	{
		ArrayList<Carta_Daniel> baralho = new ArrayList<Carta_Daniel>();
		
		ArrayList<String> reps = new ArrayList<String>();
		reps.add("A");
		reps.add("2");
		reps.add("3");
		reps.add("4");
		reps.add("5");
		reps.add("6");
		reps.add("7");
		reps.add("8");
		reps.add("9");
		reps.add("10");
		reps.add("J");
		reps.add("Q");
		reps.add("K");

		ArrayList<String> naipes = new ArrayList<String>();
		naipes.add("E");
		naipes.add("P");
		naipes.add("O");
		naipes.add("C");

		for (int i = 0; i < reps.size(); i++)
		{
			for (int j = 0; j < naipes.size(); j++)
			{
				Carta_Daniel carta_Daniel = new Carta_Daniel(reps.get(i), naipes.get(j));
				baralho.add(carta_Daniel);
			}
		}
		this.baralho = baralho;
	}

	public ArrayList<Carta_Daniel> addBaralho(Carta_Daniel carta_Daniel)
	{
		this.baralho.add(carta_Daniel);
		return baralho;
	}
	
	public ArrayList<Carta_Daniel> removeBaralho(Carta_Daniel carta_Daniel)
	{
		this.baralho.remove(carta_Daniel);
		return baralho;
	}
	
	
	public ArrayList<Carta_Daniel> Baralhar()
	{
		List<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < this.baralho.size(); i++)
		{
			indices.add(i);
		}
		Collections.shuffle(indices);
		for (int i = 0; i < this.baralho.size(); i++)
		{
			this.baralho.set(i, baralho.get(indices.get(i)));
		}
		
		return baralho;
	}

	public int getTamanho()
	{
		return this.baralho.size();
	}

	public ArrayList<Carta_Daniel> getBaralho()
	{
		return baralho;
	}

	public void setBaralho(ArrayList<Carta_Daniel> baralho)
	{
		this.baralho = baralho;
	}
	
	public void printBaralho()
	{
		for (int j = 0; j < this.baralho.size(); j++)
		{
			this.baralho.get(j).toString();
		}
	}
	
}
