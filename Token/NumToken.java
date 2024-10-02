package Token;

public class NumToken extends Token {
    private int value;

    public NumToken(String lexeme, int value) {
        super(lexeme);
        this.value = value;
    }

    @Override
    public String getTokenType() {
        return "NUM";
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "<" + getTokenType() + ", " + getValue() + ">";
    }
}
