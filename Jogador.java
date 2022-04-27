package segundo;

import java.util.*;
import java.io.*;

public class Jogador implements Serializable
{
	protected String nome;
	protected String pass;
	protected String email;
	protected Pilha[] armazenamento = new Pilha[4];
	protected Pilha[] transicao = new Pilha[7];
	protected Pilha[] baralho = new Pilha[2]; 
	protected int contajogadas;
	protected ArrayList<Integer> vitorias;

	public Jogador()
	{
		
	}
	
	public Jogador(String email, String pass)
	{
		this.pass = pass;
		this.email = email;
		this.contajogadas = 0;

	}
	
	public Jogador(String email, String pass, String nome)
	{
		this.pass = pass;
		this.email = email;
		this.nome = nome;
		this.contajogadas = 0;
	}

	public boolean SameJogador(Jogador outrojogador)
	{
		if (this.pass == outrojogador.pass && this.email == outrojogador.email)
			return true;
		else
			return false;
	}
	
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

	public double getContajogadas()
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

	//estas funcoes read e write nao devem ficar na classe do Jogador
	//pode nao ser preciso os regitos e passa a ser uma void function sem returns
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
			//System.out.println("1");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			//System.out.println("2");
			oos.writeObject(registos);
			//System.out.println("3");
			oos.close();
		}
		catch (Exception e) 
		{
			System.out.println("Ocorreu um erro. Nao foi possivel gravar.");
			 e.printStackTrace(System.out);
		}	
	}
}
