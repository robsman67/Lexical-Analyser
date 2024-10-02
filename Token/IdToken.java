package Token;

import SymbolTable.SymbolTableEntry;

public class IdToken extends Token {
    private SymbolTableEntry symbolEntry;

    public IdToken(String lexeme, SymbolTableEntry entry) {
        super(lexeme);
        this.symbolEntry = entry;
    }

    @Override
    public String getTokenType() {
        return "ID";
    }

    // Getter for the symbol table entry
    public SymbolTableEntry getSymbolEntry() {
        return symbolEntry;
    }
}
