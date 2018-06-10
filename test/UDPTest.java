
import view.servidor.UDPClient;
import view.servidor.UDPServer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Alisson
 */
public class UDPTest {
    UDPClient client;
 
    
    public void setup(){
        new UDPServer().start();
        client = new UDPClient();
    }
    
    public void whenCanSendAndReceivePacket_thenCorrect() {
        String echo = client.sendEcho("hello server");
        assertEquals("hello server", echo);
        echo = client.sendEcho("server is working");
        assertFalse(echo.equals("hello server"));
    }
 
    
    public void tearDown() {
        client.sendEcho("end");
        client.close();
    }
}
