package ar.com.ada.maven.controller;

import ar.com.ada.maven.view.MainView;

public class MainController {

    private static MainView view = new MainView();

    public static void run() {
        Boolean var = false;
        while (!var) {
            Integer select = view.selectOption();
            switch (select) {
                case 1:
                    ContinentController.init();
                    break;
                case 4:
                    var = true;
                    break;
                default:
                    System.out.println("Debes ingresar una opción valida");
            }
        }
    }
}
