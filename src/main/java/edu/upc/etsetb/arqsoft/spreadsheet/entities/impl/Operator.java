/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Component;
import edu.upc.etsetb.arqsoft.spreadsheet.exceptions.NoNumberException;

/**
 *
 * @author sesan
 */
public class Operator implements Component{
    private String operator;

    public Operator(String  operator){
        this.operator = operator;
    }

    public static Operator getInstance(String operator){
        return new Operator(operator);

    }
    
    @Override
    public String getValueAsString(){
        return this.operator;
    }
    
    public Component getComponent(){
        return this;
        
    }

    @Override
    public Double getValueAsDouble() {
        throw new NoNumberException("Impossible to return Operator value as Double"); //To change body of generated methods, choose Tools | Templates.
    }

}
