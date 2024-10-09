/**
 * This class is a subclass of Token and represents a string token.
 */
package Token;

public class StringToken extends Token {
    
    /**
     * Constructor for a StringToken object.
     * @param lexeme The lexeme of the token
     */
    public StringToken(String lexeme) {
        super(lexeme);
    }

    /**
     * Method to get the token type.
     * @return The token type
     */
    @Override
    public String getTokenType() {
        return "STRING";
    }
}
