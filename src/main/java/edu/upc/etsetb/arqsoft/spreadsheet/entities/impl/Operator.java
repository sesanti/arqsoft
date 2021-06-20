/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Component;

/**
 *
 * @author sesan
 */
public class Operator implements Component{
    private String operator;

    public Operator(String  operator){
        this.operator = operator;
    }

    public static Operator getInstance(String operator){
        return new Operator(operator);

    }

}
