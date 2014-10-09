package edu.upc.eetac.dsa.csanchez.comunicaciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;



public class ClienteTcp {
	
	
	public static void main(String[] args) {

		Socket s;
		BufferedReader b;

		String host = "localhost";
		int port = 4444;
		String respuesta;

		try {

			
			s = new Socket(host, port);

			
			b = new BufferedReader(new InputStreamReader(s.getInputStream()));

			
			respuesta = b.readLine();
			System.out.println(respuesta);

			b.close();
			s.close();

		} catch (UnknownHostException e) {
			System.out.println("No puedo conectarme a " + host + ":" + port);
		} catch (IOException e) {
			System.out.println("Error de E/S en " + host + ":" + port);
		}
	}

}
