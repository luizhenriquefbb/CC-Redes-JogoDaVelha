/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.servidor;

import infra.Jogador;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alisson
 * ref:http://www.baeldung.com/udp-in-java
 * This Server simply listens to connections and reply with an eccho via UDP the Clients that try to connect. It also prints 
 */
public class UDPServer {
    private DatagramSocket socket;
    private boolean running;
    private byte[] buffer = new byte[500];
    private ArrayList<Jogador> jogadores;
 
    public UDPServer() {
        try {
            //socket que utiliza a porta 4445
            socket = new DatagramSocket(4445);
        } catch (SocketException ex) {
            Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public void run() {
        running = true;
        System.out.println("Running");

        while (running) {
            //pacote para troca de mensagens
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            try {
                //bloqueia a thread até receber uma nova conexão
                socket.receive(packet);
            } catch (IOException ex) {
                Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            //cria uma thread para responder ao cliente
            new Thread( new RunnableClient(socket, packet, jogadores)).start();
        }
        
        socket.close();
    }
    
    public static void main(String[] args){
        UDPServer s = new UDPServer();
        s.run();
    }
}
