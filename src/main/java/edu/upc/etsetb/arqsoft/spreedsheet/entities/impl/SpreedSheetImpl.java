/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreedsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreedsheet.enties.Spreedsheet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sesan
 */
public class SpreedSheetImpl implements Spreedsheet {
    private Map <String,CellImpl> cellsMap;
    
    public SpreedSheetImpl(){
        cellsMap = new HashMap<String,CellImpl>();
    }
    
    public Double getCellValueAsDouble(String coordinate){
        return  new Double(5);
    }
    
     public String getCellValueAsString(String coordinate){
        return  "";
    }
   
}
