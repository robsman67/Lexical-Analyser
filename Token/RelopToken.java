/**
 * Token for relational operators
 */

package Token;

public class RelopToken extends Token {
    /**
     * Constructor for a RelopToken object.
     * @param lexeme The lexeme of the token
     */
    public RelopToken(String lexeme) {
        super(lexeme);
    }

    /**
     * Method to get the token type.
     * @return The token type
     */
    @Override
    public String getTokenType() {
        return "";
    }
}
