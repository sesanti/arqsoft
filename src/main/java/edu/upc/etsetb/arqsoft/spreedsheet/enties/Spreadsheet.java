/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreedsheet.enties;

/**
 *
 * @author sesan
 */
public interface Spreadsheet {

    public Double getCellValueAsDouble(String coordinate);
    
    public String getCellValueAsString(String coordinate);
    
}