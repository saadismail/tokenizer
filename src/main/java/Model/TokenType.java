package Model;

public enum TokenType {
    KEYWORD("keyword"),
    SYMBOL("symbol"),
    IDENTIFIER("identifier"),
    REAL_CONST("real_const"),
    INTEGER_CONST("integer_const"),
    STRING_CONST("string_const");

    private final String name;

    TokenType(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
