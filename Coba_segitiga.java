/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coba_segitiga;

import java.util.Scanner;

/**
 *
 * @author asus
 */
public class Coba_segitiga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c, d;

        System.out.print("masukan panjang pola: ");
        a = scanner.nextInt();

        System.out.println("Pola 1");
        for (b = 1; b <= a; b++) {
            for (c = 1; c <= b; c++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Pola 2");
        for (b = 1; b <= a; b++) {
            for (c = a; c >= b; c--) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Pola 3");
        for (b = 1; b <= a; b++) {
            for (c = 1; c < b; c++) {
                System.out.print(" ");
            }
            for (d = a; d >= b; d--) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Pola 4");
        for (b = 1; b <= a; b++) {
            for (c = a; c > b; c--) {
                System.out.print(" ");
            }
            for (d = 1; d <= b; d++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Pola 5");
        for (b = 1; b <= a; b++) {
            for (c = a; c > b; c--) {
                System.out.print(" ");
            }
            for (d = 1; d <= (2 * b - 1); d++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Pola 6");
        for (b = 1; b <= a; b++) {
            for (c = 1; c < b; c++) {
                System.out.print(" ");
            }
            for (d = a; d >= (2 * b - a); d--) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("Pola 7");
        for (b = 1; b <= a; b++) {
            for (c = a; c > b; c--) {
                System.out.print(" ");
            }
            for (d = 1; d <= (2 * b - 1); d++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (b = 2; b <= a; b++) {
            for (c = 1; c < b; c++) {
                System.out.print(" ");
            }
            for (d = a; d >= (2 * b - a); d--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
}
