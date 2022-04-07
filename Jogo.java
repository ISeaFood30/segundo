package segundo;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Jogo
{
	private ArrayList<Carta> baralho;
	private PilhaCartas[] pilhasT;
	private PilhaCartas[] pilhasA;

	public Jogo() // vai criar um jogo
	{
		this.baralho = (new Baralho()).Baralhar();
		this.pilhasT = new PilhaCartas[7]; // o jogo tem 7 pilhas de transição
		this.pilhasA = new PilhaCartas[4]; // 4 pilhas de armazenamento
	}

	public void init()
	{
		for (int i = 0; i < 7; i++)
		{
			this.pilhasT[i] = new PilhaCartas(this.baralho, i + 1);
			this.baralho = this.pilhasT[i].getBaralhoResto();
		}

		ArrayList<String> naipes = new ArrayList<String>();
		naipes.add("E");
		naipes.add("P");
		naipes.add("O");
		naipes.add("C");
		for (int i = 0; i < 4; i++)
		{
			this.pilhasA[i] = new PilhaCartas(naipes.get(i));
		}
	}

	public void representJogoInit()
	{
		String[][] ecra = new String[30][7];
		ecra[0][0] = "Monte";
		ecra[0][1] = "Disp.";
		ecra[0][2] = "     ";
		for (int i = 3; i < 7; i++)
		{
			ecra[0][i] = "Arm-" + (i - 2);
		}

		for (int i = 0; i < 7; i++)
		{
			ecra[3][i] = "Pil-" + (i + 1);
		}

		ArrayList<Carta> resto = this.pilhasT[6].getBaralhoResto();
		ecra[0][1] = resto.get(resto.size() - 1).toString();

		// pilhas de transição
		for (int j = 0; j < ecra.length; j++)
		{
			for (int i = 0; i < ecra[i].length; i++)
			{
				if (i == j)
				{
					ecra[j][i] = (this.pilhasT[j].getPilhaT()).get(j).toString();
				}
				else if (i < j)
				{
					ecra[j][i] = (this.pilhasT[j].getPilhaT()).get(j).cartaOculta();
				}
				else
					ecra[j][i] = "";
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
