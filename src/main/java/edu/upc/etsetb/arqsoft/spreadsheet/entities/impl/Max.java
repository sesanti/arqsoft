package edu.upc.etsetb.arqsoft.spreadsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Component;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Function;

import java.util.LinkedList;

public class Max implements Function {
    LinkedList<Component> components;

   // public Max(LinkedList<Component> components) {
     //  this.components = components;

    //}
    public Max(){
        components = new LinkedList<>();
    }


    public static Max getInstance() {
        return new Max();
    }

    public void add(Component component){
        this.components.add(component);
    }

    public String calculate() {
        double max = this.components.get(0).getValueAsDouble();
        for(int i = 1; i <this.components.size(); i++){
            if(max<this.components.get(i).getValueAsDouble()) {
                max = this.components.get(i).getValueAsDouble();
            }
        }
        return String.valueOf(max);
    }

    @Override
    public Double getValueAsDouble() {
        return null;
    }

    @Override
    public String getValueAsString() {
        return "MAX";
    }
}

