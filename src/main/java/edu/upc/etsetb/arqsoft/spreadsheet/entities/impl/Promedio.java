/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Argument;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Function;
import java.util.List;

/**
 *
 * @author sesan
 */
public class Promedio implements Function {
    private   List<Argument> arguments;
    
    public Promedio(){
        
    }
         
    public Double promedio(List<Argument> arguments){  
        throw new UnsupportedOperationException("Promedio::promedio(arguments): Unsopported Method");
    }

    @Override
    public String getValueAsString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double getValueAsDouble() {
        throw new UnsupportedOperationException("Promedio::getValueAsDouble: Unsopported Method"); //To change body of generated methods, choose Tools | Templates.
    }
 
}
