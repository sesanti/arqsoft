/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Value;

/**
 *
 * @author sesan
 */
public class MyNumber implements Value{
    
    private Double value;

    public MyNumber(Double value) {
        this.value=value;
    }

    public static MyNumber getInstance(String value){ //logica crear mynumber
        if(value != null && value.isEmpty()){
            return new MyNumber(0.0);
        } else {
            return new MyNumber(Double.valueOf(value));
        }
    }
    
    public Double getValue() {
        return value;
    }
}
