package segundo;

import java.util.Random;
import java.util.ArrayList;

public class PilhaCartas
{
	private ArrayList<Carta> baralho;
	
	private ArrayList<Carta> pilhaT;
	private int indiceT;
	
	private ArrayList<Carta> pilhaA;
	private String naipePilhaA;
	
	private ArrayList<Carta> pilhaN;
	
	private int num = -1;
	private char type;
	Random random = new Random();

	public PilhaCartas(ArrayList<Carta> baralho, int indiceT) // pilha de transi��o, desde a 1 � 7
	{
		// o baralho que vem como argumento deve vir ja baralhado
		this.baralho = baralho;
		ArrayList<Carta> bar = baralho;
		ArrayList<Carta> pilhaT = new ArrayList<Carta>();
		this.indiceT = indiceT;
		Carta carta;
		
		for (int i = 0; i < this.indiceT; i++)
		{
			int teste1 = random.nextInt(bar.size());
			carta = bar.get(teste1);
			pilhaT.add(carta);
			bar.remove(teste1);
			
		}
		this.baralho = bar;
		this.pilhaT = pilhaT;
	}

	public PilhaCartas(String naipe) // pilha de armazenamento
	{
		this.pilhaA = new ArrayList<Carta>();
		this.naipePilhaA = naipe;
	}
	
	public PilhaCartas(Baralho baralho) // pilha de cartas n�o usadas
	{
		this.pilhaN = baralho.getBaralho();
	}	

	public ArrayList<Carta> getBaralhoResto()
	{
		return this.baralho;
	}
	
	// estes prints que v�m a seguir n�o sei se ser�o usados realmente
	public void printPilhaT() // d� para fazer o printo na inicializa��o do jogo
	{
		for (int i = 0; i <= (this.pilhaT).size() - 1; i++)
		{
			if (i == (this.pilhaT).size() - 1)
			{
				this.pilhaT.get(i).toString();
			}
			else
			{
				this.pilhaT.get(i).cartaOculta();
			}
		}
		return;
	}

	public ArrayList<Carta> addArmazem(Carta carta)
	{
		if (this.pilhaA.size() == 0 && carta.getRep() == "A") // o �s tem de ser a primeira nestas pilhas de
																// armazenamento
		{
			this.pilhaA.add(carta);
		}
		else if (this.pilhaA.size() > 0 && carta.getNaipe() == this.naipePilhaA
				&& carta.getValor() - this.pilhaA.get(this.pilhaA.size() - 1).getValor() == 1)
		{
			this.pilhaA.add(carta);
		}
		else
		{
			System.out.println("Essa opera��o n�o � permitida.");
		}
		return this.pilhaA;
	}

	public void printPilhaA() // print da pilha de armazenamento
	{
		this.pilhaA.get(this.pilhaA.size() - 1).toString();
		return;
	}
	
	public void printPilhaN() // print da pilha de n�o usadas
	{
		this.pilhaN.get(this.pilhaN.size() - 1).toString();
		return;
	}

	
	public ArrayList<Carta> getPilhaT()
	{
		return pilhaT;
	}

	public void setPilhaT(ArrayList<Carta> pilhaT)
	{
		this.pilhaT = pilhaT;
	}

	public ArrayList<Carta> getPilhaA()
	{
		return pilhaA;
	}

	public void setPilhaA(ArrayList<Carta> pilhaA)
	{
		this.pilhaA = pilhaA;
	}

	public ArrayList<Carta> getPilhaN()
	{
		return pilhaN;
	}

	public void setPilhaN(ArrayList<Carta> pilhaN)
	{
		this.pilhaN = pilhaN;
	}
}
