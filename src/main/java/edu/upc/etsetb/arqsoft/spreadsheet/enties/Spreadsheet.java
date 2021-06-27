/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.enties;

import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.CellImpl;

/**
 *
 * @author sesan
 */
public interface Spreadsheet {

    public Double getCellValueAsDouble(String coordinate);
    
    public String getCellValueAsString(String coordinate);

    public CellImpl getCell(String coordinate);
    
    public void setCellContent(String string, Content content);

    public String[][] getSpreadsheetAsMatrix();

    public int getMaxColumn();

    public int getMaxRow();

    public void printSpreadsheet();
}
