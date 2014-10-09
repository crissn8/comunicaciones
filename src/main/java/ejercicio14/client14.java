package ejercicio14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client14 {

	public static void main(String[] args) {

		
		Scanner sr = new Scanner(System.in);
		int op;

		try {

			Socket s;
			PrintStream escribir;
			BufferedReader leer;
			s = new Socket("127.0.0.1", 1024);
			String mensajeRecibido;

			escribir = new PrintStream(s.getOutputStream());
			leer = new BufferedReader(new InputStreamReader(s.getInputStream()));

			System.out.println("Introduce la operación que quiere realizar");
			System.out.println("0:formato dia/mes/año hora:minutos:segundos");
			System.out
					.println("1:formato día de la semana,día del mes de mes de año, hora:minutos:segundos");
			op = sr.nextInt();
			escribir.println(op);

			mensajeRecibido = leer.readLine();
			System.out.println(mensajeRecibido);

			escribir.close();
			leer.close();
			s.close();
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
