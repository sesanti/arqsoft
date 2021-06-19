/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.enties;

/**
 *
 * @author sesan
 */
public interface Spreadsheet {

    public Double getCellValueAsDouble(String coordinate);
    
    public String getCellValueAsString(String coordinate);
    
    //public Integer columnStringToNumber(String column);
    
    //public String columnNumberToString(Integer column);
    
    //public String concatString(String row, String column);
    
    public void setCellContent(String string, Content content);
}
