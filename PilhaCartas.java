package segundo;
//iniciado pelo Sérgio
import java.util.Random;
import java.util.ArrayList;

public class PilhaCartas
{
	private ArrayList<Carta_Daniel> baralho;
	
	private ArrayList<Carta_Daniel> pilhaT;
	private int indiceT;
	
	private ArrayList<Carta_Daniel> pilhaA;
	private String naipePilhaA;
	
	private ArrayList<Carta_Daniel> pilhaN;
	
	private int num = -1;
	private char type;
	Random random = new Random();

	public PilhaCartas(ArrayList<Carta_Daniel> baralho, int indiceT) // pilha de transição, desde a 1 à 7
	{
		// o baralho que vem como argumento deve vir ja baralhado
		this.baralho = baralho;
		ArrayList<Carta_Daniel> bar = baralho;
		ArrayList<Carta_Daniel> pilhaT = new ArrayList<Carta_Daniel>();
		this.indiceT = indiceT;
		Carta_Daniel carta_Daniel;
		
		for (int i = 0; i < this.indiceT; i++)
		{
			int teste1 = random.nextInt(bar.size());
			carta_Daniel = bar.get(teste1);
			pilhaT.add(carta_Daniel);
			bar.remove(teste1);
			
		}
		this.baralho = bar;
		this.pilhaT = pilhaT;
	}

	public PilhaCartas(String naipe) // pilha de armazenamento
	{
		this.pilhaA = new ArrayList<Carta_Daniel>();
		this.naipePilhaA = naipe;
	}
	
	public PilhaCartas(Baralho baralho) // pilha de cartas não usadas
	{
		this.pilhaN = baralho.getBaralho();
	}	

	public ArrayList<Carta_Daniel> getBaralhoResto()
	{
		return this.baralho;
	}
	
	// estes prints que vêm a seguir não sei se serão usados realmente
	public void printPilhaT() // dá para fazer o printo na inicialização do jogo
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

	public ArrayList<Carta_Daniel> addArmazem(Carta_Daniel carta_Daniel)
	{
		if (this.pilhaA.size() == 0 && carta_Daniel.getRep() == "A") // o Às tem de ser a primeira nestas pilhas de
																// armazenamento
		{
			this.pilhaA.add(carta_Daniel);
		}
		else if (this.pilhaA.size() > 0 && carta_Daniel.getNaipe() == this.naipePilhaA
				&& carta_Daniel.getValor() - this.pilhaA.get(this.pilhaA.size() - 1).getValor() == 1)
		{
			this.pilhaA.add(carta_Daniel);
		}
		else
		{
			System.out.println("Essa operação não é permitida.");
		}
		return this.pilhaA;
	}

	public void printPilhaA() // print da pilha de armazenamento
	{
		this.pilhaA.get(this.pilhaA.size() - 1).toString();
		return;
	}
	
	public void printPilhaN() // print da pilha de não usadas
	{
		this.pilhaN.get(this.pilhaN.size() - 1).toString();
		return;
	}

	
	public ArrayList<Carta_Daniel> getPilhaT()
	{
		return pilhaT;
	}

	public void setPilhaT(ArrayList<Carta_Daniel> pilhaT)
	{
		this.pilhaT = pilhaT;
	}

	public ArrayList<Carta_Daniel> getPilhaA()
	{
		return pilhaA;
	}

	public void setPilhaA(ArrayList<Carta_Daniel> pilhaA)
	{
		this.pilhaA = pilhaA;
	}

	public ArrayList<Carta_Daniel> getPilhaN()
	{
		return pilhaN;
	}

	public void setPilhaN(ArrayList<Carta_Daniel> pilhaN)
	{
		this.pilhaN = pilhaN;
	}
}
