/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.factories;


import edu.upc.etsetb.arqsoft.spreadsheet.enties.Component;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Content;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.*;
import edu.upc.etsetb.arqsoft.spreadsheet.services.*;

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
    private PostFixGenerator postFixGenerator;
    private PostfixCalculator postfixCalculator;
    private LinkedList<Component> components;


    public ContentFactory(){
        this.tokenizer = Tokenizer.getInstance();
        this.parser = new Parser();
        this.postFixGenerator = new PostFixGenerator();
        this.postfixCalculator = new PostfixCalculator();

    }

    public Content getInstance(String contentAsString, Spreadsheet spreadsheet){
        if(isFormula(contentAsString)){

            LinkedList<Token> tokens = tokenizer.tokenize(contentAsString.substring(1));
            parser.parse(tokens);
            components = postFixGenerator.postFixGenerator(tokens, spreadsheet);

            MyNumber result = postfixCalculator.postfixEvaluation(components);
            return Formula.getInstance(result,components,contentAsString);

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
