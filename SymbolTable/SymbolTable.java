package SymbolTable;

import java.util.TreeMap;
import Token.Token;
import Token.ReservedWordToken;

//Don't check for the scope, all variables are global in tiny Basic

public class SymbolTable {
    // TreeMap to store the symbol table entries
    private TreeMap<Token, SymbolTableEntry> symbolTable;

    public SymbolTable() {
        // Initialize the TreeMap
        this.symbolTable = new TreeMap<>();
    }

    // Method to add a new entry for a regular token
    public void addEntry(Token token, int line) {
        // Check if the token is already in the symbol table
        if (!symbolTable.containsKey(token)) {
            SymbolTableEntry entry = new SymbolTableEntry(token, line);
            symbolTable.put(token, entry);
        }
    }

    // Method to add a reserved token in the Map
    public void addReservedEntry(ReservedWordToken token) {
        // Check if the reserved token is already in the symbol table
        if (!symbolTable.containsKey(token)) {
            SymbolTableEntry entry = new SymbolTableEntry(token);
            symbolTable.put(token, entry);
        }
    }

    // Method to retrieve an entry by token from the Map
    public SymbolTableEntry getEntry(Token token) {
        return symbolTable.get(token);
    }

    // Method to display the contents of the symbol table (for debugging)
    public void printTable() {
        for (Token token : symbolTable.keySet()) {
            SymbolTableEntry entry = symbolTable.get(token);
            System.out.println("Token: " + token.toString() + ", Line: " 
                + entry.getFirstOccurrenceLine());
        }
    }
}
