package edu.upc.etsetb.arqsoft.spreadsheet.services;

import java.util.Iterator;
import java.util.LinkedList;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Component;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Spreadsheet;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.SpreadsheetImpl;
import edu.upc.etsetb.arqsoft.spreadsheet.factories.ComponentFactory;

public class PostFixGenerator {
    LinkedList<Token> tokens;
    LinkedList<Token> operatorStackToken; //guarrada del quince  pero es para no rehacer las funciones de isOpenBracket...... Si tenemos tiempo cambiarlo
    LinkedList<Token> outputStackToken; //guarrada del quince otra vez
    Token token;
    LinkedList<Component> outputStack;
    LinkedList<Component> operatorStack;
    ComponentFactory componentFactory;
    Spreadsheet spreadsheet;
    public PostFixGenerator(){
        this.outputStack = new LinkedList<>();
        this.operatorStackToken = new LinkedList<>();
        this.operatorStack = new LinkedList<>();
        this.outputStackToken = new LinkedList<>();
        this.componentFactory = new ComponentFactory();

    }

    public LinkedList<Component> postFixGenerator(LinkedList<Token> tokens, Spreadsheet spreadsheet){

        this.tokens=(LinkedList) ((LinkedList) tokens).clone();
        this.spreadsheet = spreadsheet;
        if(!outputStack.isEmpty()){
            this.operatorStackToken.clear();
            this.operatorStack.clear();
            this.outputStack.clear();
            this.outputStackToken.clear();

        }


        while(!this.tokens.isEmpty()) {


            token = this.tokens.pop();


            Component component = componentFactory.getInstance(token,spreadsheet);//crear componente le paso spreadsheet para poder coger los values de las celdas


            if (isOperator(token)) {
                while (!operatorStack.isEmpty() && getPriority(token) <= getPriority(operatorStackToken.peek())) {
                    // peek() inbuilt stack function to
                    // fetch the top element(token)

                    outputStack.add(operatorStack.pop());
                    outputStackToken.add(operatorStackToken.pop());

                }
                operatorStack.push(component);
                operatorStackToken.push(token);
            } else if (isOpenBracket(token)) {
                operatorStack.push(component);
                operatorStackToken.push(token);

            } else if (isClosedBracket(token)) {
                while (!operatorStack.isEmpty() && isOpenBracket(operatorStackToken.peek()) == false) {
                    outputStack.add(operatorStack.pop());
                    outputStackToken.add(operatorStackToken.pop());
                }
                if(isFunction(operatorStackToken.peek())){
                    outputStack.add(operatorStack.pop());
                    outputStackToken.add(operatorStackToken.pop());

                }

                operatorStack.pop();
                operatorStackToken.pop();
            }else if (isFunction(token)) {
                operatorStack.push(component);
                operatorStackToken.push(token);
            }
            else if (isCell(token) || isNumber(token)){
                outputStack.add(component);
                outputStackToken.add(token);
            }
        }

        while (!operatorStack.isEmpty()) {
            if (isOpenBracket(operatorStackToken.peek())){
                throw new RuntimeException(); //Poner excepcion invalidka
            }
            outputStack.add(operatorStack.pop());
            outputStackToken.add(operatorStackToken.pop());



        }
        return outputStack;



    }

    private static int getPriority(Token token){
        if (token.token == token.PLUSMINUS){
            return 1;
        }
        if (token.token == token.MULTDIV){
            return 2;
        }
        else{
            return -1;
        }
    }
    private  boolean isOperator (Token token) {
        if(token.token == token.PLUSMINUS || token.token == token.MULTDIV){
            return true;
        }
        else{
            return false;
        }

    }
    private  boolean isOpenBracket (Token token) {
        if(token.token == token.OPEN_BRACKET) {
            return true;
        }
        else{
            return false;
        }

    }
    private  boolean isClosedBracket (Token token) { // lo pongo public para poder acceder desde PostFix generator
        if(token.token == token.CLOSE_BRACKET){
            return true;
        }
        else{
            return false;
        }

    }
    private boolean isFunction(Token token){
        if (token.token == token.FUNCTION){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean isCell(Token token){
        if (token.token == token.CELL){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean isNumber(Token token){
        if (token.token == token.NUMBER){
            return true;
        }
        else{
            return false;
        }
    }
    private boolean isSeparator(Token token){
        if (token.token == token.SEPARATOR){
            return true;
        }
        else{
            return false;
        }

    }




}
