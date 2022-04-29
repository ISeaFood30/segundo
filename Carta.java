package segundo;

import java.io.Serializable;

public class Carta implements Serializable
{
	private String naipe;
	private int valor; // 1 at� 13, 1 � o �s(A), 13 � Rei(K), 12 � dama (Q), 11 � valete (J), 2 a 10 � normal
	private String cor;
	private String rep; // representa��o do valor da carta, 2 a 10, J,Q,K,A
	private boolean visible;
	

	public Carta(String rep, String naipe)
	{
		this.rep = rep;
		this.naipe = naipe;
		
		if (rep.equals("A"))
		{
			this.valor = 1;
		}
		else if (rep.equals("K"))
		{
			this.valor = 13;
		}
		else if (rep.equals("Q"))
		{
			this.valor = 12;
		}
		else if (rep.equals("J"))
		{
			this.valor = 11;
		}
		else if (rep.equals("2"))
		{
			this.valor = 2;
		}
		else if (rep.equals("3"))
		{
			this.valor = 3;
		}
		else if (rep.equals("4"))
		{
			this.valor = 4;
		}
		else if (rep.equals("5"))
		{
			this.valor = 5;
		}
		else if (rep.equals("6"))
		{
			this.valor = 6;
		}
		else if (rep.equals("7"))
		{
			this.valor = 7;
		}
		else if (rep.equals("8"))
		{
			this.valor = 8;
		}
		else if (rep.equals("9"))
		{
			this.valor = 9;
		}
		else if (rep.equals("10"))
		{
			this.valor = 10;
		}
		
		if (naipe.equals("E") || naipe.equals("P"))
		{
			this.cor = "Preto";
		}
		else
		{
			this.cor = "Vermelho";
		}
		
		this.visible = false;
	}
	/*
	public Carta(int teste1, int teste2) // CONSTRUTOR QUE CRIA UMA CARTA ALEAT�RIA
	{
		String[] reps = { "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2" };
		String[] naipes = { "E", "P", "O", "C" };

		// isto aqui depois tem de ser implementado no codigo do jogo, e n�o aqui
		// Random random = new Random();
		// int teste1 = random.nextInt(reps.length); // random entre 0 e reps.length(exclusive)
		// int teste2 = random.nextInt(naipes.length);
		// at� aqui, fazer um random e depois ter esses teste1 e teste2 como argumento deste construtor

		this.rep = reps[teste1];
		this.naipe = naipes[teste2];
	}*/

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

	public void setRep(String rep)
	{
		this.rep = rep;
	}

	/*
	public boolean compararNaipe(Carta outraCarta)
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

	public boolean compararCor(Carta outraCarta)
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

	// compararNaipe() e compararCor() apenas compara se s�o iguais ou n�o, dando true ou false, respet. */
/*
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
	}*/
	// menorValor d� true se a carta a analisar tiver menor valor do que a dada como argumento,
	// e false no caso contr�rio

	public String toString() // para fazer print da carta visivel
	{
		String s;
		String s1 = "----- \n";
		String s2 = null;
		if (this.rep != "10")
		{
			s2 = "| " + this.rep + " | \n";
		}
		else if (this.rep == "10")
		{
			s2 = "| " + this.rep + "| \n";
		}

		String s3 = "| " + this.naipe + " | \n";
		String s4 = "----- \n";

		s = s1 + s2 + s3 + s4;
		return s;
	}

	public String cartaOculta()
	{
		String s;
		String s1 = "----- \n";


		String s2 = "|   | \n";


		String s3 = "|   | \n";

		String s4 = "----- \n";

		s = s1 + s2 + s3 + s4;
		return s;
	}
	
	public boolean isVisible()
	{
		return visible;
	}

	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}
}
