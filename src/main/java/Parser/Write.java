package Parser;

import Main.Helpers;
import Main.RegexConst;
import Model.Symbol;
import Model.Token;
import Model.TokenType;

import java.util.List;
import java.util.regex.Matcher;

import static Main.Helpers.getMatcherStartingIndex;
import static Main.Helpers.isRegexMatch;
import static Main.RegexConst.VARIABLE_NAME;
import static Model.TokenType.*;
import static Model.TokenType.SYMBOL;

public class Write extends Parser {
    @Override
    public void parse(int lineNumber, String line, List<Token> tokens, List<Symbol> symbols) {
        Matcher matcher = Helpers.getMatcherFromRegex(line, RegexConst.WRITE_LINE);
        while (matcher.find()) {
            tokens.add(new Token(KEYWORD, matcher.group(1), lineNumber, getMatcherStartingIndex(matcher, 1)));
            tokens.add(new Token(SYMBOL, "(", lineNumber, getMatcherStartingIndex(matcher, 2)));

            String secondOperand = matcher.group(3);
            parseOperand(lineNumber, tokens, symbols, matcher, secondOperand);

            tokens.add(new Token(SYMBOL, ")", lineNumber, getMatcherStartingIndex(matcher, 4)));
            tokens.add(new Token(SYMBOL, ";", lineNumber, getMatcherStartingIndex(matcher, 5)));
        }
    }

    private void parseOperand(int lineNumber, List<Token> tokens, List<Symbol> symbols, Matcher matcher, String operand) {
        if (isRegexMatch(operand, RegexConst.STRING_CONST)) {
            tokens.add(new Token(TokenType.STRING_CONST, matcher.group(3), lineNumber, getMatcherStartingIndex(matcher, 3)));
        } else if (isRegexMatch(operand, VARIABLE_NAME)) {
            tokens.add(new Token(IDENTIFIER, matcher.group(3), lineNumber, getMatcherStartingIndex(matcher, 3)));
            symbols.add(new Symbol(IDENTIFIER, matcher.group(3)));
        } else {
            throw new AssertionError("Invalid operand: " + operand);
        }
    }

}
