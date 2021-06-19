/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Content;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Spreadsheet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sesan
 */
public class SpreadsheetImpl implements Spreadsheet {
    private Map <String,CellImpl> cellsMap; //he posat 
    private int maxFila;
    private int maxColumna;
    
    
    public SpreadsheetImpl(){
        cellsMap = new HashMap<>(); //strings como keys
        maxFila=1;
        maxColumna=1;
    }
    
    public Double getCellValueAsDouble(String coordinate){
        throw new UnsupportedOperationException("SpreedSheetImp::getCellValueAsDouble(). Unsopported Method");
        //update el maxcolumna, maxF
    }
    
     public String getCellValueAsString(String coordinate){
        throw new UnsupportedOperationException("SpreedSheetImp::getCellValueAsString(). Unsopported Method");
    }
    
    public void setCellContent(String coordinate, Content content){
        //CellImpl.setContent(content);
       // cellsMap.put(coordinate, );
        //metode updateMaxFilaColumna(coordinate)   
        
    } 
    
    public static String columnNumberToString(int maxColumna){
        throw new UnsupportedOperationException("SpreedSheetImp::intToStringColumn(). Unsopported Method");
        //buscar algoritme 
    }
    
    
     public static int columnStringToNumber(String maxColumna){
         throw new UnsupportedOperationException("SpreedSheetImp::stringTointColumn(). Unsopported Method");
        
    }
     
     public static String concatString(String row, String column){
         return column+row;
        
     }
     
     public void updateMaxFilaColumna(String coordinate){
         
        String fila = coordinate.split("")[0];
        String columna = coordinate.split("")[1];

        if (fila >  this.maxFila){ 
           this.maxFila= fila;
        }
     }
     
}
