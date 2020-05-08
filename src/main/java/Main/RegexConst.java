package Main;

public class RegexConst {

    public static final String VARIABLE_NAME = "[\\w_][_\\w\\d]*";
    public static final String INTEGER_CONST = "\\d+";
    public static final String REAL_CONST = "\\d+.\\d+";
    public static final String STRING_CONST = "[\"“].*[\"”]";
    public static final String REL_OP = "<>|<=|>=|=|<|>";
    public static final String OP = "+|-|*|/";

    public static final String EXPR = "[[" + OP + "]|[" + REL_OP + "]]+";

    private static final String VARIABLE_NAME_OR_INT_CONST_OR_REAL_CONST = VARIABLE_NAME + "|" + INTEGER_CONST + "|" + REAL_CONST;
    private static final String VARIABLE_NAME_OR_STRING_CONST = VARIABLE_NAME + "|" + STRING_CONST;

    public static final String PROGRAM_LINE = "(program)\\s+("+ VARIABLE_NAME +")\\s*(;)";
    public static final String VAR_LINE = "\\s*(var)\\s*";
    public static final String VARIABLE_DECLARATION_LINE = "\\s*(" + VARIABLE_NAME + ")\\s*(:)\\s*(real|integer)\\s*(;)";
    public static final String BEGIN_LINE = "\\s*(begin)\\s*";
    public static final String END_LINE = "\\s*(end)(.)?\\s*";
    public static final String ASSIGNMENT_LINE = "\\s*(" + VARIABLE_NAME + ")\\s*(:=)\\s*(" + VARIABLE_NAME_OR_INT_CONST_OR_REAL_CONST + ")\\s*(;)";
    public static final String READLN_LINE = "\\s*(readln)\\s*(\\()("+VARIABLE_NAME+")\\s*(\\))\\s*(;)";
    public static final String WRITE_LINE = "\\s*(write|writeln)\\s*(\\()("+ VARIABLE_NAME_OR_STRING_CONST +")\\s*(\\))\\s*(;)";
}
