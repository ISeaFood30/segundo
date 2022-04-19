package segundo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//idealmente nao conseguimos eliminar este objeto?? para mim parece desencessario
//ate porque o nosso baralho tem que ser dividido em 2 pilhas
public class Baralho
{
	private ArrayList<Carta> baralho;
	public Baralho()
	{
		ArrayList<Carta> baralho = new ArrayList<Carta>();
		
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
				Carta carta = new Carta(reps.get(i), naipes.get(j));
				baralho.add(carta);
			}
		}
		this.baralho = baralho;
	}

	public ArrayList<Carta> addBaralho(Carta carta)
	{
		this.baralho.add(carta);
		return baralho;
	}
	
	public ArrayList<Carta> removeBaralho(Carta carta)
	{
		this.baralho.remove(carta);
		return baralho;
	}
	
	
	public ArrayList<Carta> Baralhar()
	{
	
		Collections.shuffle(this.baralho);
	
		return this.baralho ;
	}

	public int getTamanho()
	{
		return this.baralho.size();
	}

	public ArrayList<Carta> getBaralho()
	{
		return baralho;
	}

	public void setBaralho(ArrayList<Carta> baralho)
	{
		this.baralho = baralho;
	}
	
	public void printBaralho()
	{
		for (int j = 0; j < this.baralho.size(); j++)
		{
			System.out.println(this.baralho.get(j).toString());
		}
	}
	
}
