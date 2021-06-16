/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreedsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreedsheet.enties.Component;
import edu.upc.etsetb.arqsoft.spreedsheet.enties.Content;
import edu.upc.etsetb.arqsoft.spreedsheet.enties.Value;
import java.util.List;

/**
 *
 * @author sesan
 */
public class Formula implements Content {
    
    private Value value;
    
    private List<Component> components;
    
    
    public Formula(){
        
    }

    public Value getValue() {
        return this.value;
    }
    
}
