import java.io.IOException;

import Lexer.Lexer;
import Scanner.Scanner;
import SymbolTable.SymbolTable;
import Token.Token;

import java.io.FileReader;


public class Main {
    public static void main(String[] args) {
        /*if (args.length == 0) {
            System.out.println("Please provide a .tb input file.");
            return;
        }

        String inputFile = args[0];
*/

        String inputFile = "test1.tb";
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
                // Print the token to the console
                System.out.println(token);
            }

            // Close the file reader
            fileReader.close();
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }
    }
}

