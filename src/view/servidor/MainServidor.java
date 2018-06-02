package view.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import static util.Strings.PORTA_PRINCIPAL;

/**
 * Servidor TCP que recebe multiplos clientes <br>
 * @author lhfba
 */
public class MainServidor {
    public static void main(String[] args) {
        try {
            System.out.println("Incializando o servidor...");
            //Iniciliza o servidor
            ServerSocket serv = new ServerSocket(PORTA_PRINCIPAL);
            //Aguarda conexões
            while(true) {
                Socket clie = serv.accept();
                //Inicia thread do cliente
                //TODO: melhor opcao nesses casos eh usar pool de threads
                new Thread(new RunnableCliente(clie)).start();
            }    
       } catch(IOException e) {
           //TODO: 
            System.err.println("Erro nao tratado\n"
                    + "talvez tenha outra instancia de servidor rodando deixando a "
                    + "porta ocupada");
       }
    }
}

