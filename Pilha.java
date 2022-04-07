package segundo;
import java.util.*;
//iniciado pelo Daniel
public class Pilha
{	
	public ArrayList<Carta_Daniel> pilha;
	
	public Pilha(){
		this.pilha = new ArrayList<Carta_Daniel>();
	}
	
	public void AddElements(ArrayList<Carta_Daniel> lista) {
		this.pilha.addAll(lista);
	}
	
	public void AddElement(Carta_Daniel carta_Daniel) {
		this.pilha.add(carta_Daniel);
	}
	
	public void print() {
		for(int i = 0; i < this.getPilha().size(); i++){
			System.out.println(this.getPilha().get(i));
		}
	}
	
	public static Pilha Baralho() {
		String[] naipes = {"O", "C", "E", "P"};
		int[] representation = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		
		ArrayList<Carta_Daniel> carta_Daniels = new ArrayList<Carta_Daniel>();
		for(int x = 0; x < naipes.length; x++){
			for (int y = 0; y < representation.length; y ++){
				carta_Daniels.add(new Carta_Daniel(representation[y], naipes[x]));		
			}
		}
		
		ArrayList<Carta_Daniel> baralhado = new ArrayList<Carta_Daniel>();
		
		for (int i = 0; i<52; i++) {
			int randomnum = (int)(Math.random()*carta_Daniels.size());
			baralhado.add(carta_Daniels.get(randomnum));
			carta_Daniels.remove(randomnum);
		}	
		Pilha baralho = new Pilha();
		baralho.AddElements(baralhado);
		
		return baralho;
	}
	
	public ArrayList<Carta_Daniel> getPilha()
	{
		return pilha;
	}

	public void setPilha(ArrayList<Carta_Daniel> pilha)
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
