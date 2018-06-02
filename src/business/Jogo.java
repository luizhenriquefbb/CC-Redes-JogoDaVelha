package business;


import infra.Jogador;


public class Jogo {
	
	Jogador jogador1;
	Jogador jogador2;
	
	/**
	* Variavel que gurada a vez do jogador.
	* True == player 1
	* false == player 2
	*/
	boolean vezJogador1;
	
	/**
	* tabuleiro é um array no seguinte formato
	* <p>
	* 0 1 2
	* 3 4 5
	* 6 7 8
	*/
	String[] tabuleiro;
	
	public Jogo(Jogador jogador1, Jogador jogador2) {
		
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		
		this.vezJogador1 = true;
		
		
		this.tabuleiro = new String[9];
                for (int i = 0; i < this.tabuleiro.length; i++) {
                    this.tabuleiro[i] = " ";
                }
	}
	
	
	 /** computa a jogada. <br>
	  * Esse metodo deve dizer se a jogada eh valida ou nao e ainda dizer se a jogada resultou em um vencedor
	  */
	public String lidarComJogada(Jogador quemJogou, int indexQuadrado){
		// TODO: retorna jogada valida ou nao
		
		
		// e se resultou em vencedor
		return this.resultouEmVencendor();
	}
	
	/**
	 * Verifica se tem vencedor.
	 * Se tiver retorna X ou O
	 * 
	 * Se nao tiver retirna null
	 */
	private String resultouEmVencendor(){

		/** posicoes provavaveis que 3 casas formam vencedor */
		int[][] possiblidadesVencedor = {
			{0, 1, 2},
			{3, 4, 5},
			{6, 7, 8},
			{0, 3, 6},
			{1, 4, 7},
			{2, 5, 8},
			{0, 4, 8},
			{2, 4, 6}
		};
		
		// verificar se alguma dessas posicoes foi atendida
		for (int i = 0; i < possiblidadesVencedor.length; i++) {
			int [] possibilidade = possiblidadesVencedor[i];

			// variaveis auxiliares
			int a = possibilidade[0]; 
			int b = possibilidade[1];
			int c = possibilidade[2];
			if (this.tabuleiro[a] != " " && // ja marcado
			this.tabuleiro[a].equalsIgnoreCase(tabuleiro[b]) && this.tabuleiro[a].equalsIgnoreCase(tabuleiro[c])) //os 3 iguais
			{
				return this.tabuleiro[a];
			}
		}
		
		return null;
		
	}
}
