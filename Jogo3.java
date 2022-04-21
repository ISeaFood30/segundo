package segundo;

import java.util.*;
//criei para nao mexer no jogo que estava a funcionar. e ja nao me lembro se podia mexer no jogo2 ou nao
public class Jogo3
{
	private Pilha[] baralho;
	private Pilha[] pilhasT;
	private Pilha[] pilhasA;

	public Jogo3() 
	{
		this.baralho = new Pilha[2]; //2 montes de visualizaçao para o baralho
		this.pilhasT = new Pilha[7]; // o jogo tem 7 pilhas de transição
		this.pilhasA = new Pilha[4]; // 4 pilhas de armazenamento
	}

	public void start() //comeco do jogo
	{
		Pilha baralho = new Pilha().criaBaralho();
		baralho.Baralhar();
		for (Carta i:baralho.getPilha()) {
			i.setVisible(false);

			
		}
		for (int i = 0; i < pilhasT.length; i++)
		{
			Pilha help = new Pilha();
			for (int j = 0; j < i + 1; j++)
			{
				Carta carta = baralho.getPilha().get(j);
				help.addCarta(carta);
				baralho.getPilha().remove(carta);
			}
			pilhasT[i] = help;
			//para por as cartas visiveis ou nao, no inicio
			for (int iter = 0; iter < pilhasT[i].getPilha().size(); iter ++) 
			{
				if (iter == pilhasT[i].getPilha().size()-1) 
				{
					pilhasT[i].getPilha().get(iter).setVisible(true);
				}
				else 
				{
					pilhasT[i].getPilha().get(iter).setVisible(false);
				}
			}
		this.baralho[0] = baralho;	
		}
	}
	
	//vamos precisar eventualmente de um jogo.load() e um jogo.save()

	public void representJogo()
	{
		//verificacao do tamanho maximo para criacao do ecrã
		int cmax = this.pilhasT[0].getPilha().size();
		for (int i = 0; i< 7;i++)
		{
			if (this.pilhasT[i].getPilha().size()>cmax)
				{
				cmax = this.pilhasT[i].getPilha().size();
				}
		}
		
		String[][] ecra = new String[8 + cmax * 4][7];
		for (int i = 0; i < ecra.length; i++)
		{
			for (int j = 0; j < ecra[i].length; j++)
			{
				ecra[i][j] = "      ";
			}
		}
		ecra[0][0] = "Monte ";
		ecra[0][1] = "Disp. ";

		for (int i = 3; i < 7; i++)
		{
			ecra[0][i] = "Arm-" + (i - 2) + " ";
		}

		for (int i = 0; i < 7; i++)
		{
			ecra[7][i] = "Pil-" + (i + 1) + " ";
		}

		//representação dos baralhos		
		//1o monte
		//estamos a impor que este monte do baralho nao se consgue ver
		if (baralho[0] != null)
		{
			ecra[1][0] = "----- ";
			ecra[2][0] = "|   | ";
			ecra[3][0] = "|   | ";			
			ecra[4][0] = "----- ";
		}
		
		//2º monte
		if (baralho[1] != null) 
		{
			ArrayList<Carta> resto = this.baralho[1].getPilha();
			//estou a impor que a ultima carta neste monte tem que ser visivel
			resto.get(resto.size() - 1).setVisible(true);
			ecra[1][1] = "----- ";
			if (resto.get(resto.size() - 1).getRep() == "10")
			{
				ecra[2][1] = "| " + resto.get(resto.size() - 1).getRep() + "| ";
			}
			else
			{
				ecra[2][1] = "| " + resto.get(resto.size() - 1).getRep() + " | ";
			}
			ecra[3][1] = "| " + resto.get(resto.size() - 1).getNaipe() + " | ";
			ecra[4][1] = "----- ";

			
		}
	
		// pilhas de armazenamento
		//so precisamos de representar a ultima carta, todas as outras estao escondidas
		for (int k = 0; k < 4; k++)
		{
			if (this.pilhasT[k] != null && this.pilhasT[k].getPilha().isEmpty() != false)
			{
				ecra[1][3+k] = "----- ";
				ArrayList<Carta> arm = this.pilhasA[k].getPilha();
				if (arm.get(arm.size() - 1).getRep() == "10")
				{
					ecra[2][3+k] = "| " + arm.get(arm.size() - 1).getRep() + "| ";
				}
				else
				{
					ecra[2][3+k] = "| " + arm.get(arm.size() - 1).getRep() + " | ";
				}
				ecra[3][3+k] = "| " + arm.get(arm.size() - 1).getNaipe() + " | ";
				ecra[4][3+k] = "----- ";
			}
		}

		// pilhas de transição
		// precisamos de representar todas, por isso temos de ter cuidado de sao visible ou nao
		for (int j = 0; j < 7; j++)
		{
			for (int i = 0; i < (this.pilhasT[j].getPilha()).size(); i++)
			{
				int a = 8 + i * 4;
				//System.out.println(this.pilhasT[j].getPilha().get(i).isVisible());
				if (this.pilhasT[j].getPilha().get(i).isVisible())
				{
					ecra[a][j] = "----- ";
					if (this.pilhasT[j].getPilha().get(i).getRep() == "10")
					{
						ecra[a + 1][j] = "| " + this.pilhasT[j].getPilha().get(i).getRep() + "| ";
					}
					else
					{
						ecra[a + 1][j] = "| " + this.pilhasT[j].getPilha().get(i).getRep() + " | ";
					}
					ecra[a + 2][j] = "| " + this.pilhasT[j].getPilha().get(i).getNaipe() + " | ";
					ecra[a + 3][j] = "----- ";
				}
				else
				{
					ecra[a][j] = "----- ";
					ecra[a + 1][j] = "|   | ";
					ecra[a + 2][j] = "|   | ";
					ecra[a + 3][j] = "----- ";
				}
			}
		}

		for (int i = 0; i < ecra.length; i++)
		{
			for (int j = 0; j < ecra[i].length; j++)
			{
				System.out.print(ecra[i][j]);
			}
			System.out.println("");
		}
	}
}
