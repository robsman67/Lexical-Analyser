package SymbolTable;

import Token.Token;
import Token.ReservedWordToken;

public class SymbolTableEntry {
    private Token token;
    private int firstOccurenceLine;
    private boolean reservedToken;

    // Constructor for non-reserved tokens
    public SymbolTableEntry(Token token, int line ) {
        this.token = token;
        this.firstOccurenceLine = line;
        this.reservedToken = false;
    }

    // Constructor for reserved tokens
    public SymbolTableEntry(ReservedWordToken token) {
        this.token = token;
        this.reservedToken = true;
        this.firstOccurenceLine = -1;
    }

    // Getter methods
    public Token getToken() {
        return token;
    }

    public int getFirstOccurrenceLine() {
        return firstOccurenceLine;
    }


    public boolean isReservedToken() {
        return reservedToken;
    }
}
