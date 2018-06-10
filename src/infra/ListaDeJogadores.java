/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import java.util.ArrayList;

/**
 *
 * @author Alisson
 */
public class ListaDeJogadores {
    
    private ArrayList<Jogador> jogadores;

    public ListaDeJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
    
    public boolean addJogador(String nome, String ip){
        if(checaNomeExistente(nome)){
            this.jogadores.add(new Jogador(nome,ip));
            return true;
        }
        else
            return false;
    }
    
    public boolean removeJogador(String nome){
        int posicao;
        if((posicao = (achaPosicaoDoJogador(nome))) > -1){
            jogadores.remove(jogadores.get(posicao));
            return true;
        }
        else
            return false;
    }
                
    public boolean checaNomeExistente(String nome){
        return this.jogadores.stream().noneMatch((j) -> (j.nome.equalsIgnoreCase(nome)));
    }
    
    public int achaPosicaoDoJogador(String nome){
        for(int i = 0; i < jogadores.size(); i++){
            if(jogadores.get(i).nome.equalsIgnoreCase(nome))
                return i;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "ListaDeJogadores{" +
                "Jogadores:\n" + (jogadores == null? "":jogadores.toString()) +
                '}';
    }
}
