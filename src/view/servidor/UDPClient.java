/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.servidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import infra.Jogador;
import util.Strings;

/**
 *
 * @author Alisson
 * ref:http://www.baeldung.com/udp-in-java
 * This client simply sends 2 strings to the server via UDP and prints both the message sent and received
 */
public class UDPClient {
    private static DatagramSocket socket;
    private static InetAddress address;
 
    static private byte[] buffer;
 
    public UDPClient() {
        try {
            socket = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            address = InetAddress.getByName("localhost");
        } catch (UnknownHostException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void solicitarJogadores(){
        
        HashMap<String,String> json = new HashMap<>();
        json.put(Strings.ENTRADA_ACAO, Strings.SOLICITAR_JOGADORES);
        this.sendMessage(json);          //JSON
    }
    
    public void convidaJogador(String nome){
        
        HashMap<String,String> json = new HashMap<>();
        json.put(Strings.ENTRADA_ACAO, Strings.CONVIDAR_JOGADOR);
        json.put(Strings.NOME_JOGADOR, nome);
        this.sendMessage(json);          //JSON
    }
    
    public void entrarJogo(String nome){
        
        HashMap<String,String> json = new HashMap<>();
        json.put(Strings.ENTRADA_ACAO, Strings.INFORMAR_NOME);
        json.put(Strings.NOME_JOGADOR, nome);
        this.sendMessage(json);          //JSON
        
    }

    public void fazerJogada(Jogador j, int posicao){
        HashMap<String, String> json = new HashMap<>();
        json.put(Strings.ENTRADA_ACAO, Strings.FAZER_JOGADA);
        json.put(Strings.NOME_JOGADOR, j.getNome());                                               //precisa?
        json.put(Strings.celula, String.valueOf(posicao));
        this.sendMessage(json); // JSON
    }

    public void desistir(Jogador j){
        HashMap<String, String> json = new HashMap<>();
        json.put(Strings.ENTRADA_ACAO, Strings.DESISTIR);
        json.put(Strings.NOME_JOGADOR, j.getNome());
        this.sendMessage(json); // JSON
    }
 
    public static void sendMessage(HashMap<String, String> msg) {
        buffer = msg.toString().getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 4445);
        try {
            System.out.println("Client sending - " + msg);
            socket.send(packet);
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        packet = new DatagramPacket(buffer, buffer.length);
        try {
            socket.receive(packet);
        } catch (IOException ex) {
            Logger.getLogger(UDPClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Client received - " + received);
        
    }
 
    public void close() {
        socket.close();
    }
    
    public static void main(String[] args){
        UDPClient c = new UDPClient();
        c.solicitarJogadores();
    }
    
    
}
