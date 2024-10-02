package Token;

import java.lang.ref.WeakReference;

import SymbolTable.SymbolTableEntry;

public class IdentifierToken extends Token {

    private WeakReference<SymbolTableEntry> symboleTablePointer = null;

    public IdentifierToken(String lexeme) {
        // Case insensitive
        super(lexeme.toLowerCase());
    }

    public void setSymboleTableEntry (SymbolTableEntry entry) {
        if(entry == null) {
            throw new IllegalArgumentException("SymboleTableEntry cannot be null");
        }else{
            this.symboleTablePointer = new WeakReference<SymbolTableEntry>(entry);
        }
    }

    @Override
    public String toString() {
        return "IdentifierToken";
    }

    @Override
    public String getTokenType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTokenType'");
    }
}
