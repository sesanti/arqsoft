/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Content;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Value;
import java.util.List;

/**
 *
 * @author sesan
 */
public class Numerical implements Content{
    
    private MyNumber myNumber;

    public static Numerical getInstance(String myNumber){ //crear numerical a partir de string de input y se usa en COntent Factory
        return new Numerical(MyNumber.getInstance(myNumber));
    }

    protected Numerical(MyNumber myNumber){
        this.myNumber = myNumber;
    }


    public Content getContent() {
        return this;
    }
    

    public Value getValue(){
        return myNumber;
    }


    public void setContent(Content content) {

      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }


    public Double getAsDouble() {
        return this.myNumber.getValue();
    }


    public String getAsString() {
        return this.myNumber.getValue().toString();
    }

    @Override
    public List getComponents() {
        throw new UnsupportedOperationException("Numerical content can't return List of Components"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
