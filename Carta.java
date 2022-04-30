package segundo;

import java.io.Serializable;

public class Carta implements Serializable
{
	private String naipe;
	private int valor; // 1 até 13, 1 é o Ás(A), 13 é Rei(K), 12 é dama (Q), 11 é valete (J), 2 a 10 é normal
	private String cor;
	private String rep; // representação do valor da carta, 2 a 10, J,Q,K,A
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
