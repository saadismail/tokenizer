package Parser;

import Model.Symbol;
import Model.Token;

import java.util.List;

public abstract class Parser {
    public abstract void parse(int lineNumber, String line, List<Token> tokens, List<Symbol> symbols);
}
