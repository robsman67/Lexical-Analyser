package Token;

public class ReservedWordToken extends Token {

    public ReservedWordToken(String lexeme) {
        super(lexeme);
    }

    @Override
    public String getTokenType() {
        return "ReservedWord";
    }
}
