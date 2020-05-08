import Model.Symbol;
import Model.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

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
                parseProgramLine(lineNumber, line);
            } else if (Helpers.isRegexMatch(line, RegexConst.VAR_LINE)) {
                parseVarLine(lineNumber, line);
            } else if (Helpers.isRegexMatch(line, RegexConst.VARIABLE_DECLARATION_LINE)) {
                parseVariableDeclarationLine(lineNumber, line);
            }
        }
    }

    private void parseVariableDeclarationLine(int lineNumber, String line) {
        Matcher matcher = Helpers.getMatcherFromRegex(line, RegexConst.VARIABLE_DECLARATION_LINE);
        while (matcher.find()) {
            this.tokens.add(new Token(IDENTIFIER, matcher.group(1), lineNumber, getMatcherStartingIndex(matcher, 1)));
            this.symbols.add(new Symbol(matcher.group(1), IDENTIFIER));
            this.tokens.add(new Token(SYMBOL, matcher.group(2), lineNumber, getMatcherStartingIndex(matcher, 2)));
            this.tokens.add(new Token(KEYWORD, matcher.group(3), lineNumber, getMatcherStartingIndex(matcher, 3)));
            this.tokens.add(new Token(SYMBOL, matcher.group(4), lineNumber, getMatcherStartingIndex(matcher, 4)));
        }
    }

    private void parseVarLine(int lineNumber, String line) {
        Matcher matcher = Helpers.getMatcherFromRegex(line, RegexConst.VAR_LINE);
        while (matcher.find()) {
            this.tokens.add(new Token(KEYWORD, "var", lineNumber, getMatcherStartingIndex(matcher, 1)));
        }
    }

    private void parseProgramLine(int lineNumber, String line) {
        Matcher matcher = Helpers.getMatcherFromRegex(line, RegexConst.PROGRAM_LINE);
        while (matcher.find()) {
            this.tokens.add(new Token(KEYWORD, matcher.group(1), lineNumber, getMatcherStartingIndex(matcher, 1)));

            this.tokens.add(new Token(IDENTIFIER, matcher.group(2), lineNumber, getMatcherStartingIndex(matcher, 2)));
            this.symbols.add(new Symbol(matcher.group(2), IDENTIFIER));

            this.tokens.add(new Token(SYMBOL, matcher.group(3), lineNumber, getMatcherStartingIndex(matcher, 3)));
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
