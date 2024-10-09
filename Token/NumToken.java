/**
 * This class represents a token of type NUM.
 */

package Token;

public class NumToken extends Token {
    private int value;

    /**
     * Constructor for a NumToken object.
     * @param lexeme The lexeme of the token
     * @param value The value of the token
     */
    public NumToken(String lexeme, int value) {
        super(lexeme);
        this.value = value;
    }

    /**
     * Method to get the token type.
     * @return The token type
     */
    @Override
    public String getTokenType() {
        return "NUM";
    }

    /**
     * Method to get the value of the token.
     * @return The value of the token
     */
    public int getValue() {
        return value;
    }

    /**
     * Method to set the value of the token.
     * @param value The value of the token
     */
    @Override
    public String toString() {
        return "<" + getTokenType() + ", " + getValue() + ">";
    }
}
