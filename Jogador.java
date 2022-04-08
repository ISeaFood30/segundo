package segundo;

import java.util.ArrayList;

public class Jogador
{
	
	protected String pass;
	protected String email;
	
	protected ArrayList<Integer> vitorias;

	public Jogador(String email, String pass)
	{
		this.pass = pass;
		this.email = email;

	}

	public boolean SameJogador(Jogador outrojogador)
	{
		if (this.pass == outrojogador.pass && this.email == outrojogador.email)
			return true;
		else
			return false;
	}
}
