package segundo;
import java.util.*;

public class Pilha
{	
	public ArrayList<Carta> pilha;
	
	public Pilha(){
		this.pilha = new ArrayList<Carta>();
	}
	
	public void AddElements(ArrayList<Carta> lista) {
		this.pilha.addAll(lista);
	}
	
	public void AddElement(Carta carta) {
		this.pilha.add(carta);
	}
	
	public void print() {
		for(int i = 0; i < this.getPilha().size(); i++){
			System.out.println(this.getPilha().get(i));
		}
	}
	
	public static Pilha Baralho() {
		String[] naipes = {"O", "C", "E", "P"};
		int[] representation = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		
		ArrayList<Carta> cartas = new ArrayList<Carta>();
		for(int x = 0; x < naipes.length; x++){
			for (int y = 0; y < representation.length; y ++){
				cartas.add(new Carta(representation[y], naipes[x]));		
			}
		}
		
		ArrayList<Carta> baralhado = new ArrayList<Carta>();
		
		for (int i = 0; i<52; i++) {
			int randomnum = (int)(Math.random()*cartas.size());
			baralhado.add(cartas.get(randomnum));
			cartas.remove(randomnum);
		}	
		Pilha baralho = new Pilha();
		baralho.AddElements(baralhado);
		
		return baralho;
	}
	
	public ArrayList<Carta> getPilha()
	{
		return pilha;
	}

	public void setPilha(ArrayList<Carta> pilha)
	{
		this.pilha = pilha;
	}

	public static void main(String args[]) {
		//algo esta errado
		Pilha baralho = new Pilha();
		baralho = Pilha.Baralho();
		baralho.print();
		//System.out.println(baralho.getPilha().size());
		
		//for(int i = 0; i < baralho.getPilha().size(); i++){
			//System.out.println(baralho.getPilha().get(i));
		//}
	}
}
