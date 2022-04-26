package segundo;

import java.util.*;

public class Solitario
{

	public static void main(String[] args)
	{
		System.out.println("Seja bem-vindo ao Solitario. Por favor inicie sessao.");
		ArrayList<Jogador> registos = Jogador.read(); //temos de por as funcoes no sitio certo depois
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Insira o seu email: ");
		String email = sc.nextLine();
		
		System.out.println("Insira a sua password: ");
		String password = sc.nextLine();
		
		String nome;
				
		//verificar se esta nos registos
		boolean estanosregistos = false;
		Jogador jogadorAtual = new Jogador();
		if (!registos.isEmpty()) 
		{
			for (Jogador i : registos)
			{
				if (i.getEmail().equals(email)) //e se so tiver o mesmo mail e pass difernete?? mais uma excecao //problema com null pointer exception
				{
					if (i.getPass().equals(password))
					{
						//se existe nos registos vamos buscar
						jogadorAtual = i;
						estanosregistos = true;
					}
				}
				else
				{
					System.out.println("Não está nos registos. \nQual é o seu nome? ");
					nome = sc.nextLine();
					
					jogadorAtual = new Jogador(email, password);
					jogadorAtual.setNome(nome);					
				}
			}
		}
		else
		{
			System.out.println("Não está nos registos. \nQual é o seu nome? ");
			nome = sc.nextLine();
			
			jogadorAtual = new Jogador(email, password);
			jogadorAtual.setNome(nome);
		}

		Jogo3 jogo = new Jogo3();
		
		if (estanosregistos)
		{
			System.out.println("Seja bem vindo de volta, " + jogadorAtual.nome + ".");
			System.out.println("Vamos recarregar o seu ultimo jogo");	
			jogo.loadJogo(jogadorAtual);
			//sem registos isto vai dar erro. para efeitos de teste e normal. no fim se for preciso mudamos e pomos um trycatch aqui
		}
		else 
		{
			System.out.println("Seja bem vindo, " + jogadorAtual.nome + ".");
			System.out.println("Vamos comecar um novo jogo.");
			jogo.start();
		}
		jogo.representJogo();
		
		String jogada;
		do
		{
			jogada = jogo.Jogada();
			
			if (jogada.equals("P"))
			{
				jogo.passarCartas();
				jogo.representJogo();
			}
			
			else if (jogada.equals("M"))
			{
				System.out.println("Qual a pilha de origem? (se quiser tirar do baralho, escrever 'Baralho')");
				String origem = sc.nextLine();
				System.out.println("Qual a pilha de destino?");
				String destino = sc.nextLine();
				String tipo_M = destino.substring(0, 3);
				if (tipo_M.equals("Arm"))
				{
					jogo.moverCartasA(origem, destino);
					jogo.representJogo();
				}
				//ver esta coisa da Pil. se escrever PIL isto aceita tambem e nao estou a perceber porque
				else if (tipo_M.equals("Pil"))
				{
					int quantas_cartas = 1;
					if(origem.equals("Baralho") == false)
							{
								System.out.println("Quantas cartas quer mover?");
								quantas_cartas = sc.nextInt();
								sc.nextLine();
							}
					
					jogo.representJogo();
				}
				
				else 
				{
					System.out.println("Por favor inserir corretamente as indicações.");
					//colocar aqui um jogo.represent()??
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
			System.out.println(jogo.getContajogadas());
		}
		while (jogada.equals("T") == false);

		jogo.saveJogo(jogadorAtual, registos, estanosregistos);
		System.out.println("O jogo esta guardado.");		
		sc.close();
	}	
}
