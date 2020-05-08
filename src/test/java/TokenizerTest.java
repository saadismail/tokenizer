import Model.Symbol;
import Model.Token;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TokenizerTest {

    @Test
    public void programLine() {
        String code = "program checkMyAbility;";
        Tokenizer tokenizer = new Tokenizer();

        tokenizer.tokenize(code);


        List<Token> actualToken = Arrays.asList(

        );
        List<Token> tokenList = tokenizer.getTokenList();
        assertEquals(actualToken, tokenList);

        List<Token> actualSymbols = Arrays.asList(

        );
        List<Symbol> symbols = tokenizer.getSymbolTable();
        assertEquals(actualSymbols, symbols);
    }
}
