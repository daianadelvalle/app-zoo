package ar.com.ada.maven.view;

import ar.com.ada.maven.model.dto.ContinentDTO;
import ar.com.ada.maven.utils.ScannerSingleton;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ContinentView {
    public Integer continentMenuSelectOption() {
        System.out.println("MODULO DE CONTINENTE:\nElija la opción que corresponda:\nPara listar ingrese [1]" +
                "\nPara agregar ingrese [2]\nPara editar ingrese [3]\nPara 'eliminar' ingrese [4]\nPara salir ingrese [0]" );
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
    public void printAllContinents(List<ContinentDTO> continents)  {
        System.out.println("Listado de Continentes: ");
        continents.forEach(continent -> System.out.println(continent.toString()));
    }
    public String getNameNewContinent() {
        System.out.println("Formulario para ingresar un nuevo Continente: ");
        System.out.println("Ingresa el nombre del Continente:\nSi deja el texto vacio, se cancela el proceso de guardado.");
        Scanner keyboard = ScannerSingleton.getScanner();
        keyboard.nextLine();
        while (true) {
            try {
                String name = keyboard.nextLine().trim();
                while (!name.matches("^[A-Za-záéíóúüÁÉÍÓÚÜ\\s]+$") && !name.isEmpty()) {
                    System.out.println("Debes ingresar un dato valido");
                    name = keyboard.nextLine();
                }
                return name;
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un dato valido: ");
            }
        }
    }
    public void showNewContinent(String name) {
        System.out.println("El valor del parametro es el nuevo continente agregado a la Base de Datos");
    }
    public void newContinentCanceled() {
        System.out.println("se ha cancelado el proceso de guardado del continente\n");
    }
    public void continentAlreadyExists(String name) {
        System.out.println("El valor del paramentro ya existe en la base de datos");
    }
}
