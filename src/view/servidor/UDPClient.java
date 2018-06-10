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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alisson
 * ref:http://www.baeldung.com/udp-in-java
 * This client simply sends 2 strings to the server via UDP and prints both the message sent and received
 */
public class UDPClient {
    private DatagramSocket socket;
    private InetAddress address;
 
    private byte[] buffer;
 
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
 
    public void sendEcho(String msg) {
        buffer = msg.getBytes();
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
        c.sendEcho("Hi");
        c.sendEcho("bye");
    }
    
    
}
