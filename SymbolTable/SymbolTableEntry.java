package SymbolTable;

import Token.Token;
import Token.ReservedWordToken;

public class SymbolTableEntry {
    private Token token;
    private int firstOccurenceLine;
    private int firstOccurenceColumn;
    private boolean reservedToken;

    // Constructor for non-reserved tokens
    public SymbolTableEntry(Token token, int line, int column) {
        this.token = token;
        this.firstOccurenceLine = line;
        this.firstOccurenceColumn = column;
        this.reservedToken = false;
    }

    // Constructor for reserved tokens
    public SymbolTableEntry(ReservedWordToken token) {
        this.token = token;
        this.reservedToken = true;
        this.firstOccurenceLine = -1;
        this.firstOccurenceColumn = -1;
    }

    // Getter methods
    public Token getToken() {
        return token;
    }

    public int getFirstOccurrenceLine() {
        return firstOccurenceLine;
    }

    public int getFirstOccurrenceColumn() {
        return firstOccurenceColumn;
    }

    public boolean isReservedToken() {
        return reservedToken;
    }
}
