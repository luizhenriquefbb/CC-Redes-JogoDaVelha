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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alisson
 * ref:http://www.baeldung.com/udp-in-java
 * This Server simply listens to connections and reply with an eccho via UDP the Clients that try to connect. It also prints 
 */
public class UDPServer extends Thread{
    private DatagramSocket socket;
    private boolean running;
    private byte[] buffer = new byte[256];
 
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
                socket.receive(packet);
            } catch (IOException ex) {
                Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //configurando o IP para responder ao cliente
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            
            packet = new DatagramPacket(buffer, buffer.length, address, port);
            String received = new String(packet.getData(), 0, packet.getLength());
             
            //closes the server
            if(received.equalsIgnoreCase("bye")) {      //PQ ISSO NÃO FUNCIONA
                running = false;
                continue;
            }
            try {
                socket.send(packet);
                System.out.println("Server replied - " + received);
            } catch (IOException ex) {
                Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        socket.close();
    }
    
    public static void main(String[] args){
        UDPServer s = new UDPServer();
        s.start();
    }
}
