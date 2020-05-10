package Model;

import java.util.Objects;

import static Model.TokenType.DEFAULT;

public class Symbol {
    String identifier;
    TokenType variableType;

    public Symbol(String identifier, TokenType variableType) {
        this.identifier = identifier;
        this.variableType = variableType;
    }

    public Symbol(String identifier) {
        this.identifier = identifier;
        this.variableType = DEFAULT;
    }

    public TokenType getVariableType() {
        return variableType;
    }

    public void setVariableType(TokenType variableType) {
        this.variableType = variableType;
    }

    public boolean isMatches(Symbol symbol){
        return symbol.identifier.equals(this.identifier);
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
        return Objects.equals(identifier, symbol.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier);
    }
}
