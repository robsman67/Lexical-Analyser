/**
 * This class is used to represent reserved words in the Tiny Basic language.
 */

package Token;

public class ReservedWordToken extends Token {
    /**
     * Constructor for a ReservedWordToken object.
     * @param lexeme The lexeme of the token
     */
    public ReservedWordToken(String lexeme) {
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
