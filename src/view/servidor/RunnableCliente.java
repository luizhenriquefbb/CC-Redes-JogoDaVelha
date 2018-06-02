package view.servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Analogo ao "escutaCliente"
 * @author lhfba
 */
class RunnableCliente implements Runnable {

	private final Socket clienteSocket;
	/**ObjectInputStream para receber o nome do arquivo*/
	ObjectInputStream mensagemRecebida;
	ObjectOutputStream mensagemEnviada;
	private Map resposta;

	public RunnableCliente(Socket cliente) {
		this.clienteSocket = cliente;
		try {
			mensagemRecebida = new ObjectInputStream(clienteSocket.getInputStream());
			mensagemEnviada  = new ObjectOutputStream(clienteSocket.getOutputStream());
		} catch (IOException ex) {
			System.err.println("Erro não tratado");
			Logger.getLogger(RunnableCliente.class.getName()).log(Level.SEVERE, null, ex);
			System.exit(0);
		}

	}

	@Override
	public void run() {
		Map entrada;
		try {
			while ((entrada = (HashMap) this.mensagemRecebida.readObject()) != null){

				System.out.println("mensagem recebida "+ entrada);

				// TODO: validacao de quem eh a vez

				// TODO: computa a  e manda o tabuleiro atualizado para os jogadores
				// this.resposta = TABULEIRO ATUALIZADO; (lanca ClassNotFoundException e HashMapInvalidoException)

				// TODO: devolver para o cliente tabuleiro atualizado

			}

		}catch(IOException ex){
			System.out.println("Jogador desconectado");

		} catch (ClassNotFoundException ex) {
			System.err.println("Erro não tratado");
			Logger.getLogger(RunnableCliente.class.getName()).log(Level.SEVERE, null, ex);

//		} catch (HashMapInvalidoException ex){
//			System.out.println(ex.getMessage());
		} catch (Exception ex) {
			Logger.getLogger(RunnableCliente.class.getName()).log(Level.SEVERE, null, ex);
		}finally{
			System.out.println("//TODO: fechar conexao");
			//TODO:

		}

	}

}