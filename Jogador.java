package segundo;

import java.util.*;
import java.io.*;

public class Jogador implements Serializable
{
	private String nome;
	private String pass;
	private String email;
	private Pilha[] armazenamento = new Pilha[4];
	private Pilha[] transicao = new Pilha[7];
	private Pilha[] baralho = new Pilha[2]; 
	private int contajogadas;
	private ArrayList<Integer> vitorias;

	public Jogador()
	{
		
	}
	
	public Jogador(String email, String pass)
	{
		this.pass = pass;
		this.email = email;
		this.contajogadas = 0;
		this.vitorias = new ArrayList<Integer>();

	}
	//este construtor foi usado apenas para teste
	public Jogador(String email, String pass, String nome)
	{
		this.pass = pass;
		this.email = email;
		this.nome = nome;
		this.contajogadas = 0;
		this.vitorias = new ArrayList<Integer>();
	}
	//nao usamos esta funcao
/*
	public boolean SameJogador(Jogador outrojogador)
	{
		if (this.pass == outrojogador.pass && this.email == outrojogador.email)
			return true;
		else
			return false;
	}*/
	
	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getPass()
	{
		return pass;
	}

	public void setPass(String pass)
	{
		this.pass = pass;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Pilha[] getArmazenamento()
	{
		return armazenamento;
	}

	public void setArmazenamento(Pilha[] armazenamento)
	{
		this.armazenamento = armazenamento;
	}

	public Pilha[] getTransicao()
	{
		return transicao;
	}

	public void setTransicao(Pilha[] transicao)
	{
		this.transicao = transicao;
	}

	public Pilha[] getBaralho()
	{
		return baralho;
	}

	public void setBaralho(Pilha[] baralho)
	{
		this.baralho = baralho;
	}

	public int getContajogadas()
	{
		return contajogadas;
	}

	public void setContajogadas(int contajogadas)
	{
		this.contajogadas = contajogadas;
	}

	public ArrayList<Integer> getVitorias()
	{
		return vitorias;
	}

	public void setVitorias(ArrayList<Integer> vitorias)
	{
		this.vitorias = vitorias;
	}

	//estas funcoes read, write e media nao devem ficar na classe do Jogador
	public static ArrayList<Jogador> read()
	{
		ArrayList<Jogador> registos = new ArrayList<Jogador>();
		try 
		{
			FileInputStream fos = new FileInputStream("db.tmp");
			ObjectInputStream oos = new ObjectInputStream(fos);
			registos=(ArrayList) oos.readObject();
			oos.close();
			return registos;
		} 
		catch (Exception e) 
		{
			System.out.println("Nao ha registos.");		
			return registos;
		}	
	}
	
	public static void write(ArrayList<Jogador> registos)
	{
		try 
		{
			FileOutputStream fos = new FileOutputStream("db.tmp");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(registos);
			oos.close();
		}
		catch (Exception e) 
		{
			System.out.println("Ocorreu um erro. Nao foi possivel gravar.");
			 e.printStackTrace(System.out);
		}	
	}
	
	public static double media(ArrayList<Integer> vitorias)
	{
		double sum = 0;
		for (int value : vitorias) {
		    sum += value;
		}
		double media  = sum/(vitorias.size()*1.0);
		return media;
	}
		
}
