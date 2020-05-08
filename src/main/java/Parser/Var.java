package Parser;

import Main.Helpers;
import Main.RegexConst;
import Model.Symbol;
import Model.Token;

import java.util.List;
import java.util.regex.Matcher;

import static Main.Helpers.getMatcherStartingIndex;
import static Model.TokenType.KEYWORD;

public class Var extends Parser {
    @Override
    public void parse(int lineNumber, String line, List<Token> tokens, List<Symbol> symbols) {
        Matcher matcher = Helpers.getMatcherFromRegex(line, RegexConst.VAR_LINE);
        while (matcher.find()) {
            tokens.add(new Token(KEYWORD, "var", lineNumber, getMatcherStartingIndex(matcher, 1)));
        }
    }
}
