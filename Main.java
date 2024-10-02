import java.io.IOException;
import java.io.StringReader;
import Scanner.Scanner;

public class Main {    public static void main(String[] args) throws IOException {
        String sourceCode = 
            "5 LET RE = 0\n" +
            "10 INPUT NUM\n" +
            "20 REM This is a comment\n" +
            "25 REM\n" +
            "30 IF N <= 0 THEN GOTO 99\n";

        Scanner scanner = new Scanner(new StringReader(sourceCode));

        // Example: Read through the characters and print them
        while (scanner.hasMoreCharacters()) {

            char currentCharCheck = scanner.peek();

            //scanner.skipWhiteSpaces(); // Skip over any whitespace first

            if(currentCharCheck == 'R'){
                scanner.skipComment();      // Skip comments if found
            }
            char currentChar = scanner.get();

            // Peek the next characters to detect comments
            System.out.print(currentChar);
        }
    }
}
