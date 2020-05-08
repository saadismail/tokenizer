package Main;

import java.util.Arrays;
import java.util.List;

import static Main.Helpers.initEXPR;

public class RegexConst {

    public static final String VARIABLE_NAME = "[\\w_][_\\w\\d]*";

    public static final String INTEGER_CONST = "\\d+";
    public static final String REAL_CONST = "\\d+.\\d+";
    public static final String STRING_CONST = "[\"“].*[\"”]";
    public static final String REL_OP = "\\<>|\\<\\=|>\\=|\\=|\\<|>";
    public static final String OP = "\\+|-|–|\\*|\\/";
    public static final String LOGICAL_OP = "and|or|not";
    public static final String KEYWORD = "program|var|begin|end|integer|real|while|do|if|then|else|repeat|until|readln|write|writeln|div|mod|" + LOGICAL_OP;

    public static final String SYMBOL = "\\(|\\)|;|:\\=|" + REL_OP + "|" + OP;

    public static final List<String> expressionDelimiters = Arrays.asList(
//            ":\\=", ";", "\\s", "\\+", "–", "\\-", "\\/", "\\*", "or", "and", "mod", "div", "not", "true", "false", "\\(", "\\)"
            ":\\=", ";", "\\s", "\\+", "–", "\\-", "\\/", "\\*", "\\(", "\\)"
    );

    public static String EXPR = initEXPR();

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
