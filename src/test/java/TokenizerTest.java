import Main.Tokenizer;
import Model.Symbol;
import Model.Token;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static Model.TokenType.*;
import static org.junit.Assert.assertEquals;

public class TokenizerTest {

    Tokenizer tokenizer = new Tokenizer();

    @Test
    public void programLine() {
        String code = "program checkMyAbility;";

        tokenizer.tokenize(code);

        List<Token> actualToken = Arrays.asList(
            new Token(KEYWORD, "program", 1, 1),
            new Token(IDENTIFIER, "checkMyAbility", 1, 9),
            new Token(SYMBOL, ";", 1, 23)
        );
        List<Token> tokenList = tokenizer.getTokenList();
        assertEquals(actualToken, tokenList);

        List<Symbol> actualSymbols = Arrays.asList(
            new Symbol("checkMyAbility", STRING_CONST)
        );
        List<Symbol> symbols = tokenizer.getSymbolTable();
        assertEquals(actualSymbols, symbols);
    }

    @Test
    public void varLine() {
        String code = "\tvar        ";

        tokenizer.tokenize(code);

        List<Token> actualToken = Arrays.asList(
                new Token(KEYWORD, "var", 1, 2)
        );
        List<Token> tokenList = tokenizer.getTokenList();
        assertEquals(actualToken, tokenList);

        List<Symbol> actualSymbols = Arrays.asList();
        List<Symbol> symbols = tokenizer.getSymbolTable();
        assertEquals(actualSymbols, symbols);
    }

    @Test
    public void variableDeclarationLine() {
        String code = "\tcounter: integer;\n" +
                "\tnumber: integer;\n" +
                "\tfactorial: integer;\n" +
                "\theight : real;\n" +
                "\twidth : real;\n" +
                "\tbreadth : real;\n" +
                "\tvolume : real;";

        tokenizer.tokenize(code);

        List<Token> actualToken = Arrays.asList(
                new Token(IDENTIFIER, "counter", 1, 2),
                new Token(SYMBOL, ":", 1, 9),
                new Token(KEYWORD, "integer", 1, 11),
                new Token(SYMBOL, ";", 1, 18),

                new Token(IDENTIFIER, "number", 2, 2),
                new Token(SYMBOL, ":", 2, 8),
                new Token(KEYWORD, "integer", 2, 10),
                new Token(SYMBOL, ";", 2, 17),

                new Token(IDENTIFIER, "factorial", 3, 2),
                new Token(SYMBOL, ":", 3, 11),
                new Token(KEYWORD, "integer", 3, 13),
                new Token(SYMBOL, ";", 3, 20),

                new Token(IDENTIFIER, "height", 4, 2),
                new Token(SYMBOL, ":", 4, 9),
                new Token(KEYWORD, "real", 4, 11),
                new Token(SYMBOL, ";", 4, 15),

                new Token(IDENTIFIER, "width", 5, 2),
                new Token(SYMBOL, ":", 5, 8),
                new Token(KEYWORD, "real", 5, 10),
                new Token(SYMBOL, ";", 5, 14),

                new Token(IDENTIFIER, "breadth", 6, 2),
                new Token(SYMBOL, ":", 6, 10),
                new Token(KEYWORD, "real", 6, 12),
                new Token(SYMBOL, ";", 6, 16),

                new Token(IDENTIFIER, "volume", 7, 2),
                new Token(SYMBOL, ":", 7, 9),
                new Token(KEYWORD, "real", 7, 11),
                new Token(SYMBOL, ";", 7, 15)
        );
        List<Token> tokenList = tokenizer.getTokenList();
        assertEquals(actualToken, tokenList);

        List<Symbol> actualSymbols = Arrays.asList(
                new Symbol("counter", INTEGER_CONST),
                new Symbol("number", INTEGER_CONST),
                new Symbol("factorial", INTEGER_CONST),
                new Symbol("height", REAL_CONST),
                new Symbol("width", REAL_CONST),
                new Symbol("breadth", REAL_CONST),
                new Symbol("volume", REAL_CONST)
        );
        List<Symbol> symbols = tokenizer.getSymbolTable();
        assertEquals(actualSymbols, symbols);
    }

    @Test
    public void beginLine() {
        String code = "\tbegin        ";

        tokenizer.tokenize(code);

        List<Token> actualToken = Arrays.asList(
                new Token(KEYWORD, "begin", 1, 2)
        );
        List<Token> tokenList = tokenizer.getTokenList();
        assertEquals(actualToken, tokenList);

        List<Symbol> actualSymbols = Arrays.asList();
        List<Symbol> symbols = tokenizer.getSymbolTable();
        assertEquals(actualSymbols, symbols);
    }

