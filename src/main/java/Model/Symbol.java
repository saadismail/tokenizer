package Model;

import java.util.Objects;

import static Model.TokenType.DEFAULT;

public class Symbol {
    String identifier;
    TokenType type;
    TokenType variableType;

    public Symbol(TokenType type, String identifier, TokenType variableType) {
        this.identifier = identifier;
        this.type = type;
        this.variableType = variableType;
    }

    public Symbol(TokenType type, String identifier) {
        this.identifier = identifier;
        this.type = type;
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
        return identifier + "," + type.toString() + "," + variableType.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        return Objects.equals(identifier, symbol.identifier) &&
                type == symbol.type && variableType == symbol.variableType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, type, variableType);
    }
}
