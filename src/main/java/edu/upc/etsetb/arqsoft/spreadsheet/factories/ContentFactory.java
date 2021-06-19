/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.factories;


import edu.upc.etsetb.arqsoft.spreadsheet.enties.Content;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.Numerical;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.Text;
import edu.upc.etsetb.arqsoft.spreadsheet.services.Parser;
import edu.upc.etsetb.arqsoft.spreadsheet.services.Token;
import edu.upc.etsetb.arqsoft.spreadsheet.services.Tokenizer;

import java.util.LinkedList;


/**
 *
 * @author sesan
 */
public class ContentFactory {
    private static final String FORMULA_PREFIX = "=";
    private static final String REGEX_NUMBER = "\\-?\\d*\\,?\\d+";
    private Tokenizer tokenizer;
    private Parser parser;

    public ContentFactory(){
        this.tokenizer = Tokenizer.getInstance();
        this.parser = new Parser();

    }

    public Content getInstance(String contentAsString){
        if(isFormula(contentAsString)){
            LinkedList<Token> tokens = tokenizer.tokenize(contentAsString);
            parser.parse(tokens);

            return null;
        } else if (isNumber(contentAsString)) {
            return Numerical.getInstance(contentAsString); // crea nuevo numerical a partr de string input

        } else {//String
            return Text.getInstance(contentAsString); // crea nuevo Text a partr de string input
        }
     }

    private boolean isNumber(String contentAsString) {
        return contentAsString.matches(REGEX_NUMBER);
    }

    private boolean isFormula(String contentAsString) {
        return contentAsString.startsWith(FORMULA_PREFIX);
    }


}
