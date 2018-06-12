/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import client.Client;
import util.User;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javafx.scene.layout.Border;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Alisson
 */
public class UI implements ActionListener{
    
    private JFrame window;
    private JPanel cellsPanel;
    private JPanel textPanel;
    private JPanel invitePanel;
//    private JLayeredPane panes;
    
    private JButton positions[];
    private JButton connect;
    private JButton login;
    private static JButton invite[];
    
    private JTextField ip;
    private JTextField port;
    private JTextField loginName;
    private JTextField command;
    private Client client;
    

    public UI() {
        createUI();
    }
    
    
    private void createUI(){
        
        window = new JFrame("Tic Tac Toe - UDP");
        cellsPanel = new JPanel();
        textPanel = new JPanel();
        invitePanel = new JPanel();
//        panes = new JLayeredPane();
        positions = new JButton[9];
        connect = new JButton("Connect");
        login = new JButton("Login");
        invite = new JButton[5];                                            //max size = 5 for tests
//        ip = new JTextField("Put the server IP here");
        ip = new JTextField("127.0.1.0");
        loginName = new JTextField("Choose a name");
//        port = new JTextField("Put the server port here");
        port = new JTextField("8000");
        command = new JTextField("");
        
        
        ip.setEditable(true);
        port.setEditable(true);
        command.setEditable(true);
        loginName.setEditable(true);
        command.setText("Enter the command here");
        
        connect.addActionListener(this);
        login.addActionListener(this);
        
        window.setSize(300,300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(2,2));
        
//        window.add(panes);
//        window.add(cellsPanel,BorderLayout.NORTH);
        window.add(cellsPanel);
//        window.add(textPanel, BorderLayout.SOUTH);
        window.add(invitePanel);
        window.add(textPanel);
        
        cellsPanel.setLayout(new GridLayout(3,3));
        textPanel.setLayout(new FlowLayout());
        invitePanel.setLayout(new FlowLayout());
        
        textPanel.add(ip);
        textPanel.add(port);
        textPanel.add(connect);
        textPanel.add(loginName);
        textPanel.add(login);
        textPanel.add(command);
        
        for (int i = 0; i < 9; i++) {
            positions[i] = new JButton();
            positions[i].setIcon(new ImageIcon(getClass().getResource("buttonBackground.png")));
            positions[i].addActionListener(this);
            cellsPanel.add(positions[i]);
        }
        for (int i = 0; i < 5; i++) {
            invite[i] = new JButton();
            invitePanel.add(invite[i]);
            invite[i].addActionListener(this);
        }
        

        window.setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent a){
        for (int i = 0; i < 9; i++) {
            if (a.getSource() == positions[i]) {
                positions[i].setText("Marked");
//                b[i].setDisabledIcon(ltr);
                positions[i].setEnabled(false);
            }
        }
        if(a.getSource() == connect){
            try {
                (client = new Client(ip.getText(), Integer.valueOf(port.getText()))).run();
            } catch (SocketException e) {
                System.out.println("Could not connect to socket.");
            }
        }
        else if(a.getSource() == login){
            
        }
        
    }
    
    public void updateUI(){
        
    }
    
    public static void UpdateUserList(TreeMap<String, User> listOfUsers){
        int i = 0;
        for(Map.Entry<String,User> entry : listOfUsers.entrySet()) {
            invite[i].setText(entry.getValue().getUsername());
            i++;
        }
    }
}
