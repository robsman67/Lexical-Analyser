/**
 * SymbolTable.java
 * Class to represent the symbol table for the Tiny Basic interpreter.
 * The symbol table is implemented as a TreeMap with tokens as keys and SymbolTableEntry objects as values.
 */

package SymbolTable;

import java.util.TreeMap;
import Token.Token;

//Don't check for the scope, all variables are global in tiny Basic

public class SymbolTable {
    // TreeMap to store the symbol table entries
    private TreeMap<Token, SymbolTableEntry> symbolTable;

    /**
     * Constructor for the SymbolTable class.
     * Initializes the TreeMap to store the symbol table entries.
     */
    public SymbolTable() {
        // Initialize the TreeMap
        this.symbolTable = new TreeMap<>();
    }

    // Method to add a new entry for a regular token
    /**
     * Method to add a new entry to the symbol table.
     * @param token The token to add to the symbol table
     * @param line The line number where the token first occurs
     * @param column The column number where the token first occurs
     */
    public void addEntry(Token token, int line, int column) {
        // Check if the token is already in the symbol table
        if (!symbolTable.containsKey(token)) {
            SymbolTableEntry entry = new SymbolTableEntry(token, line, column);
            symbolTable.put(token, entry);
        }
    }

    // Method to retrieve an entry by token from the Map
    /**
     * Method to retrieve a symbol table entry by token.
     * @param token The token to retrieve the entry for
     * @return The symbol table entry for the token
     */
    public SymbolTableEntry getEntry(Token token) {
        return symbolTable.get(token);
    }

    // Method to display the contents of the symbol table (for debugging)
    /**
     * Method to print the contents of the symbol table.
     */
    public void printTable() {
        for (Token token : symbolTable.keySet()) {
            SymbolTableEntry entry = symbolTable.get(token);
            System.out.println("Token: " + token.toString() + ", Line: " 
                + entry.getFirstOccurrenceLine());
        }
    }
}
