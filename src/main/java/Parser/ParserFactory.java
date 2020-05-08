package Parser;

import Main.Helpers;
import Main.RegexConst;

public class ParserFactory {

    public static Parser getParser(String line) {
        if (line.startsWith("program")) {
            return new Program();
        } else if (Helpers.isRegexMatch(line, RegexConst.VAR_LINE)) {
            return new Var();
        } else if (Helpers.isRegexMatch(line, RegexConst.VARIABLE_DECLARATION_LINE)) {
            return new VariableDeclaration();
        } else {
            throw new AssertionError("Can not detect the appropriate type.");
        }
    }
}
