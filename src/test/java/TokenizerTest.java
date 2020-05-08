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
            new Symbol("checkMyAbility", IDENTIFIER)
        );
        List<Symbol> symbols = tokenizer.getSymbolTable();
        assertEquals(actualSymbols, symbols);
    }

    @Test
    public void varLine() {
        String code = "var        ";

        tokenizer.tokenize(code);

        List<Token> actualToken = Arrays.asList(
                new Token(KEYWORD, "var", 1, 1)
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
                new Symbol("counter", IDENTIFIER),
                new Symbol("number", IDENTIFIER),
                new Symbol("factorial", IDENTIFIER),
                new Symbol("height", IDENTIFIER),
                new Symbol("width", IDENTIFIER),
                new Symbol("breadth", IDENTIFIER),
                new Symbol("volume", IDENTIFIER)
        );
        List<Symbol> symbols = tokenizer.getSymbolTable();
        assertEquals(actualSymbols, symbols);
    }
}
