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

    public Tabuleiro() {
        this.posicoes = new Integer[9];
    }
    
    boolean temGanhador(){
        return true;
    }
    
    Jogador getGanhador(){
        return new Jogador(); 
    }
    
    boolean ehPosicaoValida(int posicao){
        return true;
    }
    
}
