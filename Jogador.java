package segundo;

public class Jogador
{
	protected String pass;
	protected String email;
	//protected ArrayList<>() registos; criar uma classe para os registos
	
	public Jogador(){
		
	}
	
	public Jogador(String email, String pass){
		this.pass = pass;
		this.email = email;
	}	
	
	public boolean SameJogador(Jogador outrojogador) {
		if(this.pass == outrojogador.pass && this.email == outrojogador.email)
			return true;
		else
			return false;
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
}
