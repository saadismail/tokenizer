package Model;

import java.util.Objects;

public class Token {
    TokenType type;
    String lexeme;
    Integer lineNumber;
    Integer position;

    public Token(TokenType type, String lexeme, Integer lineNumber, Integer position) {
        this.type = type;
        this.lexeme = lexeme;
        this.lineNumber = lineNumber;
        this.position = position;
    }

    @Override
    public String toString() {
        return type + "," + lexeme + "," + lineNumber.toString() + "," + position.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(type, token.type) &&
                Objects.equals(lexeme, token.lexeme) &&
                Objects.equals(lineNumber, token.lineNumber) &&
                Objects.equals(position, token.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, lexeme, lineNumber, position);
    }
}