    @Test
    public void endLine() {
        String code = "\tend        ";

        tokenizer.tokenize(code);

        List<Token> actualToken = Arrays.asList(
                new Token(KEYWORD, "end", 1, 2)
        );
        List<Token> tokenList = tokenizer.getTokenList();
        assertEquals(actualToken, tokenList);

        List<Symbol> actualSymbols = Arrays.asList();
        List<Symbol> symbols = tokenizer.getSymbolTable();
        assertEquals(actualSymbols, symbols);
    }

    @Test
    public void endLineWithDot() {
        String code = "\tend.        ";

        tokenizer.tokenize(code);

        List<Token> actualToken = Arrays.asList(
                new Token(KEYWORD, "end", 1, 2),
                new Token(SYMBOL, ".", 1, 5)
        );
        List<Token> tokenList = tokenizer.getTokenList();
        assertEquals(actualToken, tokenList);

        List<Symbol> actualSymbols = Arrays.asList();
        List<Symbol> symbols = tokenizer.getSymbolTable();
        assertEquals(actualSymbols, symbols);
    }

    @Test
    public void assignment() {
        String code = "number := 6;\n" +
                "\tcounter := number;\n" +
                "\theight := 1.0;";

        tokenizer.tokenize(code);

        List<Token> actualToken = Arrays.asList(
                new Token(IDENTIFIER, "number", 1, 1),
                new Token(SYMBOL, ":=", 1, 8),
                new Token(INTEGER_CONST, "6", 1, 11),
                new Token(SYMBOL, ";", 1, 12),

                new Token(IDENTIFIER, "counter", 2, 2),
                new Token(SYMBOL, ":=", 2, 10),
                new Token(IDENTIFIER, "number", 2, 13),
                new Token(SYMBOL, ";", 2, 19),

                new Token(IDENTIFIER, "height", 3, 2),
                new Token(SYMBOL, ":=", 3, 9),
                new Token(REAL_CONST, "1.0", 3, 12),
                new Token(SYMBOL, ";", 3, 15)
        );
        List<Token> tokenList = tokenizer.getTokenList();
        assertEquals(actualToken, tokenList);

        List<Symbol> actualSymbols = Arrays.asList(
                new Symbol("number", INTEGER_CONST),
                new Symbol("counter", DEFAULT),
                new Symbol("number", DEFAULT),
                new Symbol("height", REAL_CONST)
        );
        List<Symbol> symbols = tokenizer.getSymbolTable();
        assertEquals(actualSymbols, symbols);
    }

    @Test
    public void readlnLine() {
        String code = "readln(counter);";

        tokenizer.tokenize(code);

        List<Token> actualToken = Arrays.asList(
                new Token(KEYWORD, "readln", 1, 1),
                new Token(SYMBOL, "(", 1, 7),
                new Token(IDENTIFIER, "counter", 1, 8),
                new Token(SYMBOL, ")", 1, 15),
                new Token(SYMBOL, ";", 1, 16)
        );
        List<Token> tokenList = tokenizer.getTokenList();
        assertEquals(actualToken, tokenList);

        List<Symbol> actualSymbols = Arrays.asList(
                new Symbol("counter", DEFAULT)
        );
        List<Symbol> symbols = tokenizer.getSymbolTable();
        assertEquals(actualSymbols, symbols);
    }

    @Test
    public void writeLine() {
        String code = "write(\"Factorial of \");\n" +
                "write(number);\n" +
                "writeln(“ is ”);";

        tokenizer.tokenize(code);

        List<Token> actualToken = Arrays.asList(
                new Token(KEYWORD, "write", 1, 1),
                new Token(SYMBOL, "(", 1, 6),
                new Token(STRING_CONST, "\"Factorial of \"", 1, 7),
                new Token(SYMBOL, ")", 1, 22),
                new Token(SYMBOL, ";", 1, 23),

                new Token(KEYWORD, "write", 2, 1),
                new Token(SYMBOL, "(", 2, 6),
                new Token(IDENTIFIER, "number", 2, 7),
                new Token(SYMBOL, ")", 2, 13),
                new Token(SYMBOL, ";", 2, 14),

                new Token(KEYWORD, "writeln", 3, 1),
                new Token(SYMBOL, "(", 3, 8),
                new Token(STRING_CONST, "“ is ”", 3, 9),
                new Token(SYMBOL, ")", 3, 15),
                new Token(SYMBOL, ";", 3, 16)
        );
        List<Token> tokenList = tokenizer.getTokenList();
        assertEquals(actualToken, tokenList);

        List<Symbol> actualSymbols = Arrays.asList(
                new Symbol("number", DEFAULT)
        );
        List<Symbol> symbols = tokenizer.getSymbolTable();
        assertEquals(actualSymbols, symbols);
    }

