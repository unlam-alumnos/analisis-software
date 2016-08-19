package edu.unlam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bf = new BufferedReader(isr);
        String line = bf.readLine();
        String[] data = line.split(" ");

        int a = Integer.parseInt(data[0]);
        int b = Integer.parseInt(data[1]);
        int c = Integer.parseInt(data[2]);

        // Si es un triangulo
        if (a + b > c && b + c > a && c + a > b) {
            if (a == b && a == c) {
                System.out.println("Equilatero");
            } else if (a != b && a != c) {
                System.out.println("Escaleno");
            } else {
                System.out.println("Isosceles");
            }
        } else {
            System.out.println("No forma triangulo");
        }
    }
}
