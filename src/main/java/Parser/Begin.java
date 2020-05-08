package Parser;

import Main.Helpers;
import Main.RegexConst;
import Model.Symbol;
import Model.Token;

import java.util.List;
import java.util.regex.Matcher;

import static Main.Helpers.getMatcherStartingIndex;
import static Model.TokenType.KEYWORD;

public class Begin extends Parser {
    @Override
    public void parse(int lineNumber, String line, List<Token> tokens, List<Symbol> symbols) {
        Matcher matcher = Helpers.getMatcherFromRegex(line, RegexConst.BEGIN_LINE);
        while (matcher.find()) {
            tokens.add(new Token(KEYWORD, "begin", lineNumber, getMatcherStartingIndex(matcher, 1)));
        }
    }
}
