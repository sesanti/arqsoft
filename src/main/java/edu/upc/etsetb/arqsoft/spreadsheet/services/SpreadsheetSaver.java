/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.services;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Spreadsheet;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author martacosano
 */
public class SpreadsheetSaver {
  
    public void saveSpreadsheeToFile(Spreadsheet spreadsheet, String path) throws IOException{
        
            
        FileWriter myWriter = new FileWriter(path);
        spreadsheet.getRowsSpreadsheet();
        
    }
    
    
}