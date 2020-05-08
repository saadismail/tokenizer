package Main;

import java.util.List;
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

}
