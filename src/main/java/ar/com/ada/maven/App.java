package ar.com.ada.maven;

import ar.com.ada.maven.model.dao.ContinentDAO;
import ar.com.ada.maven.model.dao.CountryDAO;
import ar.com.ada.maven.model.dto.ContinentDDTO;
import ar.com.ada.maven.model.dto.CountryDTO;

import java.util.List;

public class App 
{
    public static void main( String[] args ) {

        ContinentDAO dao = new ContinentDAO();
        CountryDAO countryDAO = new CountryDAO();


        //FIND BY ID
        ContinentDDTO continent = dao.findById(1);
        //System.out.println(continent.toString());


//      "SAVE"
//        ContinentDDTO continentInsert = new ContinentDDTO("Disneilandia");
//        Boolean affectedRows = dao.save(continentInsert);
//        if (affectedRows)
//        System.out.println("Se añadió un regitro a la tabla");
//        else
//            System.out.println("No se añadió nungún registro a la tabla");

//        ContinentDDTO continent = new ContinentDDTO();
//        continent = dao.findById(2);
//        CountryDTO country = new CountryDTO("Pakistan", 586, continent);
//        Boolean affectedRows = countryDAO.save(country);
//        if (affectedRows)
//            System.out.println("Se añadió un registro a la tabla");
//        else
//            System.out.println("No se añadió ningún registro a la tabla");

//      "DELETE"
//        Boolean hasDelete = dao.delete(9);
//        if (hasDelete)
//            System.out.println("Se borró el registro de la tabla");
//        else
//            System.out.println("No se pudo realizar");

//      "FIND ALL"
  //      List<ContinentDDTO> continentList = dao.findAll();
    //    continentList.forEach(continent -> System.out.println(continent.toString()));

        // UPDATE
        /*ContinentDDTO continentUpdate = new ContinentDDTO("Asia");
        Integer idUpdate = 2;
        Boolean hasUpdate = dao.update(continentUpdate, idUpdate);
        if (hasUpdate)
            System.out.println("Se actualizo el registro " + idUpdate);
        else
            System.out.println("NO se pudo realizar la actualizacion");*/

        CountryDTO countryUpdate = new CountryDTO("USA", 840, continent);
        Integer idUpdate = 3;
        countryUpdate.setId(idUpdate);
        Boolean hasUpdate = countryDAO.update(countryUpdate, idUpdate);
        if (hasUpdate)
            System.out.println("Se actualizo el registro " + idUpdate);
        else
            System.out.println("NO se pudo realizar la actualizacion");
        }


    }

