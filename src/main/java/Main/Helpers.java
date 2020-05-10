package Main;

import Model.Symbol;
import Model.TokenType;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Main.RegexConst.expressionDelimiters;

public class Helpers {
    public static String listToCSV(List<Object> list) {
        StringBuilder stringBuilder = new StringBuilder();

        list.forEach(object -> {
            stringBuilder.append(object.toString());
            stringBuilder.append("\n");
        });

        return stringBuilder.toString();
    }

    public static Matcher getMatcherFromRegex(String line, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(line);
    }

    public static boolean isRegexMatch(String line, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(line).matches();
    }

    public static int getMatcherStartingIndex(Matcher matcher, int groupId) {
        return matcher.start(groupId) + 1;
    }

    public static String initEXPR() {
        String string = String.join("|", expressionDelimiters);
        return String.format("(?<=(%s))|(?=(%s))", string, string);
    }

    public static List<Symbol> getUniqueSymbols(List<Symbol> symbols){

        List<Symbol> symbolList = symbols;
        Set<Symbol> foo = new HashSet<>(symbolList);
        symbolList = new LinkedList<>(foo);

        symbolList.forEach(symbol -> {
            if (symbol.getType() == TokenType.DEFAULT){
                symbols.forEach(_symbol ->{
                    if (symbol.isMatches(_symbol) && _symbol.getType() != TokenType.DEFAULT){
                        symbol.setType(_symbol.getType());
                    }
                });
            }
        });

        return symbolList;
    }

}
