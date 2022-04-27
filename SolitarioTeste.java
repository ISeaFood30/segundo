package segundo;

import java.util.*;

public class SolitarioTeste
{

	public static void main(String[] args)
	{
		System.out.println("Seja bem-vindo ao Solitário. Por favor inicie sessão.");
		ArrayList<Jogador> registos = Jogador.read(); // temos de por as funcoes no sitio certo depois

		Scanner sc = new Scanner(System.in);

		System.out.println("Insira o seu email: ");
		String email = sc.nextLine();

		System.out.println("Insira a sua password: ");
		String password = sc.nextLine();

		String nome;

		// Jogador de teste
		// registos.add(new Jogador("potato", "banana", "daniel"));

		// verificar se esta nos registos
		boolean estanosregistos = false;
		Jogador jogadorAtual = new Jogador();
		if (!registos.isEmpty())
		{
			for (Jogador i : registos)
			{
				if (i.getEmail().equals(email))
				{
					if (i.getPass().equals(password))
					{
						// se existe nos registos vamos buscar
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

		Jogo4 jogo = new Jogo4();

		if (estanosregistos)
		{
			System.out.println("Seja bem vindo de volta, " + jogadorAtual.nome + ".");
			System.out.println("Vamos recarregar o seu ultimo jogo");
			jogo.loadJogo(jogadorAtual);
			// sem registos isto vai dar erro. para efeitos de teste e normal. no fim se for preciso mudamos e pomos um
			// trycatch aqui
		}
		else
		{
			System.out.println("Seja bem vindo, " + jogadorAtual.nome + ".");
			System.out.println("Vamos comecar um novo jogo.");
			jogo.start();
		}
		jogo.representJogo();

		boolean fim_jogo = false;

		String jogada;
		do
		{
			jogada = jogo.Jogada();

			if (jogada.equals("P"))
			{
				jogo.passarCartas();
				fim_jogo = jogo.endJogo();
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
					fim_jogo = jogo.endJogo();
					jogo.representJogo();
				}
				// ver esta coisa da Pil. se escrever PIL isto aceita tambem e nao estou a perceber porque
				else if (tipo_M.equals("Pil"))
				{
					// int quantas_cartas = 1;
					// if(origem.equals("Baralho") == false)
					// {
					// System.out.println("Quantas cartas quer mover?");
					// quantas_cartas = sc.nextInt();
					// sc.nextLine();
					// }

					// jogo.moverCartasT(origem, destino, quantas_cartas);//quando da erro, ou seja vai para o catch no
					// movercartasT, ele da represent na mesma,
					jogo.moverCartasT(origem, destino);
					fim_jogo = jogo.endJogo();
					jogo.representJogo();
				}

				else
				{
					System.out.println("Por favor inserir corretamente as indicações.");
					// colocar aqui um jogo.represent()??
				}

			}

			else if (jogada.equals("R"))
			{
				jogo.Rebobinar();
				jogo.representJogo();
				fim_jogo = jogo.endJogo();
			}

			else if (jogada.equals("T"))
			{
				fim_jogo = true;
			}

			else
			{
				System.out.println("Por favor inserir corretamente as indicações.");
			}

		}
		while (fim_jogo == false);

		System.out.println("Aguarde enquanto o jogo guarda.");
		jogo.saveJogo(jogadorAtual, registos, estanosregistos);
		System.out.println("O jogo está guardado.");
		sc.close();
	}
}
