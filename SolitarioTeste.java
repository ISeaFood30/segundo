package segundo;

import java.util.*;

public class SolitarioTeste
{
	private boolean terminar;
	private Jogo4 jogo;
	private boolean win;
	private boolean estanosregistos;
	private Jogador jogadorAtual;
	private boolean novo_jogo;
	private ArrayList<Jogador> registos;
	private boolean saved;

	public void Login()
	{
		System.out.println("Seja bem-vindo ao Solitário. Por favor inicie sessão.");
		this.registos = Jogador.read(); // temos de por as funcoes no sitio certo depois

		Scanner sc = new Scanner(System.in);

		System.out.println("Insira o seu email: ");
		String email = sc.nextLine();

		System.out.println("Insira a sua password: ");
		String password = sc.nextLine();

		String nome;

		// Jogador de teste
		// registos.add(new Jogador("potato", "banana", "daniel"));

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
					}
				}
			}

			if (!this.estanosregistos)
			{
				System.out.println("Não está nos registos. \nQual é o seu nome? ");
				nome = sc.nextLine();

				this.jogadorAtual = new Jogador(email, password);
				this.jogadorAtual.setNome(nome);
			}
		}
		else
		{
			System.out.println("Não está nos registos. \nQual é o seu nome? ");
			nome = sc.nextLine();

			this.jogadorAtual = new Jogador(email, password);
			this.jogadorAtual.setNome(nome);
		}

	}

	public void SolitarioTeste()
	{
		
		Scanner sc = new Scanner(System.in);
		this.jogo = new Jogo4();

		if (this.estanosregistos && this.novo_jogo == false)
		{
			System.out.println("Seja bem vindo de volta, " + jogadorAtual.getNome() + ".");
			System.out.println("Vamos recarregar o seu ultimo jogo");
			this.jogo.loadJogo(this.jogadorAtual);
			// sem registos isto vai dar erro. para efeitos de teste e normal. no fim se for preciso mudamos e pomos um
			// trycatch aqui
		}
		else if (this.estanosregistos && this.novo_jogo == true)
		{
			System.out.println("Seja bem vindo de volta, " + this.jogadorAtual.getNome() + ".");
			System.out.println("Vamos comecar um novo jogo.");
			this.jogo.start();
		}
		else if (this.estanosregistos == false)
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
				this.win = this.jogo.jogoWin();
				this.jogo.representJogo();
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
					this.jogo.moverCartasA(origem, destino);
					this.win = this.jogo.jogoWin();
					this.jogo.representJogo();
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
					this.jogo.moverCartasT(origem, destino);
					this.win = this.jogo.jogoWin();
					this.jogo.representJogo();
				}

				else
				{
					System.out.println("Por favor inserir corretamente as indicações.");
					// colocar aqui um jogo.represent()??
				}

			}

			else if (jogada.equals("R"))
			{
				this.jogo.Rebobinar();
				this.jogo.representJogo();
				this.win = this.jogo.jogoWin();
			}

			else if (this.win == true)
			{
				fim_jogo = true;
				this.novo_jogo = false;

			}

			else if (jogada.equals("T"))
			{
				fim_jogo = true;
				System.out.println("Pretende guardar o seu progresso neste jogo para depois retomar? Sim ou Não");
				String save = sc.nextLine();
				this.win = false;
				this.saved = false;
				if (save.equals("Sim"))
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

		}
		while (fim_jogo == false);
		//sc.close();
	}

	public void jogarSolitario()
	{
		Scanner scan = new Scanner(System.in);
		String decision = "";
		// o programa sai do jogo se for inserida a hipotese T ou o jogo for ganho

		if (this.win == false) // se o jogo nao for ganho, devo ter a opçao de iniciar um novo jogo ou jogar com outro
								// utilizador
		{
			if (this.saved = false)
			{
				{System.out.println(
						"Deseja recomeçar um novo ('N') jogo, jogar com outro utilizador ('L') ou terminar sessão ('E')?");
				if(scan.hasNextLine()){
					  decision = scan.nextLine();
					}
				if (decision.equals("N"))
				{
					this.novo_jogo = true;
					SolitarioTeste();
				}
				else if (decision.equals("L"))
				{
					this.novo_jogo = false;
					Login();
					SolitarioTeste();
				}
				else if (decision.equals("E"))
				{
					this.terminar = true;
					System.out.println("--> Sessão terminada <--");
				}
			}
		}
		else if (this.win == true)
		{
			System.out.println(" ### VITÓRIA! GANHOU O JOGO! ###");
			this.terminar = true;
		}
		}

		//scan.close();
	}

	public boolean getTerminar()
	{
		return terminar;
	}

	public static void main(String[] args)
	{
		SolitarioTeste game = new SolitarioTeste();
		game.Login();
		do
		{
			game.SolitarioTeste();
			game.jogarSolitario();

		}
		while (game.getTerminar() == false);
	}

}