    @Test
    public void whileLineTest() {
        String code = "\twhile counter > 0 do begin\n" +
                "\t\tnumber := number * counter;\n" +
                "\t\tcounter := counter – 1;\n" +
                "\tend\n";
        tokenizer.tokenize(code);

        List<Token> actualToken = Arrays.asList(
                new Token(KEYWORD, "while", 1, 2),
                new Token(IDENTIFIER, "counter", 1, 8),
                new Token(SYMBOL, ">", 1, 16),
                new Token(INTEGER_CONST, "0", 1, 18),
                new Token(KEYWORD, "do", 1, 20),
                new Token(KEYWORD, "begin", 1, 23),

                new Token(IDENTIFIER, "number", 2, 3),
                new Token(SYMBOL, ":=", 2, 10),
                new Token(IDENTIFIER, "number", 2, 13),
                new Token(SYMBOL, "*", 2, 20),
                new Token(IDENTIFIER, "counter", 2, 22),
                new Token(SYMBOL, ";", 2, 29),

                new Token(IDENTIFIER, "counter", 3, 3),
                new Token(SYMBOL, ":=", 3, 11),
                new Token(IDENTIFIER, "counter", 3, 14),
                new Token(SYMBOL, "–", 3, 22),
                new Token(INTEGER_CONST, "1", 3, 24),
                new Token(SYMBOL, ";", 3, 25),

                new Token(KEYWORD, "end", 4, 2)
        );
        List<Token> tokenList = tokenizer.getTokenList();
        assertEquals(actualToken, tokenList);

        List<Symbol> actualSymbols = Arrays.asList(
                new Symbol("counter"),
                new Symbol("number"),
                new Symbol("number"),
                new Symbol("counter"),
                new Symbol("counter"),
                new Symbol("counter")
        );
        List<Symbol> symbols = tokenizer.getSymbolTable();
        assertEquals(actualSymbols, symbols);
    }

    @Test
    public void ifLineTest() {
        String code = "if volume >= 50 or number < 10 then begin\n" +
                "volume := volume / 2;\n" +
                "end\n";
        tokenizer.tokenize(code);

        List<Token> actualToken = Arrays.asList(
                new Token(KEYWORD, "if", 1, 1),
                new Token(IDENTIFIER, "volume", 1, 4),
                new Token(SYMBOL, ">=", 1, 11),
                new Token(INTEGER_CONST, "50", 1, 14),
                new Token(KEYWORD, "or", 1, 17),
                new Token(IDENTIFIER, "number", 1, 20),
                new Token(SYMBOL, "<", 1, 27),
                new Token(INTEGER_CONST, "10", 1, 29),
                new Token(KEYWORD, "then", 1, 32),
                new Token(KEYWORD, "begin", 1, 37),

                new Token(IDENTIFIER, "volume", 2, 1),
                new Token(SYMBOL, ":=", 2, 8),
                new Token(IDENTIFIER, "volume", 2, 11),
                new Token(SYMBOL, "/", 2, 18),
                new Token(INTEGER_CONST, "2", 2, 20),
                new Token(SYMBOL, ";", 2, 21),

                new Token(KEYWORD, "end", 3, 1)
        );
        List<Token> tokenList = tokenizer.getTokenList();
        assertEquals(actualToken, tokenList);

        List<Symbol> actualSymbols = Arrays.asList(
                new Symbol("volume"),
                new Symbol("number"),
                new Symbol("volume"),
                new Symbol("volume")
        );
        List<Symbol> symbols = tokenizer.getSymbolTable();
        assertEquals(actualSymbols, symbols);
    }

    @Test
    public void expLineTest() {
        String code = "\nvolume := height * width * breadth;\n";
        tokenizer.tokenize(code);

        List<Token> actualToken = Arrays.asList(
                new Token(IDENTIFIER, "volume", 2, 1),
                new Token(SYMBOL, ":=", 2, 8),
                new Token(IDENTIFIER, "height", 2, 11),
                new Token(SYMBOL, "*", 2, 18),
                new Token(IDENTIFIER, "width", 2, 20),
                new Token(SYMBOL, "*", 2, 26),
                new Token(IDENTIFIER, "breadth", 2, 28),
                new Token(SYMBOL, ";", 2, 35)
        );
        List<Token> tokenList = tokenizer.getTokenList();
        assertEquals(actualToken, tokenList);

        List<Symbol> actualSymbols = Arrays.asList(
                new Symbol("volume"),
                new Symbol("height"),
                new Symbol("width"),
                new Symbol("breadth")
        );
        List<Symbol> symbols = tokenizer.getSymbolTable();
        assertEquals(actualSymbols, symbols);
    }
}
