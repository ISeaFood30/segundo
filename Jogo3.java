package segundo;

import java.util.*;


//criei para nao mexer no jogo que estava a funcionar. e ja nao me lembro se podia mexer no jogo2 ou nao
public class Jogo3
{
	private Pilha[] baralho;
	private Pilha[] pilhasT;
	private Pilha[] pilhasA;
	private int contajogadas;
	
	
	public Jogo3() 
	{
		this.baralho = new Pilha[2]; //2 montes de visualizaçao para o baralho
		this.pilhasT = new Pilha[7]; // o jogo tem 7 pilhas de transição
		this.pilhasA = new Pilha[4]; // 4 pilhas de armazenamento
		this.contajogadas = 0;

	}	
	

	public void start() //comeco do jogo
	{
		Pilha baralho = new Pilha().criaBaralho();
		baralho.Baralhar();
		for (Carta i:baralho.getPilha()) 
		{
			i.setVisible(false);
		}
		for (int i = 0; i < pilhasT.length; i++)
		{
			Pilha help = new Pilha();
			for (int j = 0; j < i + 1; j++)
			{
				Carta carta = baralho.getPilha().get(j);
				help.addCarta(carta);
				baralho.getPilha().remove(carta);
			}
			pilhasT[i] = help;
			//para por as cartas visiveis ou nao, no inicio
			for (int iter = 0; iter < pilhasT[i].getPilha().size(); iter ++) 
			{
				if (iter == pilhasT[i].getPilha().size()-1) 
				{
					pilhasT[i].getPilha().get(iter).setVisible(true);
				}
				else 
				{
					pilhasT[i].getPilha().get(iter).setVisible(false);
				}
			}
		}
		this.baralho[0] = baralho;	
		this.baralho[1] = new Pilha();
		for (int j = 0; j < 4; j++)
		{
			this.pilhasA[j] = new Pilha();
		}
		
	}
	
	public String Jogada()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("P->Passar cartas | R->Rebobinar | M->Mover | T->Terminar Jogo");
		
		String jogada = scan.nextLine();

