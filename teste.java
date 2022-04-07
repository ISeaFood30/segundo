package segundo;

import java.util.Random;

public class teste
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Carta_Daniel carta1;
		carta1 = new Carta_Daniel("9", "P");
		//carta1.toString();
		// System.out.println(carta1.getCor());
		
		//Carta carta2 = new Carta();
		//carta2.toString();
		//carta2.cartaOculta();
		
		//System.out.println(carta1.menorValor(carta2));
		
		String[] reps = {"A","K","Q","J","10","9","8","7","6","5","4","3","2"};
		String[] naipes = {"E","P","O","C"};
		
		Random random = new Random();
		int teste1 = random.nextInt(reps.length); // random entre 0 e reps.length(exclusive)
		//System.out.println(reps[teste1]);
		int teste2 = random.nextInt(naipes.length); 
		//System.out.println(naipes[teste2]);
		
		//PilhaCartas pilha = new PilhaCartas(4);
		//pilha.printPilhaT();
	}

}
