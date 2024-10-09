/**
 * This class represents an identifier token in the Tiny Basic language.
 */

package Token;

import SymbolTable.SymbolTableEntry;

public class IdToken extends Token {
    private SymbolTableEntry symbolEntry;

    /**
     * Constructor for an IdToken object.
     * @param lexeme The lexeme of the token
     * @param entry The symbol table entry
     */
    public IdToken(String lexeme, SymbolTableEntry entry) {
        super(lexeme);
        this.symbolEntry = entry;
    }

    /**
     * Method to get the token type.
     * @return The token type
     */
    @Override
    public String getTokenType() {
        return "ID";
    }

    /**
     * Method to get the symbol table entry.
     * @return The symbol table entry
     */
    // Getter for the symbol table entry
    public SymbolTableEntry getSymbolEntry() {
        return symbolEntry;
    }
}
