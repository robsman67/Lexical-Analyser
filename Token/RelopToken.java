package Token;

public class RelopToken extends Token {
    public RelopToken(String lexeme) {
        super(lexeme);
    }

    @Override
    public String getTokenType() {
        return "RELOP";
    }
}
