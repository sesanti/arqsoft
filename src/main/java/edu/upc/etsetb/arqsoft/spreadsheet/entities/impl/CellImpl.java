/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sesan
 */
public class CellImpl implements Cell, Operand {
    
    private Content content;
    private List<Cell> whoDependsOnMe;
    private List<Cell> iDepend;
   
    
    //getInstance lo llamaremos desde la fábrica
    public static CellImpl getInstance(Content content, List<Cell> whoDependsOnMe, List<Cell> iDepend){ // se puede llamar desde fabrica
      return new CellImpl(content,whoDependsOnMe, iDepend);

    }

    public static CellImpl getInstance(Content content){ // se puede llamar desde fabrica
        return new CellImpl(content);

    }

    protected CellImpl(Content content, List<Cell> whoDependsOnMe, List<Cell> iDepend) {
        this.content = content;
        this.whoDependsOnMe= whoDependsOnMe;
        this.iDepend = iDepend;
                
    }

    protected CellImpl(Content content) {
        this.content = content;
        this.whoDependsOnMe= new ArrayList<>();
        this.iDepend = new ArrayList<>();

    }
 
    public Content getContent() {
       return this.content;
    }

    public Value getValue(){
        return this.content.getValue();
    }

    @Override
    public Double getContentValueAsDouble() {
        return this.content.getAsDouble();
    }

    @Override
    public String getContentValueAsString() {
        return this.content.getAsString();
    }
    
    public void setContent(Content content){
        this.content= content;
        //updateDependencies
    }
    
    public List getwhoDependsOnMe(){
        return this.whoDependsOnMe;
    }
    
    public List getIDepend(){
        return this.iDepend;
    }

    @Override
    public String getValueAsString() {
        return this.content.getAsDouble().toString();
    }

    @Override
    public Double getValueAsDouble() {
       return this.getContentValueAsDouble();
    }

    @Override
    public void add(Component auxComponent) {

    }

}
