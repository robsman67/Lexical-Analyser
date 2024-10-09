package Token;


//We use it in order to print line by line
public class EOLToken extends Token {
    public EOLToken(String lexeme) {
        super(lexeme);
    }

    @Override
    public String getTokenType() {
        return "EOL";
    }
}
