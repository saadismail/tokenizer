import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
}
