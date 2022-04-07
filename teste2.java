package segundo;

import java.util.ArrayList;

public class teste2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Baralho bara = new Baralho();
		//System.out.println(bara.getBaralho());
		//bara.printBaralho();
		
		PilhaCartas arm = new PilhaCartas("E");
		Carta_Daniel carta_Daniel = new Carta_Daniel("A","E");
		Carta_Daniel carta2 = new Carta_Daniel("2","E");
		Carta_Daniel carta3 = new Carta_Daniel("3","E");
		Carta_Daniel carta4 = new Carta_Daniel("4","E");
		Carta_Daniel carta5 = new Carta_Daniel("5","E");
	
		arm.addArmazem(carta_Daniel);
		arm.addArmazem(carta2);
		arm.addArmazem(carta3);
		arm.addArmazem(carta4);
		arm.addArmazem(carta5);
		//arm.addArmazem(new Carta("6","O"));
		//arm.printPilhaA();
		
		PilhaCartas nao = new PilhaCartas(bara); // neste caso testei com o baralho completo
		nao.printPilhaN();
	}

}
