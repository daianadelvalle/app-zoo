package ar.com.ada.maven.controller;

import ar.com.ada.maven.model.dao.ContinentDAO;
import ar.com.ada.maven.model.dto.ContinentDTO;
import ar.com.ada.maven.view.ContinentView;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class ContinentController {

    private static ContinentView view = new ContinentView();
    private static ContinentDAO continentDAO = new ContinentDAO();

    private static void continentList() {
        List<ContinentDTO> list = continentDAO.findAll();
        view.printAllContinents(list);
        try {
            System.out.println("Presione enter para regresar al menu");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void init() {
        Boolean var = false;
        while (!var) {
            Integer select = view.continentMenuSelectOption();
            switch (select) {
                case 1:
                    continentList();
                    break;
                case 2:
                    createNewContinent();
                    break;
                default:
                    System.out.println("Debes seleccionar una opción valida");
            }
        }
    }

    public static void createNewContinent() {
       String continentName = view.getNameNewContinent();
       if (!continentName.isEmpty()) {
           ContinentDTO newContinent = new ContinentDTO(continentName);
           ContinentDTO byName = continentDAO.findByName(continentName);
           if (continentName != null && newContinent.getName().equals(byName.getName())) {
               view.continentAlreadyExists(newContinent.getName());
           } else {
               Boolean resultado = continentDAO.save(newContinent);
               if (resultado)
                   view.showNewContinent(newContinent.getName());
           }

       } else {
           view.newContinentCanceled();
       }
    }
}
