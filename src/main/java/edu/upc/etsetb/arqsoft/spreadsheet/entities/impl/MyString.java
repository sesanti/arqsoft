/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Value;

/**
 *
 * @author sesan
 */
public class MyString implements Value{
    
    private String value;
    public static MyString getInstance(String value){
        return new MyString(value);
    }

    public MyString(String value) {
        this.value=value;

    } 

    public String getValue() {
        return value;
    }
}
