package Model;

import java.util.Objects;

import static Model.TokenType.DEFAULT;
import static Model.TokenType.IDENTIFIER;

public class Symbol {
    String identifier;
    TokenType type;
    TokenType variableType;

    public Symbol(String identifier, TokenType variableType) {
        this.identifier = identifier;
        this.type = IDENTIFIER;
        this.variableType = variableType;
    }

    public Symbol(String identifier) {
        this.identifier = identifier;
        this.type = IDENTIFIER;
        this.variableType = DEFAULT;
    }

    public TokenType getVariableType() {
        return variableType;
    }

    public void setVariableType(TokenType variableType) {
        this.variableType = variableType;
    }

    public boolean isMatches(Symbol symbol){
        return symbol.identifier.equals(this.identifier) && symbol.type == this.type;
    }

    @Override
    public String toString() {
        return identifier + "," + variableType.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        return Objects.equals(identifier, symbol.identifier) &&
                type == symbol.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, type);
    }
}
