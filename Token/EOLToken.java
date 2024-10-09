/** 
 * Token class for the EOL token.
*/

package Token;


//We use it in order to print line by line
public class EOLToken extends Token {
    /**
     * Constructor for an EOLToken object.
     * @param lexeme The lexeme of the token
     */
    public EOLToken(String lexeme) {
        super(lexeme);
    }
    
    /**
     * Method to get the token type.
     * @return The token type
     */
    @Override
    public String getTokenType() {
        return "EOL";
    }
}
