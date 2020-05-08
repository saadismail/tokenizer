import Model.Symbol;
import Model.Token;
import Model.TokenType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Model.TokenType.*;

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

            if (line.startsWith("program")) {
                Pattern pattern = Pattern.compile("(program)\\s+([\\w_][_\\w\\d]*)\\s*(;)");
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    this.tokens.add(new Token(KEYWORD, matcher.group(1), lineNumber, getMatcherStartingIndex(matcher, 1)));

                    this.tokens.add(new Token(IDENTIFIER, matcher.group(2), lineNumber, getMatcherStartingIndex(matcher, 2)));
                    this.symbols.add(new Symbol(matcher.group(2), IDENTIFIER));

                    this.tokens.add(new Token(SYMBOL, matcher.group(3), lineNumber, getMatcherStartingIndex(matcher, 3)));
                }
            }
        }
    }

    private int getMatcherStartingIndex(Matcher matcher, int groupId) {
        return matcher.start(groupId) + 1;
    }

    public List<Token> getTokenList() {
        return this.tokens;
    }

    public List<Symbol> getSymbolTable() {
        return this.symbols;
    }
}
