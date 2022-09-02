package trabalho.uninter;

public class Jogador {
	//recebe x e y como parametro
	boolean jogar(String map[][], String horizontal, String vertical) {
		// o try verifica se a posicao que o jogador deseja inserir esta ou nao previamente ocupada
		try {
			int x = Integer.parseInt(horizontal);
			int y = Integer.parseInt(vertical);
			if(map[x - 1][y - 1].equals(" ")) {
				map[x - 1][y - 1] = "X";
				return true; // se estiver vazia, marca a opcao do jogador
			}
			else { // se ja estiver preenchida, nao marca a opcao e pede para que o jogador faca outra jogada
				System.out.println("\n*Tente novamente! Posicao ja ocupada.");
				return false;
			}
		}
		catch(Exception erro) { //caso o erro seja uma resposta totalmente diferente do esperado, indicar que o valor e invalido
			System.out.println("\n**Valor invalido, tente mais uma vez.");
			return false;
		}
	}
}
