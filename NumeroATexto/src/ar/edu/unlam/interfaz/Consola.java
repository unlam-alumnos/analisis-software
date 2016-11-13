package ar.edu.unlam.interfaz;
import java.io.*;

import ar.edu.unlam.n2t;

public class Consola {
	public static void main(String Arg[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Ingrese numero : ");
		int num = Integer.parseInt(in.readLine());
		
		String res = new n2t().convertirLetras(num);
		System.out.print(res);
		System.out.println("\n");
	}
}
