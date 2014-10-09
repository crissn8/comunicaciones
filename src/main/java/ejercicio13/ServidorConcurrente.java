package ejercicio13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorConcurrente {

	public static void main(String[] args) throws IOException {

		ServerSocket s; 
		Socket sc; 
		BufferedReader b; 

		try {
			

			s = new ServerSocket(4444);
			System.out.println("Esperando conexi�n");

			while (true) {

				final PrintStream p;

				sc = s.accept();


				p = new PrintStream(sc.getOutputStream());

				Runnable r = new Runnable() {

					public void run() {
						String mensaje;
						Date now = new Date();
						SimpleDateFormat fecha = new SimpleDateFormat(
								"dd/MM/yyyy HH:mm:ss");
						mensaje = fecha.format(now);

						System.out.println(mensaje);

						
						p.println(mensaje);

					}

				};
				new Thread(r).start();
			}
		} catch (IOException e) {

			System.out.println("No puedo crear el socket");

		}
	}
	
}
