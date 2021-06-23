
package edu.upc.etsetb.arqsoft.spreadsheet.services;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Component;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Operand;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.MyNumber;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.Operator;
import java.util.ArrayList;
import java.util.List;

/*
 *
 * @author martacosano
 */

 
public class PostfixCalculator {
    private List<Component> postfixExpression;
    private List<Component> stack;
    
    
    public PostfixCalculator(){
        this.postfixExpression = new ArrayList<>();
        this.stack = new ArrayList<>();
    }
    
    
    public MyNumber postfixEvaluation(List<Component> postfixExpression){
        
        int i=0;
        
        while( i < postfixExpression.size()){
            Component elem= postfixExpression.get(i);
            
            if(!this.isOperator(elem)){ //Operand 
              
                stack.add(elem);    
            
            }else{ //Operator
             
                Component topNumber =stack.get(stack.size()-1);
                Component bottomNumber =stack.get( stack.size()-1);
                stack.remove(stack.size()-1);
                stack.remove(stack.size()-1);
                Component result= computeResult(bottomNumber, elem, topNumber );
                stack.add(result);
            }
        }
        
        Component finalElem= stack.get(0);
        MyNumber myNumberResult = MyNumber.getInstance(finalElem.getValueAsString()); 
        return myNumberResult;
    }
    
    
    private Boolean isOperator(Component component){
        
        String comp_string = component.getValueAsString();
        
        List operators= new ArrayList();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
      
        return operators.contains(comp_string);   
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