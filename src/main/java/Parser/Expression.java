package Parser;

import Model.Symbol;
import Model.Token;
import Model.TokenType;

import java.util.Arrays;
import java.util.List;

import static Main.Helpers.isRegexMatch;
import static Main.RegexConst.*;

public class Expression extends Parser {
    @Override
    public void parse(int lineNumber, String line, List<Token> tokens, List<Symbol> symbols) {
        List<String> lexemes = Arrays.asList(line.split(EXPR));

        for (String lexeme: lexemes) {
            if (lexeme.isBlank()) continue;

            if (isRegexMatch(lexeme, KEYWORD)) {
                tokens.add(new Token(TokenType.KEYWORD, lexeme, lineNumber, 0));
            } else if (isRegexMatch(lexeme, SYMBOL)) {
                tokens.add(new Token(TokenType.SYMBOL, lexeme, lineNumber, 0));
            } else if (isRegexMatch(lexeme, REAL_CONST)) {
                tokens.add(new Token(TokenType.REAL_CONST, lexeme, lineNumber, 0));
            } else if (isRegexMatch(lexeme, INTEGER_CONST)) {
                tokens.add(new Token(TokenType.INTEGER_CONST, lexeme, lineNumber, 0));
            } else if (isRegexMatch(lexeme, VARIABLE_NAME)) {
                tokens.add(new Token(TokenType.IDENTIFIER, lexeme, lineNumber, 0));
            } else {
                throw new AssertionError("Lexeme could not be parse from Expression Tokenizer: " + lexeme);
            }
        }
    }
}
