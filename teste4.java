package segundo;

import java.util.ArrayList;
import java.util.Random;

public class teste4
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		Random random = new Random();

		Baralho bar = new Baralho();
		// bar.printBaralho();
		ArrayList<Carta> baralho = bar.Baralhar();
		for (int i = 0; i < baralho.size(); i++)
		{
			// System.out.println(baralho.get(i));
		}

		Pilha[] pilhasT = new Pilha[7]; // o jogo tem 7 pilhas de transição
		Pilha[] pilhasA = new Pilha[4]; // 4 pilhas de armazenamento

		// int test2 = random.nextInt(baralho.size());
		// System.out.println(test2);

		for (int i = 0; i < pilhasT.length; i++)
		{
			Pilha help = new Pilha();
			for (int j = 0; j < i + 1; j++)
			{
				int test = random.nextInt(baralho.size());
				Carta carta = baralho.get(test);
				help.addCarta(carta);
				baralho.remove(test);
				// System.out.println(carta.toString());
				// System.out.println("random" + test);
			}

			pilhasT[i] = help;
			//pilhasT[i].printPilha();
			//System.out.println("Outra");
			//System.out.println(baralho.size());
		}
		Jogo jogo = new Jogo();
		jogo.start();
		jogo.representJogo();

	}

}
