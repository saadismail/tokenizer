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
import static Main.RegexConst.*;
import static Model.TokenType.*;
import static Model.TokenType.SYMBOL;

public class Assignment extends Parser {
    @Override
    public void parse(int lineNumber, String line, List<Token> tokens, List<Symbol> symbols) {
        Matcher matcher = Helpers.getMatcherFromRegex(line, ASSIGNMENT_LINE);
        while (matcher.find()) {
            tokens.add(new Token(IDENTIFIER, matcher.group(1), lineNumber, getMatcherStartingIndex(matcher, 1)));
            symbols.add(new Symbol(IDENTIFIER, matcher.group(1)));
            tokens.add(new Token(SYMBOL, ":=", lineNumber, getMatcherStartingIndex(matcher, 2)));

            String secondOperand = matcher.group(3);
            parseForSecondOperand(lineNumber, tokens, symbols, matcher, secondOperand);

            tokens.add(new Token(SYMBOL, ";", lineNumber, getMatcherStartingIndex(matcher, 4)));
        }
    }

    private void parseForSecondOperand(int lineNumber, List<Token> tokens, List<Symbol> symbols, Matcher matcher, String secondOperand) {
        if (isRegexMatch(secondOperand, RegexConst.INTEGER_CONST)) {
            tokens.add(new Token(TokenType.INTEGER_CONST, matcher.group(3), lineNumber, getMatcherStartingIndex(matcher, 3)));
        } else if (isRegexMatch(secondOperand, RegexConst.REAL_CONST)) {
            tokens.add(new Token(TokenType.REAL_CONST, matcher.group(3), lineNumber, getMatcherStartingIndex(matcher, 3)));
        } else if (isRegexMatch(secondOperand, VARIABLE_NAME)) {
            tokens.add(new Token(IDENTIFIER, matcher.group(3), lineNumber, getMatcherStartingIndex(matcher, 3)));
            symbols.add(new Symbol(IDENTIFIER, matcher.group(3)));
        } else {
            throw new AssertionError("Invalid second operand: " + secondOperand);
        }
    }
}
