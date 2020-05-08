package Parser;

import Main.Helpers;
import Main.RegexConst;
import Model.Symbol;
import Model.Token;

import java.util.List;
import java.util.regex.Matcher;

import static Main.Helpers.getMatcherStartingIndex;
import static Model.TokenType.*;

public class Program extends Parser {
    @Override
    public void parse(int lineNumber, String line, List<Token> tokens, List<Symbol> symbols) {
        Matcher matcher = Helpers.getMatcherFromRegex(line, RegexConst.PROGRAM_LINE);
        while (matcher.find()) {
            tokens.add(new Token(KEYWORD, matcher.group(1), lineNumber, getMatcherStartingIndex(matcher, 1)));
            tokens.add(new Token(IDENTIFIER, matcher.group(2), lineNumber, getMatcherStartingIndex(matcher, 2)));
            symbols.add(new Symbol(IDENTIFIER, matcher.group(2), STRING_CONST));
            tokens.add(new Token(SYMBOL, matcher.group(3), lineNumber, getMatcherStartingIndex(matcher, 3)));
        }
    }
}
