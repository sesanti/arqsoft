/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.services;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Component;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.MyNumber;
import java.util.List;

/**
 *
 * @author martacosano
 */
public class PostfixCalculator {
    private List<Component> postfixExpression;
    private List<Component> stack;
    
    
    public MyNumber postfixEvaluation(List<Component> postfixExpression){
        
 
        
        int i=0;
        while( i < postfixExpression.size()){
            Component elem= postfixExpression.get(i);
            if( elem == MyNumber){
                stack.add(elem);   //is a number: push to stack
            }
            else{
                topNumber =stack.get(stack.size()-1);
                bottomNumber =stack.get( stack.size()-2);
                stack.remove(stack.size()-1);
                stack.remove(stack.size()-1);
                result= computeResult(bottomNumber, elem, topNumber );
                stack.add(result);
                
            }     
        }
        finalElem= stack.get(0);val
        return finalElem;
    }
    public MyNumber computeResult(Component numLeft, Component operator, Component numRight){
        /*numLeft*/
       // fer switch case per cada cas de operator
    }
}
            //elem.getType()
            /*if elem.getType is number
                stack.add(elem);
               else (is operator){
               firstelem=stack.get(stack.size()-1);
               secondElem=stack.get( stack.size()-2);
               operator = elem
               MyNumber result = secondelemfirstelem;
                        
     
