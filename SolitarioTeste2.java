package segundo;

import java.util.*;

public class SolitarioTeste2
{

	public static void main(String[] args)
	{	
		Scanner sc = new Scanner(System.in);
		boolean fechaprograma = false;
		boolean terminarsessao = false;

		System.out.println("Seja bem-vindo ao Solitário.");
		System.out.println("Por favor inicie sessão.");
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
				System.out.println("Não está nos registos. \nQual é o seu nome? ");
				nome = sc.nextLine();

				jogadorAtual = new Jogador(email, password);
				jogadorAtual.setNome(nome);
			}
		}
		else
		{
			System.out.println("Não está nos registos. \nQual é o seu nome? ");
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
				System.out.println("A sua média de jogadas por vitória é " + media);
			}
			else
			{
				System.out.println("Não tem nenhuma vitória registada.");
			}
				
			boolean sai = false;	
			do 
			{
				System.out.println("O que deseja fazer? Retomar o seu jogo anterior, começar um novo jogo ou terminar sessão? \nR ->Retomar jogo | N -> Novo jogo | T -> Terminar");
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
					System.out.println("Vamos retomar o seu último jogo.");
					jogo.loadJogo(jogadorAtual);
					jogo.representJogo();
					sai = true;
				}
				else
				{
					System.out.println("Não escolheu uma opção possível. Tente outra vez");
				}
			}
			while (!sai);				
		}
		else
		{
			boolean sai = false;
			do 
			{
				System.out.println("O que deseja fazer? Começar um novo jogo ou terminar sessão? \nN -> Novo jogo | T -> Terminar");
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
					System.out.println("Não escolheu uma opção possível. Tente outra vez");
				}
			}
			while (!sai);
		}
		
		do
		{		
			//login
			if (terminarsessao)
			{
				System.out.println("Por favor inicie sessão.");
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
						System.out.println("Não está nos registos. \nQual é o seu nome? ");
						nome = sc.nextLine();

						jogadorAtual = new Jogador(email, password);
						jogadorAtual.setNome(nome);
					}
				}
				else
				{
					System.out.println("Não está nos registos. \nQual é o seu nome? ");
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
						System.out.println("A sua média de jogadas por vitória é " + media);
					}
					else
					{
						System.out.println("Não tem nenhuma vitória registada.");
					}
						
					boolean sai = false;	
					do 
					{
						System.out.println("O que deseja fazer? Retomar o seu jogo anterior, começar um novo jogo ou terminar sessão? \nR ->Retomar jogo | N -> Novo jogo | T -> Terminar");
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
							System.out.println("Vamos retomar o seu último jogo.");
							jogo.loadJogo(jogadorAtual);
							jogo.representJogo();
							sai = true;
						}
						else
						{
							System.out.println("Não escolheu uma opção possível. Tente outra vez");
						}
					}
					while (!sai);				
				}
				else
				{
					boolean sai = false;
					do 
					{
						System.out.println("O que deseja fazer? Começar um novo jogo ou terminar sessão? \nN -> Novo jogo | T -> Terminar");
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
							System.out.println("Não escolheu uma opção possível. Tente outra vez");
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
						System.out.println("Por favor inserir corretamente as indicações.");
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
					System.out.println("Por favor inserir corretamente as indicações.");
				}

			}
			while (fim_jogo == false);
			//fim da parte de jogar		
			
			if (jogo.jogoWin()) //true se ganhou o jogo, false se nao
			{
				System.out.println("Parabéns! Terminou o jogo em " + jogo.getContajogadas() + "jogadas.");
				jogadorAtual.getVitorias().add(jogadorAtual.getContajogadas());
				jogadorAtual.setVenceuultimojogo(true);
				boolean sai = false;
				do 
				{
					System.out.println("O que deseja fazer? Começar um novo jogo ou terminar sessão? \nN -> Novo jogo | T -> Terminar");
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
						System.out.println("Não escolheu uma opção possível. Tente outra vez");
					}
				}
				while (!sai);
			}
			else
			{
				boolean sai = false;
				do 
				{
					System.out.println("O que deseja fazer? Retomar o seu jogo anterior, começar um novo jogo ou terminar sessão? \nR ->Retomar jogo | N -> Novo jogo | T -> Terminar");
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
						System.out.println("Vamos retomar o seu último jogo.");
						jogo.loadJogo(jogadorAtual);
						jogo.representJogo();
						sai = true;
					}
					else
					{
						System.out.println("Não escolheu uma opção possível. Tente outra vez");
					}
				}
				while (!sai);
			}
			
			if (terminarsessao)
			{
				boolean sai = false;
				do
				{
					System.out.println("Deseja guardar o jogo? S -> Sim | N -> Não");
					String guardar = sc.nextLine();
					guardar.toUpperCase();
					if(guardar.equals("S"))
					{
						jogo.saveJogo(jogadorAtual, registos, estanosregistos);
						System.out.println("O jogo está guardado.");
						sai = true;
					}
					else if (guardar.equals("N"))
					{
						System.out.println("O jogo não foi guardado.");
						sai = true;
					}
					else
					{
						System.out.println("Não escolheu uma opção possível. Tente outra vez");
					}
				}
				while (!sai);
				sai = false;
				do
				{
					System.out.println("Quer sair do programa ou voltar a iniciar sessão? S -> Sair do programa | I -> Iniciar sessão");
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
						System.out.println("Não escolheu uma opção possível. Tente outra vez");
					}
				}
				while (!sai);				
			}					
		}
		while(!fechaprograma);
		System.out.println("Obrigado por jogar Solitário");
		sc.close();
	}

}
