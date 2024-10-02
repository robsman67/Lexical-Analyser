package Token;

public class OpToken extends Token {
    public OpToken(String lexeme) {
        super(lexeme);
    }

    @Override
    public String getTokenType() {
        return "OP";
    }
}
