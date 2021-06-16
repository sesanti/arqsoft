/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreedsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreedsheet.enties.Content;
import edu.upc.etsetb.arqsoft.spreedsheet.enties.Value;

/**
 *
 * @author sesan
 */
public class Text implements Content{
    
    private Value value;

    public Text(){
       
    }  

    public Value getValue() {
       return this.value;
    }
    
}
