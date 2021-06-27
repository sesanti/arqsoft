
package edu.upc.etsetb.arqsoft.spreadsheet.services;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Component;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Function;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.MyNumber;
import java.util.ArrayList;
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
     
        List<Component> stack = new ArrayList<>();
        
        int i=0;
        int j;
       
        while( i < postfixExpression.size()){
            Component elem= postfixExpression.get(i);
            
            if(this.isOperator(elem)) { //operator

                Component topNumber = stack.remove(stack.size() - 1);
                Component bottomNumber = stack.remove(stack.size() - 1);
                Component result = computeResult(bottomNumber, elem, topNumber);
                stack.add(result);

            }else if(this.isFunction(elem)){
               j = i-1;
               Component argument = postfixExpression.get(j);
               Function function = (Function) postfixExpression.get(i);

                while(!this.isOperator(argument)){

                    function.add(argument);
                    stack.remove(stack.size() - 1);
                    j = j-1;
                    argument = postfixExpression.get(j);
                }

                Component result = MyNumber.getInstance(function.calculate());
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
        return(operatorsAvailable.contains(comp_string));
          
        
    }
    private Boolean isFunction(Component component){
        if(component.getValueAsString().equals("SUMA")||component.getValueAsString().equals("MAX")||component.getValueAsString().equals("MIN")||component.getValueAsString().equals("MAX")||component.getValueAsString().equals("PROM")){
            return true;
        }
        else {
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