package Parser;

import Main.Helpers;
import Main.RegexConst;

public class ParserFactory {

    static Parser program = new Program();
    static Parser var = new Var();
    static Parser variableDeclaration = new VariableDeclaration();
    static Parser begin = new Begin();
    static Parser end = new End();
    static Parser assignment = new Assignment();

    public static Parser getParser(String line) {
        if (line.startsWith("program")) {
            return program;
        } else if (Helpers.isRegexMatch(line, RegexConst.VAR_LINE)) {
            return var;
        } else if (Helpers.isRegexMatch(line, RegexConst.VARIABLE_DECLARATION_LINE)) {
            return variableDeclaration;
        } else if (Helpers.isRegexMatch(line, RegexConst.BEGIN_LINE)) {
            return begin;
        } else if (Helpers.isRegexMatch(line, RegexConst.END_LINE)) {
            return end;
        } else if (Helpers.isRegexMatch(line, RegexConst.ASSIGNMENT_LINE)) {
            return assignment;
        } else {
            throw new AssertionError(String.format("Can not detect the appropriate type for line = %s, regex = %s", line, RegexConst.ASSIGNMENT_LINE));
        }
    }
}
