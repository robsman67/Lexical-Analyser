import java.io.IOException;

import Lexer.Lexer;
import Scanner.Scanner;
import SymbolTable.SymbolTable;
import Token.Token;

import java.io.FileReader;


public class Main {
    public static void main(String[] args) {
        // Input file
        String inputFile = "Test/test1.tb";
        try {
            // Create the Scanner for the .tb input file
            FileReader fileReader = new FileReader(inputFile);
            Scanner scanner = new Scanner(fileReader);

            // Create the Lexer
            Lexer lexer = new Lexer(scanner);

            // Create a Symbol Table (optional for now)
            SymbolTable symbolTable = new SymbolTable();

            // Retrieve tokens and display them
            Token token;
            
            while ((token = lexer.getNextToken()) != null) {
                
                //Don't print REM tokens
                if(!token.getTokenType().equals("REM")){
                    if(token.getTokenType().equals("ID")){
                        symbolTable.addEntry(token, scanner.getCurrentLine(), scanner.getCurrentColumn());
                    }
                    //Print line by line
                    if(token.getTokenType().equals("EOL")){
                        System.out.println();
                    }else{
                        // Print the token to the console
                        System.out.print(token + " ");
                    }
                }
                
            }

            // Close the file reader
            fileReader.close();
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }

    }
}

