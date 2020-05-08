import java.util.List;

public class Helpers {
    public static String listToCSV(List<Object> list) {
        StringBuilder stringBuilder = new StringBuilder();

        list.forEach(object -> {
            stringBuilder.append(object.toString());
            stringBuilder.append("\n");
        });

        return stringBuilder.toString();
    }
}
