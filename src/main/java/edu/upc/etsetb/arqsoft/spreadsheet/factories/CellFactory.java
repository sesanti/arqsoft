package edu.upc.etsetb.arqsoft.spreadsheet.factories;

import edu.upc.etsetb.arqsoft.spreadsheet.enties.Cell;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Content;
import edu.upc.etsetb.arqsoft.spreadsheet.entities.impl.CellImpl;

import java.util.List;

/**
 *
 * @author sesan
 */
public class CellFactory {
    public static CellImpl getInstance(Content content){

        return CellImpl.getInstance(content);
    }

}