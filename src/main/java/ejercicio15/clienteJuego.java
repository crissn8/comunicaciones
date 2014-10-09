package ejercicio15;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class clienteJuego {

	public static void main(String args[]) {

	
		Scanner sr = new Scanner(System.in);
		String op;


		Socket s = null;

		DataInputStream leer = null;
		DataOutputStream escribir = null;

		int serverPort = 1024;

		
		String mensajeEnviado;
		String mensajeRecibido;

		try {

			
			s = new Socket("localhost", serverPort);

			escribir = new DataOutputStream(s.getOutputStream());
			leer = new DataInputStream(s.getInputStream());

			// Control de excepciones.
		} catch (UnknownHostException ex) {
			Logger.getLogger(ex.getMessage());
			System.out.println("\nHost no encontrado");
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		try {
			mensajeRecibido = leer.readUTF();
			System.out.println(mensajeRecibido);

			System.out
					.println("Introduce el nombre del jugador para empezar una partida");
			op = sr.next();
			mensajeEnviado = "PLAY " + op;

			escribir.writeUTF(mensajeEnviado);

			mensajeRecibido = leer.readUTF();
			String[] linea = mensajeRecibido.split(" ");

			while (mensajeRecibido != null) {
				switch (linea[0]) {

				case "WAIT":
					System.out.println(mensajeRecibido);
					break;

				case "VERSUS":
					System.out.println(mensajeRecibido);
					break;

				case "YOUR":
					System.out.println(mensajeRecibido);

					System.out
							.println("Introduce el n�mero de moendas que quieres jugar seguido de las que tienes separadas por /");
					op = sr.next();
					mensajeEnviado = "MY BET " + op;
					escribir.writeUTF(mensajeEnviado);
					break;
				case "BET":
					System.out.println(mensajeRecibido);
					break;

				case "NONE":
					System.out.println(mensajeRecibido);
					mensajeRecibido = null;
					break;

				case "WINNER":
					System.out.println(mensajeRecibido);
					mensajeRecibido = null;
					break;

				}
				mensajeRecibido = leer.readUTF();
				linea = mensajeRecibido.split(" ");

			}

			s.close();
			escribir.close();
			leer.close();
			sr.close();

		} catch (IOException e) {

			System.out.println(e.getMessage());
		}

	}
	
}
