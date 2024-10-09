/**
 * Abstract class to represent a token in the Tiny Basic language.
 * Each token has a lexeme and a token type.
 * The token type is determined by the subclass of Token.
 */

package Token;

public abstract class Token implements Comparable<Token> {
    private String lexeme;

    /**
     * Constructor for a Token object.
     * @param lexeme
     */
    public Token(String lexeme) {
        this.lexeme = lexeme;
    }

    // Abstract method to get the token type
    /**
     * Abstract method to get the token type.
     * @return
     */
    public abstract String getTokenType();

    // Getter for the lexeme
    /**
     * Method to get the lexeme of the token.
     * @return
     */
    public String getLexeme() {
        return lexeme;
    }

    // Method to print the token information
    /**
     * Method to print the token information.
     * @return A string representation of the token
     */
    @Override
    public String toString() {
        if(getTokenType().equals("")) {
            return "<" + lexeme + ">";
        }
        return "<" + getTokenType() + ", " + lexeme + ">";
    }

    // To allow Tokens to be used in a TreeMap, we need to implement Comparable
    /**
     * Method to compare two tokens based on their lexemes.
     * @param other The other token to compare to
     */
    @Override
    public int compareTo(Token other) {
        return this.lexeme.compareTo(other.lexeme);
    }
}
