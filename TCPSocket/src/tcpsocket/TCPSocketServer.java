package tcpsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketServer {
	static final int PORT = 1313;
	private boolean end = false;

	//per escoltar les peticions dels clients
	public void listen() {
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		try {
			/*******************/
			/* Nou serverSocket*/
			/*******************/
			
                        serverSocket = new ServerSocket(PORT);

			while (!end) {
				// Acceptem connexió */
				
				clientSocket=serverSocket.accept();
				// processem la petició del client
				
                                proccesClientRequest(clientSocket);
				// tanquem el sòcol temporal per atendre el client
				 closeClient(clientSocket);
			}
			// tanquem el sòcol principal
			if (serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// per processar les peticions dels clients
	public void proccesClientRequest(Socket clientSocket) {
		boolean farewellMessage = false;
		String clientMessage = "";
		BufferedReader in = null;
		PrintStream out = null;
		try {
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			out = new PrintStream(clientSocket.getOutputStream());
			do {
				// processem el missatge del client i generem la resposta. Si
				// clientMessage és buida generarem el missatge de benvinguda				
				String dataToSend = processData(clientMessage);
				System.out.println(dataToSend);
				out.println(dataToSend);
				out.flush();
				clientMessage = in.readLine();
				farewellMessage = isFarewellMessage(clientMessage);
			} while ((clientMessage) != null && !farewellMessage);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	//processat de les dades rebudes des del client
	private String processData(String clientMessage){
		
		/************************************************/
		/*Missatge de benvinguda i missatges de resposta*/
		/************************************************/
                if (clientMessage.equals("")) {
                return "Welcome";
            }else{
                    
                    return "a ta casa "+clientMessage;
                }
	}
	
	//comprovació si el client ha enviat el missatge per acabar la connexió
	private boolean isFarewellMessage(String clientMessage){
		/********************************************************************/
		/*Un missatge concret del client indica que la comunicació ha acabat*/
		/********************************************************************/
                if (clientMessage.equals("Acaba")) {
                return true;
            }else{
                    return false;
                }
               
	}
	

	// per tancar les connexions temporals de cada socket creat amb cada nova
	// petició
	private void closeClient(Socket clientSocket) {
		// si falla el tancament, només podem enregistrar el problema
		try { // tancament de tots els recursos
			if (clientSocket != null && !clientSocket.isClosed()) {
				if (!clientSocket.isInputShutdown()) {
					clientSocket.shutdownInput();
				}
				if (!clientSocket.isOutputShutdown()) {
					clientSocket.shutdownOutput();
				}
				clientSocket.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// programa principal
	public static void main(String[] args) {
		/****************/
		/*inicialització*/
		/****************/
		// Nou objecte TCPSocketServer
                TCPSocketServer server = new TCPSocketServer();
		// El servidor comença a escoltar
                server.listen();
	}
}
