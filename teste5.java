package segundo;
import java.util.*;
public class teste5
{
//vamos ter de ter cuidado com letras maiusculas e minusculas tambem
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		Jogo3 jogo = new Jogo3();
		jogo.start();
		jogo.representJogo();	
		
		Pilha[] este = jogo.getBaralho();
		//este[0].printPilha();
		//String jogada = jogo.Jogada();
		//String jogada = jogo.getJogada();
		//String jogada = "M";
		String jogada;
		do
		{
			jogada = jogo.Jogada();
			
			if (jogada.equals("P"))
			{
				jogo.passarCartas();
				jogo.representJogo();
			}
			
			//System.out.println("mverkifmverg");
			//este[1].printPilha();
			//System.out.println("mverkifmverg");
			//este[0].printPilha();
			
			//String destino = "Pil-4";
			//int f = Character.getNumericValue(destino.charAt(destino.length()-1));
			//System.out.println (f)
			
			else if (jogada.equals("M"))
			{
				System.out.println("Qual a pilha de origem? (se quiser tirar do baralho, escrever 'Baralho')");
				String origem = scan.nextLine();
				System.out.println("Qual a pilha de destino?");
				String destino = scan.nextLine();
				String tipo_M = destino.substring(0, 3);
				//System.out.println(tipo);
				if (tipo_M.equals("Arm"))
				{
					jogo.moverCartasA(origem, destino);
					jogo.representJogo();
				}
				
				else if (tipo_M.equals("Pil"))
				{
					int quantas_cartas = 1;
					if(origem.equals("Baralho") == false)
							{
								System.out.println("Quantas cartas quer mover?");
								quantas_cartas = sc.nextInt();
								sc.nextLine();
							}
					
					jogo.moverCartasT(origem, destino, quantas_cartas);
					jogo.representJogo();
				}
				
				else 
				{
					System.out.println("Por favor inserir corretamente as indicações.");
				}
				
			}
			
			else if (jogada.equals("R"))
			{
				jogo.Rebobinar();
				jogo.representJogo();
			}
			
			else if (jogada.equals("T") == false)
			{
				System.out.println("Por favor inserir corretamente as indicações.");
			}
			
		}
		while (jogada.equals("T") == false);
		
	}

}
