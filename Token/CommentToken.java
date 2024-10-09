/**
 * CommentToken
 */

package Token;

public class CommentToken extends Token {
    /**
     * Constructor for a CommentToken object.
     * @param lexeme The lexeme of the token
     */
    public CommentToken(String lexeme) {
        super(lexeme);
    }

    /**
     * Method to get the token type.
     * @return The token type
     */
    @Override
    public String getTokenType() {
        return "REM";
    }
    
}
