/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

/**
 *
 * @author Alisson
 */
public class Tabuleiro {
    Integer[] posicoes;
    //0 == circulo
    //1 == xis
    //-1 == vazio

    public Tabuleiro() {
        this.posicoes = new Integer[9];
    }
    
    boolean ehPosicaoValida(int posicao){
        return ((posicao < 9) && (posicao >= 0) && (posicoes[posicao] == -1));
            
    }
    
}
