package Main;

import Model.Symbol;
import Model.Token;
import Parser.Parser;
import Parser.ParserFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tokenizer {
    List<Token> tokens;
    List<Symbol> symbols;

    public void tokenize(String code) {
        this.tokens = new ArrayList<>();
        this.symbols = new ArrayList<>();

        List<String> lines = Arrays.asList(code.split("\n"));

        for (int idx = 0; idx < lines.size(); idx++) {
            int lineNumber = idx + 1;
            String line = lines.get(idx);

            Parser parser = ParserFactory.getParser(line);
            parser.parse(lineNumber, line, this.tokens, this.symbols);
        }
    }

    public List<Token> getTokenList() {
        return this.tokens;
    }

    public List<Symbol> getSymbolTable() {
        return this.symbols;
    }
}
