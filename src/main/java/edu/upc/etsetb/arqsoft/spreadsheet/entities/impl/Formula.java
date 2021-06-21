package edu.upc.etsetb.arqsoft.spreadsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Component;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Content;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Value;
import java.util.List;

/**
 *
 * @author sesan
 */
public class Formula implements Content {
    
    private MyNumber value; //resultado para presentarlo por pantalla
    
    private List<Component> components; //list Component que nos da el PostfixGenerator y es la entrada al PostifxCalculator
    
    private String formulaOriginal; //string para guardarlo en la celda
    
    
    
    public static Formula getInstance(MyNumber value, List<Component> components, String formulaOriginal){ // se puede llamar desde fabrica
        
        return new Formula(value,components,formulaOriginal);
    }
    
    
    protected Formula(MyNumber value, List<Component> components, String formulaOriginal){
           this.value=value;
           this.components=components;
           this.formulaOriginal=formulaOriginal;        
    }

    @Override
    public Content getContent() {
       return this;
    }
    
    @Override
    public Value getValue(){
        return this.value;
    }

    @Override
    public void setContent(Content content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double getAsDouble() {
       return this.value.getValue();
    }

    @Override
    public String getAsString() {
        return this.formulaOriginal;
    }
    
}
