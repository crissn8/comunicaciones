package edu.upc.eetac.dsa.csanchez.comunicaciones;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;



public class ServerTcp {
	

	public static void main(String[] args) {

		ServerSocket s; 
		Socket sc; 

		PrintStream p;
		BufferedReader b; 
		String mensaje;

		Date now = new Date();

		try {
			

			s = new ServerSocket(4444);
			System.out.println("Esperando conexión");

			
			sc = s.accept();

		
			p = new PrintStream(sc.getOutputStream());

			while (true) {
				SimpleDateFormat fecha = new SimpleDateFormat(
						"dd/MM/yyyy HH:mm:ss");
				mensaje = fecha.format(now);

				
				p.println(mensaje);
				break;
			}
			p.close();

			sc.close();
			s.close();
		} catch (IOException e) {
			System.out.println("No puedo crear el socket");
		}
	}
	
	

}
