package Token;

public class CommentToken extends Token {
    public CommentToken(String lexeme) {
        super(lexeme);
    }

    @Override
    public String getTokenType() {
        return "REM";
    }
    
}
