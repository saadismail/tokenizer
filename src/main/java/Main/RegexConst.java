package Main;

public class RegexConst {

    private static final String VARIABLE_NAME = "[\\w_][_\\w\\d]*";

    public static final String PROGRAM_LINE = "(program)\\s+("+ VARIABLE_NAME +")\\s*(;)";
    public static final String VAR_LINE = "\\s*(var)\\s*";
    public static final String VARIABLE_DECLARATION_LINE = "\\s*(" + VARIABLE_NAME + ")\\s*(:)\\s*(real|integer)\\s*(;)";
}
