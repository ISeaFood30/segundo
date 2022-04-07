package segundo;

import java.util.Random;
//iniciado pelo Sérgio

public class Carta
{
	private String naipe;
	private int valor; // 1 até 13, 1 é o Ás(A), 13 é Rei(K), 12 é dama (Q), 11 é valete (J), 2 a 10 é normal
	private String cor;
	private String rep; // representação do valor da carta, 2 a 10, J,Q,K,A
	
	private int teste1;
	private int teste2;
	

	public void setRep(String rep)
	{
		this.rep = rep;
	}

	public Carta(String rep, String naipe)
	{
		this.rep = rep;
		if (rep == "A")
		{
			this.valor = 1;
		}
		else if (rep == "K")
		{
			this.valor = 13;
		}
		else if (rep == "Q")
		{
			this.valor = 12;
		}
		else if (rep == "J")
		{
			this.valor = 11;
		}
		else if (rep == "2")
		{
			this.valor = 2;
		}
		else if (rep == "3")
		{
			this.valor = 3;
		}
		else if (rep == "4")
		{
			this.valor = 4;
		}
		else if (rep == "5")
		{
			this.valor = 5;
		}
		else if (rep == "6")
		{
			this.valor = 6;
		}
		else if (rep == "7")
		{
			this.valor = 7;
		}
		else if (rep == "8")
		{
			this.valor = 8;
		}
		else if (rep == "9")
		{
			this.valor = 9;
		}
		else if (rep == "10")
		{
			this.valor = 10;
		}

		this.naipe = naipe;
		if (naipe == "E" || naipe == "P")
		{
			this.cor = "Preto";
		}
		else if (naipe == "O" || naipe == "C")
		{
			this.cor = "Vermelho";
		}
	}
/*	
	public Carta(int teste1, int teste2)   // COSNTRUTOR QUE CRIA UMA CARTA ALEATÓRIA
	{
		String[] reps = {"A","K","Q","J","10","9","8","7","6","5","4","3","2"};
		String[] naipes = {"E","P","O","C"};

		// isto aqui depois tem de ser implementado no codigo do jogo, e não aqui
		//Random random = new Random();
		//int teste1 = random.nextInt(reps.length); // random entre 0 e reps.length(exclusive)
		//int teste2 = random.nextInt(naipes.length); 
		// até aqui, fazer um random e depois ter esses teste1 e teste2 como argumento deste construtor
		
		this.rep = reps[teste1];
		this.naipe = naipes[teste2];
		
		if (rep == "A")
		{
			this.valor = 1;
		}
		else if (rep == "K")
		{
			this.valor = 13;
		}
		else if (rep == "Q")
		{
			this.valor = 12;
		}
		else if (rep == "J")
		{
			this.valor = 11;
		}
		else if (rep == "2")
		{
			this.valor = 2;
		}
		else if (rep == "3")
		{
			this.valor = 3;
		}
		else if (rep == "4")
		{
			this.valor = 4;
		}
		else if (rep == "5")
		{
			this.valor = 5;
		}
		else if (rep == "6")
		{
			this.valor = 6;
		}
		else if (rep == "7")
		{
			this.valor = 7;
		}
		else if (rep == "8")
		{
			this.valor = 8;
		}
		else if (rep == "9")
		{
			this.valor = 9;
		}
		else if (rep == "10")
		{
			this.valor = 10;
		}
		
		if (naipe == "E" || naipe == "P")
		{
			this.cor = "Preto";
		}
		else if (naipe == "O" || naipe == "C")
		{
			this.cor = "Vermelho";
		}
		
	}
*/

	public String getNaipe()
	{
		return naipe;
	}

	public void setNaipe(String naipe)
	{
		this.naipe = naipe;
	}

	public int getValor()
	{
		return valor;
	}

	public void setValor(int valor)
	{
		this.valor = valor;
	}

	public String getCor()
	{
		return cor;
	}

	public void setCor(String cor)
	{
		this.cor = cor;
	}

	public String getRep()
	{
		return rep;
	}
	
	public boolean compararNaipe(Carta_Daniel outraCarta)
	{
		boolean teste = false;
		if (this.getNaipe() == outraCarta.getNaipe())
		{
			teste = true;
		}
		else if (this.getNaipe() != outraCarta.getNaipe())
		{
			teste = false;
		}
		return teste;
	}

	public boolean compararCor(Carta_Daniel outraCarta)
	{
		boolean teste = false;
		if (this.getCor() == outraCarta.getCor())
		{
			teste = true;
		}
		else if (this.getCor() != outraCarta.getCor())
		{
			teste = false;
		}
		return teste;
	}

	// compararNaipe() e compararCor() apenas compara se são iguais ou não, dando true ou false, respet.

	public boolean menorValor(Carta outraCarta)
	{
		boolean teste = false;
		if (this.getValor() < outraCarta.getValor())
		{
			teste = true;
		}
		else if (this.getValor() > outraCarta.getValor())
		{
			teste = false;
		}
		return teste;
	}
	// menorValor dá true se a carta a analisar tiver menor valor do que a dada como argumento,
	// e false no caso contrário
/*
	public String toString() // para fazer print da carta visivel
	{
		String s;
		String s1 = "-----\n";
		String s2 = "";
		System.out.println(s1);
		if (this.rep != "10")
		{
			s2 = "| " + this.rep + " |\n";
			//System.out.println(s2);
		}
		else if (this.rep == "10")
		{
			s2 = "| " + this.rep + "|\n";
			//System.out.println(s2);
		}

		String s3 = "| " + this.naipe + " |\n";
		//System.out.println(s3);
		String s4 = "-----\n";
		//System.out.println(s4);

		s = s1 + s2 + s3 +s4;
		return s;
	}

	public String cartaOculta()
	{
		String s;
		String s1 = "-----\n";
		//System.out.println(s1);

		String s2 = "|   |\n";
		//System.out.println(s2);

		String s3 = "|   |\n";
		//System.out.println(s3);
		String s4 = "-----\n";
		//System.out.println(s4);
		s = s1 + s2 + s3 +s4;
		return s ;
	}
	*/
}
