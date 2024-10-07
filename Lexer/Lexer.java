package Lexer;

import Scanner.Scanner;
import Token.*;
import java.io.IOException;

public class Lexer {
    private Scanner scanner;
    
    public Lexer(Scanner scanner) {
        this.scanner = scanner;
    }

    // Method to recognize the next token
    public Token getNextToken() throws IOException {
        scanner.skipWhiteSpaces();
        //System.out.println(scanner.peek());
        if(scanner.peek() == '\n') {
            scanner.get();
        }
        //scanner.skipComment();

        if (!scanner.hasMoreCharacters()) {
            return null; // End of file
        }

        char currentChar = scanner.peek();

        // Recognize NUM (numbers)
        if (Character.isDigit(currentChar)) {
            return recognizeNumber();
        }

        // Recognize ID (identifiers) or reserved words
        if (Character.isLetter(currentChar)) {
            return recognizeIdentifierOrKeyword();
        }

        // Recognize relational operators (RELOP)
        if (isRelationalOperator(currentChar)) {
            return recognizeRelop();
        }

        // Recognize arithmetic operators (OP)
        if (isArithmeticOperator(currentChar)) {
            return recognizeOperator();
        }

        // Recognize symbols like assignment (=)
        if (currentChar == '=') {
            scanner.get(); // Consume '='
            return new OpToken("=");
        }

        // Unrecognized token, consume and return an error or handle it accordingly
        scanner.get();

        return null; // Return null or a custom error token if needed
    }

    // Helper method to recognize numbers
    private Token recognizeNumber() throws IOException {
        StringBuilder numberBuilder = new StringBuilder();
        char currentChar = scanner.peek();

        while (Character.isDigit(currentChar)) {
            numberBuilder.append(currentChar);
            scanner.get(); // Consume the digit
            currentChar = scanner.peek();
        }

        return new NumToken(numberBuilder.toString(), Integer.parseInt(numberBuilder.toString()));
    }

    // Helper method to recognize identifiers or reserved words
    private Token recognizeIdentifierOrKeyword() throws IOException {
        StringBuilder identifierBuilder = new StringBuilder();
        char currentChar = scanner.peek();

        while (Character.isLetterOrDigit(currentChar)) {
            identifierBuilder.append(currentChar);
            scanner.get(); // Consume the letter/digit
            currentChar = scanner.peek();
        }

        String lexeme = identifierBuilder.toString();

        // Check if the lexeme is a reserved word
        if (isReservedWord(lexeme)) {
            return new ReservedWordToken(lexeme);
        }

        // Otherwise, it's an identifier (ID)
        return new IdToken(lexeme, null); // Pass null for the symbol table entry for now
    }

    // Helper method to recognize relational operators (RELOP)
    private Token recognizeRelop() throws IOException {
        char currentChar = scanner.peek();
        StringBuilder relopBuilder = new StringBuilder();

        relopBuilder.append(currentChar);
        scanner.get(); // Consume the character

        // Handle cases like "<=", ">=", "<>", etc.
        if ((currentChar == '<' || currentChar == '>') && scanner.peek() == '=') {
            relopBuilder.append(scanner.get()); // Consume the '='
        } else if (currentChar == '<' && scanner.peek() == '>') {
            relopBuilder.append(scanner.get()); // Consume the '>'
        }

        return new RelopToken(relopBuilder.toString());
    }

    // Helper method to recognize arithmetic operators (OP)
    private Token recognizeOperator() throws IOException {
        char currentChar = scanner.get(); // Consume the operator
        return new OpToken(String.valueOf(currentChar));
    }

    // Helper method to check if a character is a relational operator
    private boolean isRelationalOperator(char ch) {
        return ch == '<' || ch == '>' || ch == '=';
    }

    // Helper method to check if a character is an arithmetic operator
    private boolean isArithmeticOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Helper method to check if a lexeme is a reserved word
    private boolean isReservedWord(String lexeme) {
        return lexeme.equals("IF") || lexeme.equals("THEN") || lexeme.equals("GOTO") || 
               lexeme.equals("PRINT") || lexeme.equals("LET") || lexeme.equals("INPUT") || 
               lexeme.equals("GOSUB") || lexeme.equals("RETURN") || lexeme.equals("END") || 
               lexeme.equals("REM");
    }
}
