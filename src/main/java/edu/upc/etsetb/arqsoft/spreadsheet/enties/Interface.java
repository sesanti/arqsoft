package edu.upc.etsetb.arqsoft.spreadsheet.enties;

import edu.upc.etsetb.arqsoft.spreadsheet.controller.SpreadsheetController;
import edu.upc.etsetb.arqsoft.spreadsheet.exceptions.BadCoordinateException;

import java.io.IOException;

public interface Interface{
    public   String   showMenu();
    public void editCell(String cell, String content, SpreadsheetController spreadsheetController) throws BadCoordinateException;
    public void newSpreadsheet(SpreadsheetController spreadsheetController);
    public void loadSpreadsheet(String path, SpreadsheetController spreadsheetController) throws BadCoordinateException, IOException;
    public void saveSpreadsheet(String path, SpreadsheetController spreadsheetController) throws IOException;
    public void exit();
}
