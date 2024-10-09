/**
 * This class is used to represent an operator token in the Tiny Basic language.
 */

package Token;

public class OpToken extends Token {
    /**
     * Constructor for an OpToken object.
     * @param lexeme The lexeme of the token
     */
    public OpToken(String lexeme) {
        super(lexeme);
    }

    /**
     * Method to get the token type.
     * @return The token type
     */
    @Override
    public String getTokenType() {
        return "OP";
    }
}
