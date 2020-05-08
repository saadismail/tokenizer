package Parser;

import Main.Helpers;
import Main.RegexConst;
import Model.Symbol;
import Model.Token;

import java.util.List;
import java.util.regex.Matcher;

import static Main.Helpers.getMatcherStartingIndex;
import static Model.TokenType.KEYWORD;
import static Model.TokenType.SYMBOL;

public class End extends Parser {
    @Override
    public void parse(int lineNumber, String line, List<Token> tokens, List<Symbol> symbols) {
        Matcher matcher = Helpers.getMatcherFromRegex(line, RegexConst.END_LINE);
        while (matcher.find()) {
            tokens.add(new Token(KEYWORD, "end", lineNumber, getMatcherStartingIndex(matcher, 1)));
            if (matcher.group(2) != null && !matcher.group(2).isBlank()) {
                tokens.add(new Token(SYMBOL, ".", lineNumber, getMatcherStartingIndex(matcher, 2)));
            }
        }
    }
}
