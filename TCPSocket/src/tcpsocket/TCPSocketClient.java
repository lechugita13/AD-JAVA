package tcpsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPSocketClient {

	//per connectar-se al socket del servidor
	public void connect(String address, int port) {
		String serverData;
		String request;
		boolean continueConnected = true;
		Socket socket;		
		BufferedReader in;
		PrintStream out;
		//comptador d'enviaments
		int comptador = 0;
		try {
			/**************/
			/* Nou 	Socket*/
			/**************/
			socket = new Socket(InetAddress.getByName(address), port);
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream());
			// el client at�n el port fins que decideix finalitzar
			while (continueConnected) {
				serverData = in.readLine();
				// processament de les dades rebudes i obtenci� d'una petici�
				request = getRequest(serverData,comptador);
				//comptador dels enviaments que fa el client
				comptador++;
				//esperem uns instants per a enviar
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// enviament de la petici�
				// assegurem que acaba amb un final de l�nia
				out.println(request);
				out.flush(); // assegurem que s'envia
				System.out.println("Enviat: "+request);
				// comprovem si la petici� �s un petici� de finalitzaci� i en
				// cas que ho siga ens preparem per eixir del bucle
				continueConnected = mustFinish(request);
			}
			/**********************/
			/* Tancar 	Socket*/
			/**********************/
			
                        close(socket);
			
			System.out.println("Connexi� finalitzada");
			
		} catch (UnknownHostException ex) {
			System.out.println("Error de connexi�. No existeix el host" + ex);
		} catch (IOException ex) {
			System.out.println("Error de connexi� indefinit" + ex);
		}
	}
	//comprovem si volem acabar el bucle d'enviament del client
	private boolean mustFinish(String request){
		/**********************************************************************/
		/*Un missatge concret del client indica que la comunicaci� ha d'acabar*/
		/**********************************************************************/
                if (request.equals("Acaba")) {
                return true;
            }else{
                    return false;
                }
            
	}
	//processat de dades del servidor
	private String getRequest(String serverData,int comptador){
		/********************************************************************/
		/*Mostra missatges del servidor rebuts i genera 5 missatges a enviar*/
		/*Per indicar que ha d'acabar la connexi�, envia el missatge "Acaba"*/
		/********************************************************************/
                String missatge ="";
                //envia 10 missatges
                if(comptador==10){
                    missatge="Acaba";
                }else{
                    missatge = "Missatge del client "+comptador;
                    
                }
            return null;
                
	}

	// tancament ordenat dels elements de la connexi�
	private void close(Socket socket) {
		// si falla el tancament, nom�s podem enregistrar el problema
		try {
			// tancament de tots els recursos
			if (socket != null && !socket.isClosed()) {
				if (!socket.isInputShutdown()) {
					socket.shutdownInput();
				}
				if (!socket.isOutputShutdown()) {
					socket.shutdownOutput();
				}
				socket.close();
			}
		} catch (IOException ex) {
			// enregistrem l'error amb un objecte Logger
			System.out.println("Error");
		}
	}

	// programa principal
	public static void main(String[] args) {
		/****************/
		/*inicialitzaci�*/
		/****************/
		// Valors inicials IP i PORT
                String ipServidor = "192.168.8.33";
                int portServidor = 1313;
		// Nou objecte TCPSocketClient
                TCPSocketClient client = new TCPSocketClient();
		// El client es connecta al servidor
                client.connect(ipServidor, portServidor);
	}
}
