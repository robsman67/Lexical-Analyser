/**
 * Represents an entry in the symbol table.
 */

package SymbolTable;

import Token.Token;
import Token.ReservedWordToken;

public class SymbolTableEntry {
    private Token token;
    private int firstOccurenceLine;
    private int firstOccurenceColumn;
    private boolean reservedToken;

    // Constructor for non-reserved tokens
    /**
     * Constructor for a symbol table entry for a regular token.
     * @param token The token to add to the symbol table
     * @param line The line number where the token first occurs
     * @param column The column number where the token first occurs
     */
    public SymbolTableEntry(Token token, int line, int column) {
        this.token = token;
        this.firstOccurenceLine = line;
        this.firstOccurenceColumn = column;
        this.reservedToken = false;
    }

    // Getter methods
    /**
     * Method to get the token for the symbol table entry.
     * @return The token for the symbol table entry
     */
    public Token getToken() {
        return token;
    }

    /**
     * Method to get the line number where the token first occurs.
     * @return The line number where the token first occurs
     */
    public int getFirstOccurrenceLine() {
        return firstOccurenceLine;
    }

    /**
     * Method to get the column number where the token first occurs.
     * @return The column number where the token first occurs
     */
    public int getFirstOccurrenceColumn() {
        return firstOccurenceColumn;
    }

    /**
     * Method to check if the token is a reserved word.
     * @return True if the token is a reserved word, false otherwise
     */
    public boolean isReservedToken() {
        return reservedToken;
    }
}
