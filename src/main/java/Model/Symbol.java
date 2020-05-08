package Model;

import java.util.Objects;

public class Symbol {
    String identifier;
    TokenType type;

    public Symbol(String identifier, TokenType type) {
        this.identifier = identifier;
        this.type = type;
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
        return Objects.equals(identifier, symbol.identifier) &&
                type == symbol.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identifier, type);
    }
}
