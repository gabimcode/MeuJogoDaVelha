package trabalho.uninter;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//classe principal criada para fazer os comandos do jogo
		
		Scanner teclado = new Scanner(System.in); //criação do scanner para receber os dados inseridos pelo teclado
		
		Jogador jog = new Jogador(); //classe jogador
		
		ComputadorA compA = new ComputadorA(); //classes filhas da classe Computador
		ComputadorB compB = new ComputadorB(); //classes filhas da classe Computador
		ComputadorC compC = new ComputadorC(); //classes filhas da classe Computador
		
		// loop de criacao do menu com as opcoes
		while(true) {
			Tabuleiro tabJogo = new Tabuleiro(); // novo tabuleiro
			int nivel = menu1();
			
			boolean vitoriaJogador;
			do {
				if(tabJogo.quantJogadas == 9) { //encerramento do loop caso a quantidades de jogadas forem < 9
					break;
				}
				//variaveis de entrada de dados para a posicao x - horizontal - e y - vertical - na matriz
				String x = " ";
				String y = " ";
				tabJogo.mostrarTabuleiro(); //impressao do tabuleiro
				
				// tratamento de dados, onde colhe as informacoes sobre a posicao que o jogador deseja colocar seu X
				do {
					System.out.println("\nInsira a posicao da *linha* que desejas jogar -> ");
					x = teclado.next();
					System.out.println("\nInsira a posicao da *coluna* que desejas jogar -> ");
					y = teclado.next();
				}
				while(!(jog.jogar(tabJogo.matTabuleiro, x, y)));
				tabJogo.quantJogadas++; //acrescentar o numero de jogadas
				
				// verificar se ha vencedor				
				boolean vitoriaJogador1 = tabJogo.checarVencedor();
				if(!(vitoriaJogador1)) { //condicao que faz a jogada correspondente ao nivel
					switch(nivel) {
					case 1:
						compA.jogar(tabJogo.matTabuleiro); //correspondente ao computador A
						break;
					case 2:
						compB.jogar(tabJogo.matTabuleiro); //correspondente ao computador B
						break;
					case 3:
						compC.jogar(tabJogo.matTabuleiro); //correspondente ao computador C
						break;
					}
					tabJogo.quantJogadas++; //incrementando jogadas
				}
			}
			while(!(tabJogo.checarVencedor()));
			
			//finalizando o jogo, retornando o vencedor e colocando a opcao de jogar novamente
			tabJogo.mostrarTabuleiro();
			System.out.println(tabJogo.statusGame());
			System.out.println("Digite '0' e aperte enter para jogar mais uma vez!");
			teclado.next();
			
		}
	}
	// definindo o menu do jogo
	public static int menu1() {
		Scanner teclado = new Scanner(System.in);
        int nivel = 0; //nivel inicia com o valor zero para que seja possivel o loop
        while(true) {
        	try {
        		 System.out.println("\n |  J O G O  D A  V E L H A | ");    		// nome do jogo, para identificar ao jogador
        		 System.out.println("\nPara comecar o jogo, escolha o nivel de dificuldade: sendo o 1 mais facil e o 3 mais dificil. "); //explicacao sobre os niveis    		
        		 System.out.print("\nSelecione o nivel para jogar (1, 2 ou 3): "); //escolha e input dos niveis atraves do teclado
                 nivel = Integer.parseInt(teclado.next());
                 // dependendo da escolha do jogador, sera retornado o nivel correspondente 
                 switch(nivel) {
                 case 1:
                     return 1;
                 case 2:
                     return 2;
                 case 3:
                     return 3;
                 default: // colocar um possivel erro para que haja como prosseguir, caso digite um numero errado
                     System.out.println("\nO nivel inserido pelo teclado nao existe: tente novamente!" );
                 
                 }
        	}
        	catch(Exception erro) {// em caso de digitacao de um valor que nao seja inteiro, a mensagem abaixo sera apresentada
        		System.out.println("\nPor favor, escolha um nivel valido (de 1 a 3).");
        	}
        }
	}
	
	

}