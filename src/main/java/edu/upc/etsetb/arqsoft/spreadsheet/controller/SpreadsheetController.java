/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.controller;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Content;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.SpreadsheetImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.exceptions.BadCoordinateException;
import edu.upc.etsetb.arqsoft.spreadsheet.exceptions.NoNumberException;

import edu.upc.etsetb.arqsoft.spreadsheet.factories.ContentFactory;
import edu.upc.etsetb.arqsoft.spreadsheet.services.Parser;
import edu.upc.etsetb.arqsoft.spreadsheet.services.PostFixGenerator;
import edu.upc.etsetb.arqsoft.spreadsheet.services.PostfixCalculator;
import edu.upc.etsetb.arqsoft.spreadsheet.services.Tokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author martacosano
 */
public class SpreadsheetController {

    private Spreadsheet spreadsheet;
    private ContentFactory contentFactory;
    private PostfixCalculator postfixCalculator;
    private Tokenizer tokenizer;
    private Parser parser;
    private PostFixGenerator postfixGenerator;

    public SpreadsheetController(){
        this.contentFactory = new ContentFactory();
        createNewSpreadsheet();
    }

    private void createNewSpreadsheet() {
        this.spreadsheet = new SpreadsheetImpl();
    }

    public String getCellContentAsString(String coordinate)throws BadCoordinateException{

        if(!isCoordinateCorrect(coordinate)){
             throw new BadCoordinateException("Incorrect "+coordinate+ "coordinate.It must be capital letter + number starting with 1");
        }

        return this.spreadsheet.getCellValueAsString(coordinate);
    }

    public Double getCellContentAsDouble(String coordinate)throws BadCoordinateException, NoNumberException{

        if(!isCoordinateCorrect(coordinate)){
             throw new BadCoordinateException("Incorrect "+coordinate+ "coordinate.It must be capital letter + number starting with 1");
        }

        return this.spreadsheet.getCellValueAsDouble(coordinate);
    }

    public void setCellContent(String coordinate, String contentAsString)throws BadCoordinateException{
      //TODO create ContentException
       

        if(!isCoordinateCorrect(coordinate)){
             throw new BadCoordinateException("Incorrect "+coordinate+ "coordinate.It must be capital letter + number starting with 1");
        }

        Content content = contentFactory.getInstance(contentAsString, spreadsheet);
        spreadsheet.setCellContent(coordinate,content);
    }


    public boolean isCoordinateCorrect(String coordinate){
        String[] part = coordinate.split("(?<=\\D)(?=\\d)");//check if right coordinate preguntar si hacer en funcion separada
        if (part[0].matches("[A-Z]") == false) {
            return false;
        }
        if (part[1].matches("[1-9]\\d*") == false) {
            return false;
        }
        return true;
    }

    public void editSpreadsheet(String coordinate, String contentAsString) throws BadCoordinateException { //Content content
        
        /*- MIRAR si la coordenada es correcta. Si no lo es --> exception mala coordenada
          - Crear objeto contenido y asignar a la celda q tiene las coordenadas
                -cómo es este contenido? si es fórmula --> tokenizer, parser ..--> Value
          - fábrica--> crear contenido Formula( string, value, components)
           -llamar a spreadsheet--> setCellContent(coordenada, contenido)

        */
        setCellContent(coordinate,contentAsString);
    }



}
