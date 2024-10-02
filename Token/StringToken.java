package Token;

public class StringToken extends Token {
    public StringToken(String lexeme) {
        super(lexeme);
    }

    @Override
    public String getTokenType() {
        return "STRING";
    }
}
