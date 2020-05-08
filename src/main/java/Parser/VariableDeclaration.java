package Parser;

import Main.Helpers;
import Main.RegexConst;
import Model.Symbol;
import Model.Token;

import java.util.List;
import java.util.regex.Matcher;

import static Main.Helpers.getMatcherStartingIndex;
import static Model.TokenType.*;
import static Model.TokenType.SYMBOL;

public class VariableDeclaration extends Parser {
    @Override
    public void parse(int lineNumber, String line, List<Token> tokens, List<Symbol> symbols) {
        Matcher matcher = Helpers.getMatcherFromRegex(line, RegexConst.VARIABLE_DECLARATION_LINE);
        while (matcher.find()) {
            tokens.add(new Token(IDENTIFIER, matcher.group(1), lineNumber, getMatcherStartingIndex(matcher, 1)));
            symbols.add(new Symbol(IDENTIFIER, matcher.group(1)));
            tokens.add(new Token(SYMBOL, matcher.group(2), lineNumber, getMatcherStartingIndex(matcher, 2)));
            tokens.add(new Token(KEYWORD, matcher.group(3), lineNumber, getMatcherStartingIndex(matcher, 3)));
            tokens.add(new Token(SYMBOL, matcher.group(4), lineNumber, getMatcherStartingIndex(matcher, 4)));
        }
    }
}
