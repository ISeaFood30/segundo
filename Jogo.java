package segundo;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Jogo
{
	private ArrayList<Carta> baralho;
	private Pilha[] pilhasT;
	private Pilha[] pilhasA;

	public Jogo() // vai criar um jogo
	{
		this.baralho = (new Baralho()).Baralhar();
		this.pilhasT = new Pilha[7]; // o jogo tem 7 pilhas de transição
		this.pilhasA = new Pilha[4]; // 4 pilhas de armazenamento
	}

	public void start()
	{
		Random random = new Random();
		for (int i = 0; i < pilhasT.length; i++)
		{
			Pilha help = new Pilha();
			for (int j = 0; j < i + 1; j++)
			{
				int test = random.nextInt(baralho.size());
				Carta carta = this.baralho.get(test);
				help.addCarta(carta);
				this.baralho.remove(test);
			}
			pilhasT[i] = help;
		}
	}

	public void representJogoInit()
	{
		String[][] ecra = new String[8 + 7 * 4][7];
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

		ecra[1][0] = "----- ";
		ArrayList<Carta> resto = this.baralho;
		if (resto.get(resto.size() - 1).getRep() == "10")
		{
			ecra[2][0] = "| " + resto.get(resto.size() - 1).getRep() + "| ";
		}
		else
		{
			ecra[2][0] = "| " + resto.get(resto.size() - 1).getRep() + " | ";
		}
		ecra[3][0] = "| " + resto.get(resto.size() - 1).getNaipe() + " | ";
		ecra[4][0] = "----- ";
		// pilhas de transição

		for (int j = 0; j < 7; j++)
		{
			for (int i = 0; i < (this.pilhasT[j].getPilha()).size(); i++)
			{
				int a = 8 + i * 4;
				if (i == this.pilhasT[j].getPilha().size() - 1)
				{
					ecra[a][j] = "----- ";
					ArrayList<Carta> c = this.pilhasT[j].getPilha();
					if (c.get(c.size() - 1).getRep() == "10")
					{
						ecra[a + 1][j] = "| " + c.get(c.size() - 1).getRep() + "| ";
					}
					else
					{
						ecra[a + 1][j] = "| " + c.get(c.size() - 1).getRep() + " | ";
					}
					ecra[a + 2][j] = "| " + c.get(c.size() - 1).getNaipe() + " | ";
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

	public void representJogo()
	{
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

		ecra[1][1] = "----- ";
		ArrayList<Carta> resto = this.baralho;
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

		ecra[1][0] = "----- ";
		if (resto.get(resto.size() - 2).getRep() == "10")
		{
			ecra[2][0] = "| " + resto.get(resto.size() - 2).getRep() + "| ";
		}
		else
		{
			ecra[2][0] = "| " + resto.get(resto.size() - 2).getRep() + " | ";
		}
		ecra[3][0] = "| " + resto.get(resto.size() - 2).getNaipe() + " | ";
		ecra[4][0] = "----- ";

		// pilhas de armazenamento
		for (int k = 0; k < 4; k++)
		{
			if (this.pilhasT[k] == null && this.pilhasT[k].getPilha().isEmpty() == false)
			{
				ecra[1][k] = "----- ";
				ArrayList<Carta> arm = this.pilhasA[k].getPilha();
				if (arm.get(arm.size() - 1).getRep() == "10")
				{
					ecra[2][k] = "| " + arm.get(arm.size() - 1).getRep() + "| ";
				}
				else
				{
					ecra[2][k] = "| " + arm.get(arm.size() - 1).getRep() + " | ";
				}
				ecra[3][k] = "| " + arm.get(arm.size() - 1).getNaipe() + " | ";
				ecra[4][k] = "----- ";
			}
		}

		// pilhas de transição

		for (int j = 0; j < 7; j++)
		{
			for (int i = 0; i < (this.pilhasT[j].getPilha()).size(); i++)
			{
				int a = 8 + i * 4;
				if (i == this.pilhasT[j].getPilha().size() - 1)
				{
					ecra[a][j] = "----- ";
					ArrayList<Carta> c = this.pilhasT[j].getPilha();
					if (c.get(c.size() - 1).getRep() == "10")
					{
						ecra[a + 1][j] = "| " + c.get(c.size() - 1).getRep() + "| ";
					}
					else
					{
						ecra[a + 1][j] = "| " + c.get(c.size() - 1).getRep() + " | ";
					}
					ecra[a + 2][j] = "| " + c.get(c.size() - 1).getNaipe() + " | ";
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
