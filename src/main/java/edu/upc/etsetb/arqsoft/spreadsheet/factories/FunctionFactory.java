package edu.upc.etsetb.arqsoft.spreadsheet.factories;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Function;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.Max;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.Min;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.Sum;

public class FunctionFactory {

    public static Function getInstance(String function){
        if(isSum(function)){
            return Sum.getInstance();
        }
        else if(isMin(function)){
            return Min.getInstance();
        }
        else if(isMax(function)){
            return Max.getInstance();
        }
        else{
            throw new RuntimeException("Error en funcion");
        }
    }


    private static boolean isSum(String contentAsString){
        if(contentAsString.equals("SUMA")){
            return true;
        }
        else{
            return false;
        }
    }
    private static boolean isMin(String contentAsString){
        if(contentAsString.equals("MIN")){
            return true;
        }
        else{
            return false;
        }
    }
    private static boolean isMax(String contentAsString){
        if(contentAsString.equals("MAX")){
            return true;
        }
        else{
            return false;
        }
    }
}

