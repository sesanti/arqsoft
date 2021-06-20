/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Content;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.factories.CellFactory;

import java.util.HashMap;
import java.util.Map;

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

    public void setCellContent (String coordinate, Content content) {
        updateMaxRowColumn(coordinate);

        CellImpl cell = cellsMap.get(coordinate); //treura una cel·la si ja havia estat creada

        if (cell == null) { //cel·la no existeix
            cell = CellFactory.getInstance(content);
            cellsMap.put(coordinate, cell);

        } else {
            cell.setContent(content);

        }
    }

    public static String columnNumberToString(int column) {
        return String.valueOf((char) (column + 'A' - 1));


    }


    public static int columnStringToNumber(String column) {
        char column_char = column.charAt(0);
        int number = column_char - 'A' + 1;

        return number;

    }

    public static String concatString(String column, String row) {
        return column + row;
    }

    public void updateMaxRowColumn(String coordinate) {
        String columnString = coordinate.split("")[0];
        int row = Integer.parseInt(coordinate.split("")[1]);
        int columnInt = columnStringToNumber(columnString);

        if (row > this.maxRow) {
            this.maxRow = row;
        }

        if (columnInt > this.maxColumn) {
            this.maxColumn = columnInt;
        }
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
       for( Map.Entry<String, CellImpl> entry : cellsMap.entrySet() ){
            System.out.println( entry.getKey() + " => " + entry.getValue().getContentValueAsString() );
        }
    } 
}
