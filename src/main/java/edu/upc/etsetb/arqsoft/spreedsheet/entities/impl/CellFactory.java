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
public class CellFactory {
        public static CellImpl getInstance(Content content, List<Cell> whoDependsOnMe, List<Cell> iDepend){ // se puede llamar desde fabrica
   
        return new CellImpl(content,whoDependsOnMe, iDepend);
    }
    
}
