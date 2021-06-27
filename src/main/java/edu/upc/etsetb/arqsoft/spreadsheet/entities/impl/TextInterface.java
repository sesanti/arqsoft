package edu.upc.etsetb.arqsoft.spreadsheet.entities.impl;

import edu.upc.etsetb.arqsoft.spreadsheet.controller.SpreadsheetController;
import edu.upc.etsetb.arqsoft.spreadsheet.enties.Interface;
import edu.upc.etsetb.arqsoft.spreadsheet.exceptions.BadCoordinateException;

import java.io.IOException;
import java.util.Scanner;

public class TextInterface implements Interface {

    public static void main(String args[]) throws BadCoordinateException, IOException {
        SpreadsheetController spreadsheetController = new SpreadsheetController();
        String command;
        TextInterface textInterface = new TextInterface();

        while(true){

            command =  textInterface.showMenu();
            Scanner in = new Scanner(System.in);

            switch(command){

                case "E":
                    System.out.println("Introduce the cell to edit:");
                    String cell = in.nextLine();
                    System.out.println("Introduce the content of the cell");
                    String content = in.nextLine();
                    textInterface.editCell(cell, content,spreadsheetController);
                    break;

                case "C":
                    textInterface.newSpreadsheet(  spreadsheetController);
                    break;

                case "L":
                    System.out.println("Introduce the path of the Spreadsheet:");
                    String pathLoad = in.nextLine();
                    textInterface.loadSpreadsheet(pathLoad, spreadsheetController);
                    break;

                case "S":
                    System.out.println("Introduce the path to save the Spreadsheet:");
                    String pathSave = in.nextLine();
                    textInterface.saveSpreadsheet(pathSave, spreadsheetController);

                    break;
                case "X":
                    textInterface.exit();
                    break;

                default: System.out.println("Invalid command");



            }

            spreadsheetController.printSpreadsheet();

        }


    }

    @Override
    public  String showMenu() {
        String command;
        System.out.println("Create a New Spreadsheet (command C)" +
                    "\nEdit a cell (command E)" +
                    "\n Load Spreadsheet from a file (command L)" +
                    "\n Save the Spreadsheet to a file (command S)" +
                    "\nExit the program (command X)");
        Scanner in = new Scanner(System.in);
        command = in.nextLine();
        return command;
    }

    @Override
    public void editCell(String cell,String content, SpreadsheetController spreadsheetController) throws BadCoordinateException {
        spreadsheetController.editSpreadsheet(cell, content);
    }

    @Override
    public void newSpreadsheet(SpreadsheetController spreadsheetController) {
        spreadsheetController.createNewSpreadsheet();
    }

    @Override
    public void loadSpreadsheet(String path, SpreadsheetController spreadsheetController) throws BadCoordinateException, IOException {
        spreadsheetController.tryToLoad(path);

    }

    @Override
    public void saveSpreadsheet(String path, SpreadsheetController spreadsheetController) throws IOException {

        String name = path.substring(path.lastIndexOf("\\")+1);
        path = path.replace(name,"");

            spreadsheetController.saveSpreadsheetToNewFile(name, path);



    }

    @Override
    public void exit() {
        System.exit(0);

    }
}
