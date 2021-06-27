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
public class Prom implements Function {

    LinkedList<Component> components;

    // public Max(LinkedList<Component> components) {
    //  this.components = components;

    //}
    public Prom(){
        components = new LinkedList<>();
    }


    public static Prom getInstance() {
        return new Prom();
    }

    public void add(Component component){
        this.components.add(component);
    }

    public String calculate() {
        double sum = 0;
        for(int i = 0; i <this.components.size(); i++){
            sum += this.components.get(i).getValueAsDouble();
        }
        return String.valueOf(sum/components.size());
    }

    @Override
    public Double getValueAsDouble() {
        return null;
    }

    @Override
    public String getValueAsString() {
        return "PROM";
    }
}
