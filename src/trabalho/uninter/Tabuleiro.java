package trabalho.uninter;

public class Tabuleiro {
	
	String matTabuleiro[][] = new String [3][3]; //criando uma matriz 3 x 3 para o tabuleiro do jogo;
	int quantJogadas; // inteiro que armazena a quantidade de jogadas
	private String opcao; // armazena o símbolo do vencedor - X ou O.
	
	Tabuleiro() { //criando tabuleiro inicial
		this.quantJogadas = 0;
		comecarJogo();
		this.opcao = "";
	}
	//comecar o jogo com a matriz vazia e os desenhos da mesma
	void comecarJogo() { 
			for(int g = 0; g < 3; g++) {
				for(int h = 0; h < 3; h ++) {
					this.matTabuleiro[g][h] = " ";
			}
		}
	}
	//metodo que atualiza o tabuleiro apos cada jogada
	void mudarTela() {
		for(int g = 0; g < 3; g++) {
			System.out.println();
		}
		// display que orienta qual valor (X ou O) recebe cada jogador
		System.out.println("---------------------------------------");
		System.out.println(" X  =  PLAYER  |  O  =  COMPUTADOR");
		System.out.println("---------------------------------------");
	}
	void mostrarTabuleiro() {
		mudarTela();
	//marcacao do tabuleiro no display do jogo	
		for(int g = 0; g < 3; g++) {
			for(int h = 0; h < 3; h++) {
				System.out.print(this.matTabuleiro[g][h]);
				if(h<2) {
					System.out.print("|");
				}
			}
			if(g<2) {
				System.out.println("\n-|-|-");
			}
		}
		System.out.println("\n");
	}
	// verificar vitoria pela quantidade de jogadas, diagonais, vertical e horizontal, respectivamente.
	public boolean checarVencedor() {
		if(quantJogadas < 5) {
			return false;
		}
		if(matTabuleiro[0][0].equals(matTabuleiro[1][1]) && matTabuleiro[1][1].equals(matTabuleiro[2][2]) && !(matTabuleiro[1][1].equals(" "))) {
				this.opcao = matTabuleiro[0][0];
				return true;
		}
		if(matTabuleiro[2][0].equals(matTabuleiro[1][1]) && matTabuleiro[1][1].equals(matTabuleiro[0][2]) && !(matTabuleiro[1][1].equals(" "))) {
			this.opcao = matTabuleiro[2][0];
			return true;
		}
		for(int g = 0; g < 3; g++) {
			if(matTabuleiro[g][0].equals(matTabuleiro[g][1]) && matTabuleiro[g][1].equals(matTabuleiro[g][2]) && !(matTabuleiro[g][1].equals(" "))) {
				this.opcao = matTabuleiro[g][0];
				return true;
			}
			if(matTabuleiro[0][g].equals(matTabuleiro[1][g]) && matTabuleiro[1][g].equals(matTabuleiro[2][g]) && !(matTabuleiro[1][g].equals(" "))) {
				this.opcao = matTabuleiro[0][g];
				return true;
			}	
		}
		return false;
	}
	String statusGame() {
		// mostrar o status do jogo e verificar se ha ou nao um vencedor para a partida
		boolean vencedor = checarVencedor();
		if(this.opcao == "X") {
			return "VITORIA DO JOGADOR (X)!";
		}
		else {
			return "VITORIA DO COMPUTADOR (O)";
		}
		// Necessidade de arrumar o "Deu Velha"
			
		}
	}
