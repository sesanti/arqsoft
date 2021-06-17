/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreedsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreedsheet.enties.Content;
import edu.upc.etsetb.arqsoft.spreedsheet.enties.Spreadsheet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sesan
 */
public class SpreadSheetImpl implements Spreadsheet {
    private Map <String,CellImpl> cellsMap; //he posat 
    private int maxRow;
    private int maxColumn;
    
    
    public SpreadSheetImpl(){
        cellsMap = new HashMap<>(); //strings como keys
        maxRow=1;
        maxColumn=1;
    }
    
    public Double getCellValueAsDouble(String coordinate){
        throw new UnsupportedOperationException("SpreedSheetImp::getCellValueAsDouble(). Unsopported Method");
        
        CellImpl cell = cellsMap.get(coordinate);
        Double value = cell.getContentValueAsDouble();
        // desde aqui haure de mirar que faig quan esta buida la cel·la
        return value;
        
    }
    
     public String getCellValueAsString(String coordinate){
        throw new UnsupportedOperationException("SpreedSheetImp::getCellValueAsString(). Unsopported Method");
        CellImpl cell = cellsMap.get(coordinate);
        String value = cell.getContentValueAsString();
        
        return value;
     }
    
    public void setCellContent(String coordinate, Content content){
        updateMaxRowColumn(coordinate);
        //mirar si existeix i si existeix treureli el valor
        
        //CellImpl.setContent(content);
       // cellsMap.put(coordinate, );
        
    } 
    
    public static String columnNumberToString(int column){
        throw new UnsupportedOperationException("SpreedSheetImp::intToStringColumn(). Unsopported Method");
        //buscar algoritme 
    }
    
    
     public static int columnStringToNumber(String column){
        throw new UnsupportedOperationException("SpreedSheetImp::stringTointColumn(). Unsopported Method");
        char column = column.charAt(0);
         .charAt(i)-'a'+1
    }
     
     public static String concatString(String row, String column){
         return column+row;
        
     }
     
     public void updateMaxRowColumn(String coordinate){
         

        String columnString = coordinate.split("")[0];
        int row = Integer.parseInt(coordinate.split("")[1]);
        int columnInt = columnStringToNumber(columnString);

        if (row >  this.maxRow){ 
           this.maxRow= row;
        }
        
        if (columnInt >  this.maxColumn){ 
           this.maxColumn= columnInt;
        }
     }
     
}
