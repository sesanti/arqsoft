/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.arqsoft.spreadsheet.services;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Spreadsheet;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author martacosano
 */
public class SpreadsheetSaver {
    
    //l'usuari decidirà el nom del File
    
  
    public void saveSpreadsheeToExistingFile(Spreadsheet spreadsheet, String path) throws IOException{
        
        
        FileWriter myWriter = new FileWriter(path); //path/filename.txt  
        String [][] matrixSpreadsheet = spreadsheet.getSpreadsheetAsMatrix();
        
        for( int i =1; i <= spreadsheet.getMaxRow(); i++){
            
            for(int j= 1; j <= spreadsheet.getMaxColumn(); j++){
                
                String contentCell = matrixSpreadsheet[i][j];
                if(contentCell != null){
                    myWriter.write(contentCell);
                }
                if (j != spreadsheet.getMaxColumn()){
                   myWriter.write(";"); 
                }
            }
            myWriter.write("\n"); //quan s'acabi els elements d'una fila
        }
        myWriter.close();
        
        System.out.println("Spreadsheet saved in : "+ path);
        
    }
    
    //crea nou arxiu en un path i guarda
    public void createNewFileAndSave(Spreadsheet spreadsheet, String fileName, String directory) throws IOException{
        Path directoryPath = Paths.get(directory);
        if (!Files.exists(directoryPath)  || !directory.endsWith("/")){
            throw new IOException("Path to save the Spreadsheet does not exist");
        }
    
        if (!fileName.matches(".txt")){
            fileName = fileName +".txt";
        }
        String path = directory+ fileName;
        File myObj = new File(path);
        myObj.createNewFile();
        
        saveSpreadsheeToExistingFile(spreadsheet, path);
        
        
    }
    
    
}