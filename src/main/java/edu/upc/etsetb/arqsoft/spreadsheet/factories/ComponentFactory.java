package edu.upc.etsetb.arqsoft.spreadsheet.factories;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Component;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Content;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.*;
import edu.upc.etsetb.arqsoft.spreadsheet.services.Parser;
import edu.upc.etsetb.arqsoft.spreadsheet.services.Token;
import edu.upc.etsetb.arqsoft.spreadsheet.services.Tokenizer;

import java.util.LinkedList;

public class ComponentFactory {

        public Component getInstance(Token token, Spreadsheet spreadsheet) {
            if (isOperator(token)) {
                return Operator.getInstance(token.sequence);

            } else if(isNumber(token)) {

                return MyNumber.getInstance(token.sequence);
            }else if(isCell(token)){
                return spreadsheet.getCell(token.sequence);
            }
            else{
               throw new UnsupportedOperationException();//

            }

        }


        private boolean isOperator (Token token) {
           if(token.token == token.PLUSMINUS || token.token == token.MULTDIV || token.token == token.OPEN_BRACKET|| token.token == token.CLOSE_BRACKET){
               return true;
           }
           else{
               return false;
           }

        }
        private boolean isNumber (Token token){
            if(token.token == token.NUMBER) {
                return true;
            }
            else {
                return false;
            }
        }
        private boolean isCell (Token token){
            if(token.token == token.CELL){
                return true;
            }
            else{
                return false;
            }
        }

}
