/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.servidor;

import infra.Jogador;
import infra.ListaDeJogadores;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.HandleJSON;
import util.Strings;

/**
 *
 * @author Alisson
 */
public class RunnableClient implements Runnable{

    private DatagramPacket packet;
    private DatagramSocket socket;
    private ListaDeJogadores jogadores;
    private byte[] buffer = new byte[500];

    public RunnableClient(DatagramSocket socket, DatagramPacket packet, ArrayList<Jogador> jogadores) {
        this.socket = socket;
        this.packet = packet;
        this.jogadores = new ListaDeJogadores(jogadores);
    }
    
    @Override
    public void run() {
        //monta a string a ser enviada para o cliente
        String received = new String(packet.getData(), 0, packet.getLength());
        HashMap<String, Object> json = (HashMap<String, Object>)HandleJSON.jsonToMap(received);

        processarEntrada(json);
        reply(json);

    }

    public void reply(HashMap<String, Object> msg){
        buffer = msg.toString().getBytes();
        System.out.println(buffer.length);
        System.out.println(msg.toString().getBytes().length);
        packet.setData(buffer);
//        DatagramPacket packetToReply = new DatagramPacket(buffer, buffer.length, packet.getAddress(), 4445);
        try {
            socket.send(packet);
            String response =  new String(packet.getData(), 0, packet.getLength());
            System.out.println("Server replied - " + new String(packet.getData(), 0, packet.getLength()));
            System.out.println("response = " + response);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void processarEntrada(HashMap<String, Object> json){
        
        if(json.get(Strings.ENTRADA_ACAO).equals(Strings.SOLICITAR_JOGADORES)){
            HashMap<String,Object> resposta = new HashMap<>();
            resposta.put(Strings.LISTA_JOGADORES, jogadores.toString());
            reply(resposta);
        }

        else if(json.get(Strings.ENTRADA_ACAO).equals(Strings.INFORMAR_NOME)){
//            Informa nome
//            adiciona jogador na lista de jogadores. recebe o nome do dito cujo e o o ip
            if(jogadores.addJogador((String) json.get(Strings.NOME_JOGADOR)
                                    , packet.getAddress().toString())){

//                Devolve a lista de jogadores
                HashMap<String,Object> resposta = new HashMap<>();
                resposta.put(Strings.LISTA_JOGADORES, jogadores.toString());


                reply(resposta);
            }
        }
        
    }
    
    
    
    
    
}
