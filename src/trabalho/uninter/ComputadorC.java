package trabalho.uninter;

import java.util.Random;
//classe filha de computador, herdeira de caracteristicas
public class ComputadorC extends Computador {
	Random numAleatorio = new Random(); //importando java.util.Random, define valorea aleatorios
	
	//checando posicoes aleatorias na matriz, verificando se o espaco esta vazio: caso esteja, marca a opcao "O"
	@Override
	void jogar(String[][] map) {
		int x,y;
		while(true) {
			int x1 = numAleatorio.nextInt(3);
	        int y1 = numAleatorio.nextInt(3); 
	        if(map[x1][y1]==(" ")){
	        	map[x1][y1] = "O";
	            return; 
	         }	
		}
	}
}
