/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Content;
import edu.upc.etsetb.arqsoft.spreadsheet.exceptions.NoNumberException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 

/**
 *
 * @author sesan
 */
public class Text implements Content{
    

    private MyString myString;

    public static Text getInstance(String value){
        return new Text(MyString.getInstance(value));
    }

    protected Text(MyString myString){
        this.myString = myString;
    }
 
    public Content getContent() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this;
    }
    
    public MyString getValue(){
        return myString;
    }
 
    public void setContent(Content content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
    public Double getAsDouble(){
        if (this.myString.getValue().isEmpty()){
            return 0.0;
        }
        else{
            throw new NoNumberException("Impossible to return Text content as Double");
        }     
         
    }
 
    public String getAsString() {
        return this.myString.getValue();
    }
    @Override
    public List getComponents() {
        throw new UnsupportedOperationException("Numerical content can't return List of Components"); //To change body of generated methods, choose Tools | Templates.
    }
    
}
