
package edu.upc.etsetb.arqsoft.spreadsheet.services;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Component;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Operand;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.MyNumber;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.Operator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 *
 * @author martacosano
 */

 
public class PostfixCalculator {
    private List<Component> postfixExpression;
   
    
    
    public PostfixCalculator(){
        this.postfixExpression = new ArrayList<>();
        
    }
    
    
    public MyNumber postfixEvaluation(List<Component> postfixExpression){
        //inicialitza el stack perq sem crea buida
    //    LinkedList<Component> stack = new LinkedList<>();
        List<Component> stack = new ArrayList<>();
        
        int i=0;
        System.out.println("postifexpression");
        System.out.println(postfixExpression.size());
        while( i < postfixExpression.size()){
            Component elem= postfixExpression.get(i);
            
            if(this.isOperator(elem)){ //operator
             
               // Component topNumber =stack.pop();
               // Component bottomNumber =stack.pop();
                Component topNumber =stack.remove(stack.size()-1);
                Component bottomNumber =stack.remove(stack.size()-1);
                Component result= computeResult(bottomNumber, elem, topNumber );
                stack.add(result);
                
                
            }else{ //Operand: Number, cell, rangeofcells, functions
             
                stack.add(elem);
              
            }
            i++;
        }
        
        Component finalElem= stack.get(0);
        MyNumber myNumberResult = MyNumber.getInstance(finalElem.getValueAsString()); 
        return myNumberResult;
    }
    
    
    private Boolean isOperator(Component component){
        
        String comp_string = component.getValueAsString();
        String operatorsAvailable ="+-*/";
        operatorsAvailable.contains(comp_string);
     
        if(operatorsAvailable.contains(comp_string)){
            return true;
        }else{
            return false;
        }
        
        
    }
    
    
    private MyNumber computeResult(Component numLeft, Component operator, Component numRight){
     
       Double result = 0.0;
       switch(operator.getValueAsString()){
           
           case "+":
               result = numLeft.getValueAsDouble() + numRight.getValueAsDouble();
               break;
           
           case "-":
               result = numLeft.getValueAsDouble() - numRight.getValueAsDouble();
               break;
               
           case "*":
               result = numLeft.getValueAsDouble() * numRight.getValueAsDouble();
               break;
               
           case "/":
               result = numLeft.getValueAsDouble() / numRight.getValueAsDouble();
               break;       
        } 
       
        MyNumber myNumberResult = MyNumber.getInstance(result.toString()); 
        return myNumberResult;
    }
    
}