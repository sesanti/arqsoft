/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.enties;

import java.util.List;

/**
 *
 * @author sesan
 */
public interface Content {
    
    public Content getContent();
    public void setContent(Content content);
    public Double getAsDouble(); //value
    public String getAsString(); //value or FormulaOrigninalString
    public Value getValue(); //?
    
    public List getComponents();
           
    
}
