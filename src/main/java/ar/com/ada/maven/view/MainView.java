package ar.com.ada.maven.view;

import ar.com.ada.maven.utils.ScannerSingleton;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {

    public Integer selectOption() {
        System.out.println("APLICACIÓN DE ZOOLOGICO");
        System.out.println("¿Con qué tabla desea operar? \nSi desea operar con 'CONTINENTE' ingrese[1], si desea salir ingrese [4]");
        Scanner keyboard = ScannerSingleton.getScanner();
        while (true) {
            try {
                int choice = keyboard.nextInt();
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("La selección no es valida");
                keyboard.next();
            }
        }
    }
}
