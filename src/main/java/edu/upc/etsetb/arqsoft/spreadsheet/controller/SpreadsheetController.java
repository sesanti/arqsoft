/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.controller;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Content;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.SpreadsheetImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.ContentFactory;

/**
 * @author martacosano
 */
public class SpreadsheetController {

    private Spreadsheet spreadsheet;
    private ContentFactory contentFactory;


    public void createNewSpreadsheet() {
        this.spreadsheet = new SpreadsheetImpl();
    }


    public void editCell(String coordinate, String contentAsString) { //Content content
        
        /*- MIRAR si la coordenada es correcta. Si no lo es --> exception mala coordenada
          - Crear objeto contenido y asignar a la celda q tiene las coordenadas
                -cómo es este contenido? si es fórmula --> tokenizer, parser ..--> Value
          - fábrica--> crear contenido Formula( string, value, components)
           -llamar a spreadsheet--> setCellContent(coordenada, contenido)
                
        */
        String[] part = coordinate.split("(?<=\\D)(?=\\d)");//check if right coordinate preguntar si hacer en funcion separada
        if (part[0].matches("[a-zA-Z]+") == false) {
            throw new RuntimeException();
        }
        if (part[1].matches("[0-9]+") == false) {
            throw new RuntimeException();
        }


        //Create content
        Content content = contentFactory.getInstance(contentAsString);
        //spreadsheet






    }
}
