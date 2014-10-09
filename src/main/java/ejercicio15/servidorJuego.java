package ejercicio15;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class servidorJuego {

	static int cont = 0;

	public static void main(String args[]) {

		
		int serverPort = 1024;

		
		ServerSocket listenSocket;

	
		Socket clientSocket;

		
		Conexion c;

		try {

		
			listenSocket = new ServerSocket(serverPort);

			while (true) {

				
				System.out.println("Esperando nueva conexión");
				clientSocket = listenSocket.accept();
				
				c = new Conexion(clientSocket);
				cont++;

			}

			
		} catch (IOException e) {
			System.out.println("Error en socket: " + e.getMessage());
		}
	}
	
}
