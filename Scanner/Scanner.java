/**
 * Scanner.java
 * Purpose: A simple scanner class that reads characters from a Reader object and provides methods to peek, get, and consume characters.
 * The scanner also keeps track of the current line and column number.
 * 
 * @author Robert Hakobyan
 * @version 1.0 09/10/2023
 */

package Scanner;
import java.io.IOException;
import java.io.Reader;

public class Scanner {
    // Instance variables
    private final Reader reader;
    private int currentChar;
    private int currentLine = 1;
    private int currentColumn = 0;

    // Constructor
    /** 
    * Create a new scanner object that reads characters from the given reader object.
    * @param reader The reader object to read characters from.
    */
    public Scanner(Reader reader) throws IOException {
        this.reader = reader;
        this.currentChar = reader.read(); // Read the first character
    }

    // Method to return the next character without consuming it
    /**
     * Peek at the next character without consuming it.
     * @return The next character in the input stream.
     */
    public char peek() {
        return (char) currentChar;
    }

    // Method to return the next character and consume it
    /**
     * Get the next character and consume it.
     * @return The next character in the input stream.
     * @throws IOException
     */
    public char get() throws IOException {
        char result = (char) currentChar;
        consume();
        return result;
    }

    // Method to consume the next character
    /**
     * Consume the next character.
     * @throws IOException
     */
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
    /**
     * Check if there are more characters to read.
     * @return True if there are more characters to read, false otherwise.
     */
    public boolean hasMoreCharacters() {
        return currentChar != -1; // -1 indicates end of file
    }

    // Get the current line number
    /**
     * Get the current line number.
     * @return The current line number.
     */
    public int getCurrentLine() {
        return currentLine;
    }

    // Get the current column number
    /**
     * Get the current column number.
     * @return The current column number.
     */
    public int getCurrentColumn() {
        return currentColumn;
    }

// Skip white spaces (without skipping new lines)
    /**
     * Skip white spaces (spaces and tabs) without skipping new lines.
     * @throws IOException
     */
    public void skipWhiteSpaces() throws IOException {
    // Consume all whitespace characters except newlines ('\n', '\r')
        while (peek() == ' ' || peek() == '\t') {
            get();
        }
    }

}
