/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreedsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreedsheet.enties.Cell;
import edu.upc.etsetb.arqsoft.spreedsheet.enties.Content;
import java.util.List;

/**
 *
 * @author sesan
 */
public class CellImpl implements Cell {
    
    private String coordinate;
    private Content content;
    private List<Cell> whoDependsOnMe;
    private List<Cell> iDepend;
    
    
    public CellImpl(){
       content = new Text(); 
    }

    public Content getContent() {
       return this.content;
    }
    
    public String getCoordinate(){
        return this.coordinate;
    }
}
