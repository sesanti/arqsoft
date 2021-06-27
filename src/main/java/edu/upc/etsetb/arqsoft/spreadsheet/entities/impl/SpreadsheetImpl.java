/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Content;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.factories.CellFactory;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author sesan
 */
public class SpreadsheetImpl implements Spreadsheet {
    private Map<String, CellImpl> cellsMap;
    private int maxRow;
    private int maxColumn;


    public SpreadsheetImpl() {
        cellsMap = new HashMap<String, CellImpl>(); //strings como keys
        maxRow = 1;
        maxColumn = 1;
    }

    public Double getCellValueAsDouble (String coordinate) {
        CellImpl cell = cellsMap.get(coordinate);
        Double value = cell.getContentValueAsDouble();

        return value;

    }

    public String getCellValueAsString (String coordinate) {
        CellImpl cell = cellsMap.get(coordinate);
        String value = cell.getContentValueAsString();

        return value;
    }

    public CellImpl getCell(String coordinate){
        return cellsMap.get(coordinate);
    }

    public void setCellContent (String coordinate, Content content) {
        updateMaxRowColumn(coordinate);

        CellImpl cell = cellsMap.get(coordinate); //treura una cel·la si ja havia estat creada    
        
        if (cell == null) { //cel·la no existeix
            cell = CellFactory.getInstance(content);
            cellsMap.put(coordinate, cell);

        } else {
            cell.setContent(content);

        }
      //  printSpreadsheet();
    }

    
    public String columnNumberToString(int column) {
        return String.valueOf((char) (column + 'A' - 1));
    }


    public int columnStringToNumber(String column) {
        char column_char = column.charAt(0);
        int number = column_char - 'A' + 1;

        return number;

    }

    public String concatString(String column, String row) {
        return column + row;
    }

    public void updateMaxRowColumn(String coordinate) {
        
        String columnString =coordinate.replaceAll("[^a-zA-Z].*", "");
        String numberOnly = coordinate.replaceAll("\\D+", "");
        int row = Integer.parseInt(numberOnly); 
        int columnInt = columnStringToNumber(columnString);   

        if (row > this.maxRow) {
            this.maxRow = row;
        }

        if (columnInt > this.maxColumn) {
            this.maxColumn = columnInt;
        }
    }
      
    public int getMaxRow(){
        return this.maxRow; 
    }
    public int getMaxColumn(){
        return this.maxColumn; 
    }
    
   
    public String[][] getSpreadsheetAsMatrix(){
        
        String [][] matrixSpreadsheet = new String[this.maxRow+1][this.maxColumn+1]; //no tinc en compte 0,0
   
        Set<String> allCoordinates = this.cellsMap.keySet();
          
        for ( String coordinate: allCoordinates){
            
            String contentCell  = getCellValueAsString(coordinate);
            String columnString =coordinate.replaceAll("[^a-zA-Z].*", "");
            int column = columnStringToNumber(columnString);
            int row = Integer.parseInt(coordinate.replaceAll("\\D+", ""));
            
             
            matrixSpreadsheet[row][column] = contentCell; //A21= 21-->[21][1]= 21.0
        }
        
        return matrixSpreadsheet;
              
    }
        
    

    public void addRows(int newFilas, int newColumns){ //servira per ensenyarho tipo taula

        for(int i= this.maxRow+1; i<=newFilas; i++){
            for(int j=1;j<=newColumns; j++){
                String coordinate=concatString(columnNumberToString(j),String.valueOf(i));
                CellImpl cell = CellFactory.getInstance(null);
                cellsMap.put(coordinate, cell);
            }
        }
    }

    public void addColumns(int newFilas, int newColumns){ ////servira per ensenyarho tipo taula
        for(int i= this.maxColumn+1; i<=newColumns; i++){
            for(int j=1;j<=newFilas; j++){
                String coordinate=concatString(columnNumberToString(j),String.valueOf(i));
                CellImpl cell = CellFactory.getInstance(null);
                cellsMap.put(coordinate, cell);
            }
        }

    }
  

    public void printSpreadsheet(){
       for( Map.Entry<String, CellImpl> entry : this.cellsMap.entrySet() ){
            System.out.println( entry.getKey() + " => " + entry.getValue().getContentValueAsString() );
        }
       //usar la matriu de la funcio per printar els valors com matriu
    }
    
    @Override
    public void updateListDependencies(String mycoordinate, String whoIDepend){
        
        CellImpl cellMyself = cellsMap.get(mycoordinate);
        
          
        CellImpl cellWhoIDepend = cellsMap.get(whoIDepend); //treura una cel·la si ja havia estat creada    
       
        if (cellMyself == null) { //cel·la no existeix
            cellMyself = CellFactory.getInstance(null);
            cellMyself.setCellIDepend(cellWhoIDepend);
        }else{
            cellMyself.setCellIDepend(cellWhoIDepend);
        }
       
       
        if (cellWhoIDepend == null) { //cel·la no existeix
            cellWhoIDepend = CellFactory.getInstance(null);
            cellWhoIDepend.setCellWhoDependsOnMe(cellMyself);

        } else {
            cellWhoIDepend.setCellWhoDependsOnMe(cellMyself);
        }     
      
    }
    
    
}
