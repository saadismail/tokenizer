import Model.Symbol;
import Model.Token;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    String code;

    public void tokenize(String code) {
        this.code = code;
    }

    public List<Token> getTokenList() {
        List<Token> tokens = new ArrayList<>();
        return tokens;
    }

    public List<Symbol> getSymbolTable() {
        List<Symbol> symbols = new ArrayList<>();
        return symbols;
    }
}