		return jogada;

	}
	

	public void passarCartas()
	{
		if (this.baralho[0].Size() == 0)
		{
			System.out.println("Não há mais cartas, por favor rebobine.");
		}
		else
		{
			this.baralho[1].addCarta(this.baralho[0].getPilha().get(this.baralho[0].getPilha().size()-1));
			this.baralho[0].removeCarta(this.baralho[0].getPilha().get(this.baralho[0].getPilha().size()-1));
		}
	}
	
	public void moverCartasT(String origem, String destino, int n_cartas)
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			if (origem.equals("Baralho"))   // mover do baralho para uma pilha de transição
			{
				int id_destinoA = Character.getNumericValue(destino.charAt(destino.length()-1)) - 1;
				Carta cartaA = this.baralho[1].getPilha().get(this.baralho[1].Size()-1);
					
				if (this.pilhasT[id_destinoA].Size() == 0 && cartaA.getRep().equals("K")) // o Às tem de ser a primeira nestas pilhas de armazenamento
				{
					this.pilhasT[id_destinoA].addCarta(cartaA);
					this.baralho[1].removeCarta(cartaA);
				}
				else if (this.pilhasT[id_destinoA].Size() > 0 && cartaA.getCor().equals(this.pilhasT[id_destinoA].getPilha().get(this.pilhasT[id_destinoA].Size() - 1).getCor()) == false
						&& this.pilhasT[id_destinoA].getPilha().get(this.pilhasT[id_destinoA].Size() - 1).getValor() - cartaA.getValor() == 1)
				{
					this.pilhasT[id_destinoA].addCarta(cartaA);
					this.baralho[1].removeCarta(cartaA);
				}
				else
				{
					System.out.println("Essa operação não é permitida. Tente outra vez.");
				}
			}
			
			// até aqui está a funcionar
			else    // de pilha de transição para pilha de transição
			{	
				int id_origem = Character.getNumericValue(origem.charAt(origem.length()-1)) - 1;
				int id_destino = Character.getNumericValue(destino.charAt(destino.length()-1)) - 1;
				int indice_mover = this.pilhasT[id_origem].Size() - n_cartas; // este é o indice da primeira carta que quero mover
				Carta carta = this.pilhasT[id_origem].getPilha().get(indice_mover); // para ver se a operação é possivel ou não
				
				if (this.pilhasT[id_destino].Size() == 0 && carta.getRep().equals("K")) // o rei tem de ser a primeira nestas pilhas de transição
				{
					for (int j=n_cartas; j > 0; j--)
					 {		
						Carta carta_help = this.pilhasT[id_origem].getPilha().get(this.pilhasT[id_origem].Size()-j);
						this.pilhasT[id_destino].addCarta(carta_help);
						this.pilhasT[id_origem].removeCarta(carta_help);
					 }					
					if (this.pilhasT[id_origem].Size() != 0)
					{
						this.pilhasT[id_origem].getPilha().get(this.pilhasT[id_origem].Size()-1).setVisible(true);
					}
				}
				
				else if (this.pilhasT[id_destino].Size() > 0 && carta.getCor().equals(this.pilhasT[id_destino].getPilha().get(this.pilhasT[id_destino].Size() - 1).getCor()) == false
						&& this.pilhasT[id_destino].getPilha().get(this.pilhasT[id_destino].Size() - 1).getValor() - carta.getValor() == 1) 
				{
					for (int j=n_cartas; j > 0; j--)
						 {		
							Carta carta_help = this.pilhasT[id_origem].getPilha().get(this.pilhasT[id_origem].Size()-j);
							this.pilhasT[id_destino].addCarta(carta_help);
							this.pilhasT[id_origem].removeCarta(carta_help);
						 }
					if (this.pilhasT[id_origem].Size() != 0)
					{
						this.pilhasT[id_origem].getPilha().get(this.pilhasT[id_origem].Size()-1).setVisible(true);
					}
				}
				else
				{
					System.out.println("Essa operação não é permitida. Tente outra vez.");
				}
			}
		}
		catch (Exception e) 
		{
			System.out.println("Verifique o que escreveu. Tente outra vez");
		}
	}
	
	
	public void moverCartasA(String origemT, String destinoA)   // mover cartas desde baralho ou transição para o armazenamento
	{
		try 
		{
			if (origemT.equals("Baralho"))   // mover do baralho para o armazenamento
			{
				int id_destinoA = Character.getNumericValue(destinoA.charAt(destinoA.length()-1)) - 1;
				Carta cartaA = this.baralho[1].getPilha().get(this.baralho[1].Size()-1);
				if (this.pilhasA[id_destinoA].Size() == 0 && cartaA.getRep().equals("A")) // o Às tem de ser a primeira nestas pilhas de armazenamento
				{
					this.pilhasA[id_destinoA].addCarta(cartaA);
					this.baralho[1].removeCarta(cartaA);
				}
				else if (this.pilhasA[id_destinoA].Size() > 0 && cartaA.getNaipe().equals(this.pilhasA[id_destinoA].getPilha().get(this.pilhasA[id_destinoA].Size() - 1).getNaipe())
						&& cartaA.getValor() - this.pilhasA[id_destinoA].getPilha().get(this.pilhasA[id_destinoA].Size() - 1).getValor() == 1)
				{
					this.pilhasA[id_destinoA].addCarta(cartaA);
					this.baralho[1].removeCarta(cartaA);
				}
				else
				{
				System.out.println("Essa operação não é permitida. Tente outra vez.");
				}
			}
			else 
			{	
				int id_origemT = Character.getNumericValue(origemT.charAt(origemT.length()-1)) - 1;
				int id_destinoA = Character.getNumericValue(destinoA.charAt(destinoA.length()-1)) - 1;
				Carta carta = this.pilhasT[id_origemT].getPilha().get(this.pilhasT[id_origemT].Size()-1);
				if (this.pilhasA[id_destinoA].Size() == 0 && carta.getRep().equals("A")) // o Às tem de ser a primeira nestas pilhas de armazenamento
				{
					this.pilhasA[id_destinoA].addCarta(carta);
					this.pilhasT[id_origemT].removeCarta(carta);
					if (this.pilhasT[id_origemT].Size() != 0)
						{
							this.pilhasT[id_origemT].getPilha().get(this.pilhasT[id_origemT].Size()-1).setVisible(true);
						}
				}
				else if (this.pilhasA[id_destinoA].Size() > 0 && carta.getNaipe().equals(this.pilhasA[id_destinoA].getPilha().get(this.pilhasA[id_destinoA].Size() - 1).getNaipe())
						&& carta.getValor() - this.pilhasA[id_destinoA].getPilha().get(this.pilhasA[id_destinoA].Size() - 1).getValor() == 1)
				{
					this.pilhasA[id_destinoA].addCarta(carta);
					this.pilhasT[id_origemT].removeCarta(carta);
					if (this.pilhasT[id_origemT].Size() != 0)
					{
						this.pilhasT[id_origemT].getPilha().get(this.pilhasT[id_origemT].Size()-1).setVisible(true);
					}
				}
				else
				{
					System.out.println("Essa operação não é permitida. Tente outra vez.");
				}
			}	
		}
		catch (Exception e) 
		{
			System.out.println("Verifique o que escreveu. Tente outra vez");
		}
	}
	

	//porque e que estamos a baralhar a pilha aqui?
	public void Rebobinar()  // REBOBINAR é a ação de voltar a juntar todas as cartas que sobram no baralho na pilha da esquerda do monte disp., e só se pode quando ja nao houver nada na da esquerda
	{
		if (this.baralho[0].Size() == 0)
		{
			this.baralho[1].Baralhar();
			this.baralho[0] = this.baralho[1];//depois de baralhar as cartas passa tudo para a pilha da esquerda
			this.baralho[1] = new Pilha(); //fica vazia
		}
	}
	//prototipo de guardar o jogo do jogador no ficheiro
	//tanto no load como save ainda faltam algumas coisas que podem ser uteis e importante gravar
	public void saveJogo(Jogador jogadorAtual, ArrayList<Jogador> registos, boolean estanosresgistos) 
	{
		jogadorAtual.setArmazenamento(this.pilhasA);
		jogadorAtual.setTransicao(this.pilhasT);
		jogadorAtual.setBaralho(this.baralho);
		
		if (estanosresgistos)
		{
			for (Jogador i : registos)
			{
				if (i.getEmail().equals(jogadorAtual.email))
				{
					if (i.getPass().equals(jogadorAtual.pass))
					{
						registos.set(registos.indexOf(i), jogadorAtual);
					}
				}
			}
		}
		else {
			registos.add(jogadorAtual);
		}
		Jogador.write(registos);	
	}
	
	//prototipo de dar load do jogo em relacao ao jogador que esta nos registos
	public void loadJogo(Jogador jogadorAtual) 
	{
		this.setBaralho(jogadorAtual.baralho);
		this.setPilhasA(jogadorAtual.armazenamento);
		this.setPilhasT(jogadorAtual.transicao);
		this.representJogo(); //pode estar aqui nesta funcao ou fora no codigo principal do jogo
	}

	public void representJogo()
	{
		//verificacao do tamanho maximo para criacao do ecrã
		int cmax = this.pilhasT[0].getPilha().size();
		for (int i = 0; i< 7;i++)
		{
			if (this.pilhasT[i].getPilha().size()>cmax)
				{
				cmax = this.pilhasT[i].getPilha().size();
				}
		}
		
		String[][] ecra = new String[8 + cmax * 4][7];
		for (int i = 0; i < ecra.length; i++)
		{
			for (int j = 0; j < ecra[i].length; j++)
			{
				ecra[i][j] = "      ";
			}
		}
		ecra[0][0] = "Monte ";
		ecra[0][1] = "Disp. ";

		for (int i = 3; i < 7; i++)
		{
			ecra[0][i] = "Arm-" + (i - 2) + " ";
		}

		for (int i = 0; i < 7; i++)
		{
			ecra[7][i] = "Pil-" + (i + 1) + " ";
		}

		//representação dos baralhos		
		//1o monte
		//estamos a impor que este monte do baralho nao se consgue ver
		if (this.baralho[0].Size() != 0)
		{
			ecra[1][0] = "----- ";
			ecra[2][0] = "|   | ";
			ecra[3][0] = "|   | ";			
			ecra[4][0] = "----- ";
		}
		
		//2º monte
		if (this.baralho[1].Size() != 0) 
		{
			ArrayList<Carta> resto = this.baralho[1].getPilha();
			//estou a impor que a ultima carta neste monte tem que ser visivel
			resto.get(resto.size() - 1).setVisible(true);
			ecra[1][1] = "----- ";
			if (resto.get(resto.size() - 1).getRep().equals("10"))
			{
				ecra[2][1] = "| " + resto.get(resto.size() - 1).getRep() + "| ";
			}
			else
			{
				ecra[2][1] = "| " + resto.get(resto.size() - 1).getRep() + " | ";
			}
			ecra[3][1] = "| " + resto.get(resto.size() - 1).getNaipe() + " | ";
			ecra[4][1] = "----- ";

			
		}
	
		// pilhas de armazenamento
		//so precisamos de representar a ultima carta, todas as outras estao escondidas
		for (int k = 0; k < 4; k++)
		{
			if (this.pilhasA[k].Size()>0)
			{
				ecra[1][3+k] = "----- ";
				ArrayList<Carta> arm = this.pilhasA[k].getPilha();
				if (arm.get(arm.size() - 1).getRep().equals("10"))
				{
					ecra[2][3+k] = "| " + arm.get(arm.size() - 1).getRep() + "| ";
				}
				else
				{
					ecra[2][3+k] = "| " + arm.get(arm.size() - 1).getRep() + " | ";
				}
				ecra[3][3+k] = "| " + arm.get(arm.size() - 1).getNaipe() + " | ";
				ecra[4][3+k] = "----- ";
			}
		}

		// pilhas de transição
		// precisamos de representar todas, por isso temos de ter cuidado de sao visible ou nao
		for (int j = 0; j < 7; j++)
		{
			for (int i = 0; i < (this.pilhasT[j].getPilha()).size(); i++)
			{
				int a = 8 + i * 4;
				//System.out.println(this.pilhasT[j].getPilha().get(i).isVisible());
				if (this.pilhasT[j].getPilha().get(i).isVisible())
				{
					ecra[a][j] = "----- ";
					if (this.pilhasT[j].getPilha().get(i).getRep().equals("10"))
					{
						ecra[a + 1][j] = "| " + this.pilhasT[j].getPilha().get(i).getRep() + "| ";
					}
					else
					{
						ecra[a + 1][j] = "| " + this.pilhasT[j].getPilha().get(i).getRep() + " | ";
					}
					ecra[a + 2][j] = "| " + this.pilhasT[j].getPilha().get(i).getNaipe() + " | ";
					ecra[a + 3][j] = "----- ";
				}
				else
				{
					ecra[a][j] = "----- ";
					ecra[a + 1][j] = "|   | ";
					ecra[a + 2][j] = "|   | ";
					ecra[a + 3][j] = "----- ";
				}
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
	
	public Pilha[] getBaralho()
	{
		return baralho;
	}

	public void setBaralho(Pilha[] baralho)
	{
		this.baralho = baralho;
	}

	public Pilha[] getPilhasT()
	{
		return pilhasT;
	}

	public void setPilhasT(Pilha[] pilhasT)
	{
		this.pilhasT = pilhasT;
	}

	public Pilha[] getPilhasA()
	{
		return pilhasA;
	}

	public void setPilhasA(Pilha[] pilhasA)
	{
		this.pilhasA = pilhasA;
	}

}
