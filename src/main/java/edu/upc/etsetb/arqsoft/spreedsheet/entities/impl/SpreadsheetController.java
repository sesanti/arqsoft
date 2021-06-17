/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreedsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreedsheet.enties.Content;

/**
 *
 * @author martacosano
 */
public class SpreadsheetController {
    
    private SpreadSheetImpl spreadsheet;
    
    
    public void createNewSpreadsheet(){
        this.spreadsheet = new SpreadSheetImpl();
        
    
    }
    
    public void editCell(String coordinate, Content content){
        
        /*- MIRAR si la coordenada es correcta. Si no lo es --> exception mala coordenada
          - Crear objeto contenido y asignar a la celda q tiene las coordenadas
                -cómo es este contenido? si es fórmula --> tokenizer, parser ..--> Value
          - fábrica--> crear contenido Formula( string, value, components)
           -llamar a spreadsheet--> setCellContent(coordenada, contenido)
                
        */
        
    }
}
