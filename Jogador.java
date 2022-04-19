package segundo;

import java.util.*;
import java.io.*;

public class Jogador implements Serializable
{
	
	protected String pass;
	protected String email;
	protected Pilha[] armazenamento = new Pilha[4];
	protected Pilha[] transicao = new Pilha[7];
	//protected pilha[] baralho = new pilha[2]; 
	
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
	
	
	public static void main(String[] arg) throws FileNotFoundException, IOException, ClassNotFoundException{
		//leitura e escrita dos registos 
		//esta parte de leitura e escrita no ficheiro nao me esta a funcionar, depois pergunto
		//try catch para criação do ficheiro, podemos nao o ter ja criado
		ArrayList<Jogador> registos = new ArrayList<Jogador>();
		FileInputStream fos = new FileInputStream("db.tmp");
		ObjectInputStream oos = new ObjectInputStream(fos);
		registos=(ArrayList) oos.readObject();
		oos.close();
		
		// perguntamos credenciais
		Jogador nome = new Jogador("bananas@gmail.com", "batatascozidas");
		//verificar se esta ou nao nos registos, retirar os dados ou adicionar
		if (registos.contains(nome)){
			nome = registos.get(registos.indexOf(nome));
		}
		else 
			registos.add(nome);
		//comecamos o jogo ou retomamos o jogo ou qualquer coisa
		//quer sair da sessao
		//damos update aos coisos do jogador nome
		registos.set(registos.indexOf(nome), nome);
		//depois damos load nos registos outra vez
		
		FileOutputStream fos2 = new FileOutputStream("db.tmp");
		ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
		oos2.writeObject(registos);
		oos2.close();
	}
	
}
