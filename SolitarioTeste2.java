package segundo;

import java.util.*;

public class SolitarioTeste2
{

	public static void main(String[] args)
	{	
		Scanner sc = new Scanner(System.in);
		boolean fechaprograma = false;
		boolean terminarsessao = false;

		System.out.println("Seja bem-vindo ao Solit�rio.");
		System.out.println("Por favor inicie sess�o.");
		ArrayList<Jogador> registos = Jogador.read(); // temos de por as funcoes no sitio certo depois
		
		System.out.println("Insira o seu email: ");
		String email = sc.nextLine();

		System.out.println("Insira a sua password: ");
		String password = sc.nextLine();

		String nome;

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
			}
				
			if(!estanosregistos)
			{
				System.out.println("N�o est� nos registos. \nQual � o seu nome? ");
				nome = sc.nextLine();

				jogadorAtual = new Jogador(email, password);
				jogadorAtual.setNome(nome);
			}
		}
		else
		{
			System.out.println("N�o est� nos registos. \nQual � o seu nome? ");
			nome = sc.nextLine();
			
			jogadorAtual = new Jogador(email, password);
			jogadorAtual.setNome(nome);
		}
		terminarsessao = false;
		
		Jogo4 jogo = new Jogo4();

		if (estanosregistos)
		{
			System.out.println("Seja bem vindo de volta, " + jogadorAtual.getNome() + ".");
			//mostrar media de jogadas por vitoria
			
			if (!jogadorAtual.getVitorias().isEmpty())
			{
				double media = Jogador.average(jogadorAtual.getVitorias());
				System.out.println("A sua m�dia de jogadas por vit�ria � " + media);
			}
			else
			{
				System.out.println("N�o tem nenhuma vit�ria registada.");
			}
				
			boolean sai = false;	
			do 
			{
				System.out.println("O que deseja fazer? Retomar o seu jogo anterior, come�ar um novo jogo ou terminar sess�o? \nR ->Retomar jogo | N -> Novo jogo | T -> Terminar");
				String fazer = sc.nextLine();
				fazer.toUpperCase();
				if (fazer.equals("N"))
				{
					System.out.println("Vamos comecar um novo jogo.");
					jogo.start();
					jogo.representJogo();
					sai = true;
				}
				else if (fazer.equals("T"))
				{
					terminarsessao = true;
					sai = true;
				}
				else if (fazer.equals("R"))
				{
					System.out.println("Vamos retomar o seu �ltimo jogo.");
					jogo.loadJogo(jogadorAtual);
					jogo.representJogo();
					sai = true;
				}
				else
				{
					System.out.println("N�o escolheu uma op��o poss�vel. Tente outra vez");
				}
			}
			while (!sai);				
		}
		else
		{
			boolean sai = false;
			do 
			{
				System.out.println("O que deseja fazer? Come�ar um novo jogo ou terminar sess�o? \nN -> Novo jogo | T -> Terminar");
				String fazer = sc.nextLine();
				fazer.toUpperCase();
				if (fazer.equals("N"))
				{
					System.out.println("Vamos comecar um novo jogo.");
					jogo.start();
					jogo.representJogo();
					sai = true;
				}
				else if (fazer.equals("T"))
				{
					terminarsessao = true;
					sai = true;
				}
				else
				{
					System.out.println("N�o escolheu uma op��o poss�vel. Tente outra vez");
				}
			}
			while (!sai);
		}
		
		do
		{		
			//login
			if (terminarsessao)
			{
				System.out.println("Por favor inicie sess�o.");
				registos = Jogador.read(); // temos de por as funcoes no sitio certo depois
				
				System.out.println("Insira o seu email: ");
				email = sc.nextLine();

				System.out.println("Insira a sua password: ");
				password = sc.nextLine();

				// verificar se esta nos registos
				estanosregistos = false;
				jogadorAtual = new Jogador();
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
					}
						
					if(!estanosregistos)
					{
						System.out.println("N�o est� nos registos. \nQual � o seu nome? ");
						nome = sc.nextLine();

						jogadorAtual = new Jogador(email, password);
						jogadorAtual.setNome(nome);
					}
				}
				else
				{
					System.out.println("N�o est� nos registos. \nQual � o seu nome? ");
					nome = sc.nextLine();
					
					jogadorAtual = new Jogador(email, password);
					jogadorAtual.setNome(nome);
				}
				
				jogo = new Jogo4();

				if (estanosregistos)
				{
					System.out.println("Seja bem vindo de volta, " + jogadorAtual.getNome() + ".");
					//mostrar media de jogadas por vitoria
					
					if (!jogadorAtual.getVitorias().isEmpty())
					{
						double media = Jogador.average(jogadorAtual.getVitorias());
						System.out.println("A sua m�dia de jogadas por vit�ria � " + media);
					}
					else
					{
						System.out.println("N�o tem nenhuma vit�ria registada.");
					}
						
					boolean sai = false;	
					do 
					{
						System.out.println("O que deseja fazer? Retomar o seu jogo anterior, come�ar um novo jogo ou terminar sess�o? \nR ->Retomar jogo | N -> Novo jogo | T -> Terminar");
						String fazer = sc.nextLine();
						fazer.toUpperCase();
						if (fazer.equals("N"))
						{
							System.out.println("Vamos comecar um novo jogo.");
							jogo.start();
							jogo.representJogo();
							sai = true;
						}
						else if (fazer.equals("T"))
						{
							terminarsessao = true;
							sai = true;
						}
						else if (fazer.equals("R"))
						{
							System.out.println("Vamos retomar o seu �ltimo jogo.");
							jogo.loadJogo(jogadorAtual);
							jogo.representJogo();
							sai = true;
						}
						else
						{
							System.out.println("N�o escolheu uma op��o poss�vel. Tente outra vez");
						}
					}
					while (!sai);				
				}
				else
				{
					boolean sai = false;
					do 
					{
						System.out.println("O que deseja fazer? Come�ar um novo jogo ou terminar sess�o? \nN -> Novo jogo | T -> Terminar");
						String fazer = sc.nextLine();
						fazer.toUpperCase();
						if (fazer.equals("N"))
						{
							System.out.println("Vamos comecar um novo jogo.");
							jogo.start();
							jogo.representJogo();
							sai = true;
						}
						else if (fazer.equals("T"))
						{
							terminarsessao = true;
							sai = true;
						}
						else
						{
							System.out.println("N�o escolheu uma op��o poss�vel. Tente outra vez");
						}
					}
					while (!sai);
				}

			}

			boolean fim_jogo = false;
			//inicio da parte de jogar
			String jogada;
			do
			{
				jogada = jogo.Jogada();

				if (jogada.equals("P"))
				{
					jogo.passarCartas();
					fim_jogo = jogo.jogoWin();
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
						fim_jogo = jogo.jogoWin();
						jogo.representJogo();
					}
					else if (tipo_M.equals("Pil"))
					{
						jogo.moverCartasT(origem, destino);
						fim_jogo = jogo.jogoWin();
						jogo.representJogo();
					}

					else
					{
						System.out.println("Por favor inserir corretamente as indica��es.");
					}

				}

				else if (jogada.equals("R"))
				{
					jogo.Rebobinar();
					jogo.representJogo();
					fim_jogo = jogo.jogoWin();
				}

				else if (jogada.equals("T"))
				{
					fim_jogo = true;
				}

				else
				{
					System.out.println("Por favor inserir corretamente as indica��es.");
				}

			}
			while (fim_jogo == false);
			//fim da parte de jogar		
			
			if (jogo.jogoWin()) //true se ganhou o jogo, false se nao
			{
				System.out.println("Parab�ns! Terminou o jogo em " + jogo.getContajogadas() + "jogadas.");
				jogadorAtual.getVitorias().add(jogadorAtual.getContajogadas());
				jogadorAtual.setVenceuultimojogo(true);
				boolean sai = false;
				do 
				{
					System.out.println("O que deseja fazer? Come�ar um novo jogo ou terminar sess�o? \nN -> Novo jogo | T -> Terminar");
					String fazer = sc.nextLine();
					fazer.toUpperCase();
					if (fazer.equals("N"))
					{
						System.out.println("Vamos comecar um novo jogo.");
						jogo.start();
						jogo.representJogo();
						sai = true;
					}
					else if (fazer.equals("T"))
					{
						terminarsessao = true;
						sai = true;
					}
					else
					{
						System.out.println("N�o escolheu uma op��o poss�vel. Tente outra vez");
					}
				}
				while (!sai);
			}
			else
			{
				boolean sai = false;
				do 
				{
					System.out.println("O que deseja fazer? Retomar o seu jogo anterior, come�ar um novo jogo ou terminar sess�o? \nR ->Retomar jogo | N -> Novo jogo | T -> Terminar");
					String fazer = sc.nextLine();
					fazer.toUpperCase();
					if (fazer.equals("N"))
					{
						System.out.println("Vamos comecar um novo jogo.");
						jogo.start();
						jogo.representJogo();
						sai = true;
					}
					else if (fazer.equals("T"))
					{
						terminarsessao = true;
						sai = true;
					}
					else if (fazer.equals("R"))
					{
						System.out.println("Vamos retomar o seu �ltimo jogo.");
						jogo.loadJogo(jogadorAtual);
						jogo.representJogo();
						sai = true;
					}
					else
					{
						System.out.println("N�o escolheu uma op��o poss�vel. Tente outra vez");
					}
				}
				while (!sai);
			}
			
			if (terminarsessao)
			{
				boolean sai = false;
				do
				{
					System.out.println("Deseja guardar o jogo? S -> Sim | N -> N�o");
					String guardar = sc.nextLine();
					guardar.toUpperCase();
					if(guardar.equals("S"))
					{
						jogo.saveJogo(jogadorAtual, registos, estanosregistos);
						System.out.println("O jogo est� guardado.");
						sai = true;
					}
					else if (guardar.equals("N"))
					{
						System.out.println("O jogo n�o foi guardado.");
						sai = true;
					}
					else
					{
						System.out.println("N�o escolheu uma op��o poss�vel. Tente outra vez");
					}
				}
				while (!sai);
				sai = false;
				do
				{
					System.out.println("Quer sair do programa ou voltar a iniciar sess�o? S -> Sair do programa | I -> Iniciar sess�o");
					String guardar = sc.nextLine();
					guardar.toUpperCase();
					if(guardar.equals("S"))
					{
						fechaprograma = true;
						sai = true;
					}
					else if (guardar.equals("I"))
					{
						sai = true;
					}
					else
					{
						System.out.println("N�o escolheu uma op��o poss�vel. Tente outra vez");
					}
				}
				while (!sai);				
			}					
		}
		while(!fechaprograma);
		System.out.println("Obrigado por jogar Solit�rio");
		sc.close();
	}

}
