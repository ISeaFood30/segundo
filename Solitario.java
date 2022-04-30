package segundo;

import java.util.*;

public class Solitario
{
	private boolean terminar;
	private Jogo jogo;
	private boolean win;
	private boolean estanosregistos;
	private Jogador jogadorAtual;
	private boolean novo_jogo;
	private ArrayList<Jogador> registos;
	private boolean saved;

	public Solitario()
	{
		
	}
	
	public void Login()
	{
		System.out.println("Seja bem-vindo ao Solitário. Por favor inicie sessão.");
		this.registos = Jogador.read(); 

		Scanner sc = new Scanner(System.in);

		System.out.println("Insira o seu email: ");
		String email = sc.nextLine();

		System.out.println("Insira a sua password: ");
		String password = sc.nextLine();

		String nome;

		// verificar se esta nos registos

		this.estanosregistos = false;
		this.jogadorAtual = new Jogador();
		if (!registos.isEmpty())
		{
			for (Jogador i : registos)
			{
				if (i.getEmail().equals(email))
				{
					if (i.getPass().equals(password))
					{
						// se existe nos registos vamos buscar
						this.jogadorAtual = i;
						this.estanosregistos = true;
						
						System.out.println("Seja bem vindo de volta, " + this.jogadorAtual.getNome() + ".");						
						//mostrar media de jogadas por vitoria		
						if (!this.jogadorAtual.getVitorias().isEmpty())
						{
							double media = Jogador.media(this.jogadorAtual.getVitorias());
							System.out.println("A sua média de jogadas por vitória é " + media);
						}
						else
						{
							System.out.println("Não tem nenhuma vitória registada.");
						}
						
						//verificar em teste
						String save;
						do
						{

							System.out.println("Deseja começar um novo jogo ('N') ou recarregar um jogo guardado? ('S'))");
							save = sc.nextLine();
							save  = save.toUpperCase();
							if (save.equals("N"))
							{
								this.novo_jogo = true;
							}
							else if (save.equals("S"))
							{
								this.novo_jogo = false;
							}
							else
							{
								System.out.println("Por favor insira uma opção válida");
							}
						}
						while(!save.equals("N") && !save.equals("S"));
					}
				}
			}

			if (!this.estanosregistos)
			{
				System.out.println("Não está nos registos. \nQual é o seu nome? ");
				nome = sc.nextLine();

				this.jogadorAtual = new Jogador(email, password);
				this.jogadorAtual.setNome(nome);
				this.novo_jogo = true;
			}
		}
		else
		{
			System.out.println("Não está nos registos. \nQual é o seu nome? ");
			nome = sc.nextLine();

			this.jogadorAtual = new Jogador(email, password);
			this.jogadorAtual.setNome(nome);
			this.novo_jogo = true;
		}

	}

	public void jogaSolitario()
	{
		Scanner sc = new Scanner(System.in);
		this.jogo = new Jogo();
		
		if (this.estanosregistos && this.novo_jogo == false)   // jogador ja registado, decide continuar um jogo guardado
		{
			System.out.println("Vamos recarregar o seu ultimo jogo");
			this.jogo.loadJogo(this.jogadorAtual);
		}
		else if (this.estanosregistos && this.novo_jogo == true)  // jogador ja registado, decide começar um novo jogo
		{
			System.out.println("Vamos comecar um novo jogo.");
			this.jogo.start();
		}
		else if (this.estanosregistos == false && this.novo_jogo == true)
				{
			System.out.println("Seja bem vindo, " + this.jogadorAtual.getNome() + ".");
			System.out.println("Vamos comecar um novo jogo.");
			this.jogo.start();
		}
		this.jogo.representJogo();

		boolean fim_jogo = false;
		this.win = false;

		String jogada;
		do
		{
			jogada = this.jogo.Jogada();

			if (jogada.equals("P"))
			{
				this.jogo.passarCartas();
				this.jogo.representJogo();
			}

			else if (jogada.equals("M"))
			{
				System.out.println("Qual a pilha de origem? (se quiser tirar do baralho, escrever 'Baralho')");
				String origem = sc.nextLine();
				origem = origem.toUpperCase();

				System.out.println("Qual a pilha de destino?");
				String destino = sc.nextLine();
				destino = destino.toUpperCase();
				String tipo_M = "";
				try {
					tipo_M = destino.substring(0, 3);
				}
				catch (Exception e)
				{
					//mesmo que a de erro com o substring, ele continua o porgrama
				}

				if (tipo_M.equals("ARM"))
				{
					this.jogo.moverCartasA(origem, destino);
					this.jogo.representJogo();
				}
				
				else if (tipo_M.equals("PIL"))
				{
					this.jogo.moverCartasT(origem, destino);
					this.jogo.representJogo();
				}

				else
				{
					System.out.println("Por favor inserir corretamente as indicações.");
				}

			}

			else if (jogada.equals("R"))
			{
				this.jogo.Rebobinar();
				this.jogo.representJogo();
			}
			
			else if (jogada.equals("T"))
			{
				fim_jogo = true;
				System.out.println("Pretende guardar o seu progresso neste jogo para depois retomar? Yes ou No");
				String save = sc.nextLine();
				save = save.toUpperCase();
				this.win = false;
				this.saved = false;
				
				if (save.equals("YES"))
				{
					this.jogo.saveJogo(this.jogadorAtual, this.registos, this.estanosregistos);
					System.out.println("--> Jogo Guardado <--");
					this.saved = true;
				}			
			}
			
			else
			{
				System.out.println("Por favor inserir corretamente as indicações.");
			}
			
			this.win = this.jogo.jogoWin();
			
			if (this.win == true)
			{
				fim_jogo = true;
				this.novo_jogo = false;
			}		
		}
		while (fim_jogo == false);
	}

	public void jogarSolitario()
	{
		Scanner scan = new Scanner(System.in);
		String decision = "";
		// o programa sai do jogo se for inserida a hipotese T ou o jogo for ganho
		if (this.win == false) // se o jogo nao for ganho, devo ter a opçao de iniciar um novo jogo ou jogar com outro
								// utilizador
		{
				System.out.println(
						"Deseja recomeçar um novo ('N') jogo, jogar com outro utilizador ('L') ou terminar sessão ('E')?");
				
				decision = scan.nextLine();	
				decision = decision.toUpperCase();
				//System.out.println("A decisão é: " + decision);
				if (decision.equals("N"))
				{
					this.novo_jogo = true;
					this.terminar = false;
					//SolitarioTeste();
				}
				else if (decision.equals("L"))
				{
					this.novo_jogo = false;
					this.terminar = false;
					Login();
					//SolitarioTeste();
				}
				else //decision.equals("E") ou qualquer outro input termina sessao
				{
					this.terminar = true;
					this.novo_jogo = false;					
					System.out.println("Obrigado por jogar Solitário");
					System.out.println("--> Sessão terminada <--");
				}

			
		}
		else if (this.win == true)
		{
			System.out.println(" ### VITÓRIA! GANHOU O JOGO! ###");
			System.out.println(" Neste jogo necessitou de " + this.jogo.getContajogadas() + " jogadas para ganhar.");
			this.jogadorAtual.getVitorias().add(this.jogo.getContajogadas());
			this.terminar = true;
			this.novo_jogo = false;
		}
	}

	public boolean getTerminar()
	{
		return terminar;
	}

	public static void main(String[] args)
	{
		Solitario game = new Solitario();
		game.Login();
		do
		{
			game.jogaSolitario();
			game.jogarSolitario();

		}
		while (game.getTerminar() == false);
	}

}
