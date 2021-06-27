package edu.upc.etsetb.arqsoft.spreadsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Component;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Function;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Operand;

import java.util.LinkedList;

public class Sum implements Function {

    LinkedList<Component> components;

    //public Sum(LinkedList<Component> components) {
       // this.components = components;

    //}
    public Sum(){
        components = new LinkedList<>();
    }

    public static Sum getInstance() {
        return new Sum();
    }
    public void add(Component component){
        this.components.add(component);
    }
    public String calculate() {
        double sum = 0;
        for(int i = 0; i <this.components.size(); i++){
            sum += this.components.get(i).getValueAsDouble();
        }
        return String.valueOf(sum);
    }

    @Override
    public Double getValueAsDouble() {
        return null;
    }

    @Override
    public String getValueAsString() {
        return "SUMA";
    }
}
