/**
 * This class is responsible for recognizing tokens in the input program.
 * It uses the Scanner class to read characters from the input program and
 * constructs tokens based on the characters read.
 * 
 * The Lexer class recognizes the following tokens:
 * - NUM (numbers)
 * - ID (identifiers)
 * - RELOP (relational operators)
 * - OP (arithmetic operators)
 * - Reserved words (IF, THEN, GOTO, PRINT, LET, INPUT, GOSUB, RETURN, END)
 * - Symbols like assignment (=)
 */

package Lexer;

import Scanner.Scanner;
import Token.*;
import java.io.IOException;

public class Lexer {
    private Scanner scanner;

    // Track the currentLine for error and symbole table    
    /**
     * Create a new Lexer object that reads characters from the given scanner object.
     * @param scanner
     */
    public Lexer(Scanner scanner) {
        this.scanner = scanner;
    }

    // Method to recognize the next token
    /**
     * Get the next token from the input program.
     * By skipping white spaces and comments, the lexer recognizes the next token
     * @return The next token in the input program.
     * @throws IOException 
     */
    public Token getNextToken() throws IOException {

        scanner.skipWhiteSpaces();

        if(scanner.peek() == '\n' || scanner.peek() == '\r'){
            scanner.get();
            return new EOLToken("EOL");
        }

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
        // Recognize quoted strings
        if (currentChar == '"'){
            return recognizeQuote();
        }


        // Unrecognized token -> Throw an error with the line and column number
        throw new RuntimeException("Unrecognized token: " + currentChar + " at line " + scanner.getCurrentLine() + " column " + scanner.getCurrentColumn());
    }

    // Helper method to recognize numbers
    /**
     * Recognize a number token from the input program.
     * @return The number token recognized from the input program.
     * @throws IOException 
     */
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
    /**
     * Recognize an identifier or reserved word token from the input program.
     * @return The identifier or reserved word token recognized from the input program.
     * @throws IOException 
     */
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
            //Skip the rest of the line of the comment
            if(lexeme.equals("REM")){
                while(scanner.peek() != '\n'){
                    scanner.get();
                }
                //Consume the newline
                scanner.get();
                return new CommentToken("REM");                    
            }
            return new ReservedWordToken(lexeme);
        }

        // Otherwise, it's an identifier (ID)

        return new IdToken(lexeme, null); // Pass null for the symbol table entry for now
    }

    // method to recognize quoted strings
    /**
     * Recognize a quoted string token from the input program.
     * @return The quoted string token recognized from the input program.
     * @throws IOException
     */
    private Token recognizeQuote() throws IOException {
        StringBuilder quoteBuilder = new StringBuilder();
        scanner.get(); // Consume the quote
        char currentChar = scanner.peek();

        // Continue reading until the closing quote 
        while (currentChar != '"') {
            quoteBuilder.append(currentChar);
            scanner.get(); // Consume the character
            currentChar = scanner.peek();
            //Error if no closing quote at the end of the line
            if(currentChar == '\n'){
                throw new RuntimeException("No closing quote at line " + scanner.getCurrentLine() + " column " + scanner.getCurrentColumn());
            }
        }
        scanner.get(); // Consume the end quote

        return new StringToken(quoteBuilder.toString());

    }


    // Helper method to recognize relational operators (RELOP)
    /**
     * Recognize a relational operator token from the input program.
     * @return The relational operator token recognized from the input program.
     * @throws IOException
     */
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
    /**
     * Recognize an arithmetic operator token from the input program.
     * @return The arithmetic operator token recognized from the input program.
     * @throws IOException
     */
    private Token recognizeOperator() throws IOException {
        char currentChar = scanner.get(); // Consume the operator
        return new OpToken(String.valueOf(currentChar));
    }

    // Helper method to check if a character is a relational operator
    /**
     * Check if a character is a relational operator.
     * @param ch The character to check.
     * @return
     */
    private boolean isRelationalOperator(char ch) {
        return ch == '<' || ch == '>' || ch == '=';
    }

    // Helper method to check if a character is an arithmetic operator
    /**
     * Check if a character is an arithmetic operator.
     * @param ch The character to check.
     * @return
     */
    private boolean isArithmeticOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Helper method to check if a lexeme is a reserved word
    /**
     * Check if a lexeme is a reserved word.
     * @param lexeme The lexeme to check.
     * @return
     */
    private boolean isReservedWord(String lexeme) {
        return lexeme.equals("IF") || lexeme.equals("THEN") || lexeme.equals("GOTO") || 
               lexeme.equals("PRINT") || lexeme.equals("LET") || lexeme.equals("INPUT") || 
               lexeme.equals("GOSUB") || lexeme.equals("RETURN") || lexeme.equals("END") || 
               lexeme.equals("REM");
    }
}
