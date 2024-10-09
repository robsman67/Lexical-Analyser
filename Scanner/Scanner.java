package Scanner;

import java.io.IOException;
import java.io.Reader;

public class Scanner {
    private Reader reader;
    private int currentChar;
    private int currentLine = 1;
    private int currentColumn = 0;

    // Constructor
    public Scanner(Reader reader) throws IOException {
        this.reader = reader;
        this.currentChar = reader.read(); // Read the first character
    }

    // Method to return the next character without consuming it
    public char peek() {
        return (char) currentChar;
    }

    // Method to return the next character and consume it
    public char get() throws IOException {
        char result = (char) currentChar;
        consume();
        return result;
    }

    // Method to consume the next character
    private void consume() throws IOException {
        if (currentChar == '\n') { // Newline detected
            currentLine++;
            currentColumn = 0;
        } else {
            currentColumn++;
        }

        currentChar = reader.read(); // Read next character
    }

    // Check if there are more characters to read
    public boolean hasMoreCharacters() {
        return currentChar != -1; // -1 indicates end of file
    }

    // Get the current line number
    public int getCurrentLine() {
        return currentLine;
    }

    // Get the current column number
    public int getCurrentColumn() {
        return currentColumn;
    }

// Skip white spaces (without skipping new lines)
    public void skipWhiteSpaces() throws IOException {
    // Consume all whitespace characters except newlines ('\n', '\r')
        while (peek() == ' ' || peek() == '\t') {
            get();  // Consume the space or tab
        }
    }

}
