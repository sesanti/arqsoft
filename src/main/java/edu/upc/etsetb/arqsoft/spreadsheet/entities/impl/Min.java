/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Component;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Function;

import java.util.LinkedList;

/**
 *
 * @author sesan
 */
public class Min implements Function {


    LinkedList<Component> components;

    //public Min(LinkedList<Component> components) {
       // this.components = components;

    //}
    public Min(){
        components = new LinkedList<>();
    }

    public static Min getInstance() {
        return new Min( );
    }
    public void add(Component component){
        this.components.add(component);
    }
    public String calculate() {
        double min = this.components.get(0).getValueAsDouble();
        for(int i = 1; i <this.components.size(); i++){
            if(min>this.components.get(i).getValueAsDouble()) {
                min = this.components.get(i).getValueAsDouble();
            }
        }
        return String.valueOf(min);
    }

    @Override
    public String getValueAsString() {
        return "MIN";
    }

    @Override
    public Double getValueAsDouble() {
        return null;
    }
}
  
    

