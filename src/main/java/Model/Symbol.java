package Model;

import java.util.Objects;

import static Model.TokenType.DEFAULT;

public class Symbol {
    String identifier;
    TokenType type;

    public Symbol(String identifier, TokenType type) {
        this.identifier = identifier;
        this.type = type;
    }

    public Symbol(String identifier) {
        this.identifier = identifier;
        this.type = DEFAULT;
    }

    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public boolean isMatches(Symbol symbol){
        return symbol.identifier.equals(this.identifier);
    }

    @Override
    public String toString() {
        return identifier + "," + type.toString();
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
