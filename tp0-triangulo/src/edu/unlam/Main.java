package edu.unlam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Ingrese los lados del triangulo separados por espacio:");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);
        String line = bf.readLine();
        String delimiter = " ";
        String[] data = new String[3];
        try {
            data = line.split(delimiter);
            if (data.length!=3) {
                System.err.println("Error en cantidad de lados.");
                System.exit(2);
            }
            int a = Integer.parseInt(data[0]);
            int b = Integer.parseInt(data[1]);
            int c = Integer.parseInt(data[2]);

            // Si es un triangulo
            if (a>0 && b>0 && c>0) {
                if (a + b > c && b + c > a && c + a > b) {
                    if (a == b && a == c) {
                        System.out.println("Equilatero");
                    } else if (a != b && a != c && b != c) {
                        System.out.println("Escaleno");
                    } else {
                        System.out.println("Isosceles");
                    }
                } else {
                    System.err.println("Error los lados no forman un triangulo");
                    System.exit(5);
                }
            } else {
                System.err.println("Error en valor de los lados, asegurese que los lados sean enteros mayores que 0");
                System.exit(4);
            }
        } catch(NumberFormatException e) {
            System.err.println("Error al procesar los lados del triangulo, asegurese que los lados sean de tipo entero.");
            System.exit(3);
        } catch(Exception e) {
            System.err.println("Error al leer los lados del triangulo.");
            System.exit(1);
        }

    }
}
