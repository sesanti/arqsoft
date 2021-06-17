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
public class Numerical implements Content{
    
    private MyNumber myNumber;
    
    
 
      
    public static Numerical getInstance(MyNumber myNumber){    
        return new Numerical(myNumber);
    }
    
    
   
    protected Numerical(MyNumber myNumber){
        this.myNumber = myNumber;
    }
 

    @Override
    public Content getContent() {
        return this;
    }
    
    @Override
    public Value getValue(){
        return myNumber;
    }

    @Override
    public void setContent(Content content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double getAsDouble() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAsString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
