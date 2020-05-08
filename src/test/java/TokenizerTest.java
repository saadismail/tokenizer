import Model.Symbol;
import Model.Token;
import Model.TokenType.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Model.TokenType.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TokenizerTest {

    @Test
    public void programLine() {
        String code = "program checkMyAbility;";
        Tokenizer tokenizer = new Tokenizer();

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
}
