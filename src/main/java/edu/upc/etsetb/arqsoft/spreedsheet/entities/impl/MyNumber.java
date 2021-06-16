/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreedsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreedsheet.enties.Value;

/**
 *
 * @author sesan
 */
public class MyNumber implements Value{
    
    private Double value;

    public MyNumber() {
        
    }
    
    public Double getValue() {
        return value;
    }
}
