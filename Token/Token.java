package Token;

public abstract class Token implements Comparable<Token> {
    private String lexeme;

    public Token(String lexeme) {
        this.lexeme = lexeme;
    }

    // Abstract method to get the token type
    public abstract String getTokenType();

    // Getter for the lexeme
    public String getLexeme() {
        return lexeme;
    }

    // Method to print the token information
    @Override
    public String toString() {
        return "<" + getTokenType() + ", " + lexeme + ">";
    }

    // To allow Tokens to be used in a TreeMap, we need to implement Comparable
    @Override
    public int compareTo(Token other) {
        return this.lexeme.compareTo(other.lexeme);
    }
}
