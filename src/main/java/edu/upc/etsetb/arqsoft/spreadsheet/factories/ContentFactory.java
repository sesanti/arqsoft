/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.factories;


import edu.upc.etsetb.arqsoft.spreadsheet.enties.Content;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.Numerical;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.Text;


/**
 *
 * @author sesan
 */
public class ContentFactory {

    public static final String FORMULA_PREFIX = "=";
    
    public Content getInstance(String contentAsString){ // se puede llamar desde fabrica

        if(isFormula(contentAsString)){
            return null;
        } else if (isNumber(contentAsString)) {
            return Numerical.getInstance(contentAsString); // crea nuevo numerical a partr de string input

        } else {//String
            return Text.getInstance(contentAsString); // crea nuevo Text a partr de string input
        }
     }

    private boolean isNumber(String contentAsString) {
        return contentAsString.matches("\\-?\\d*\\,?\\d+");
    }

    private boolean isFormula(String contentAsString) {
        return contentAsString.startsWith(FORMULA_PREFIX);
    }


}
