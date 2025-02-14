package hexlet.code;

import hexlet.code.formatters.Formatter;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        Map<String, Object> data1 = Parser.parse(filePath1);
        Map<String, Object> data2 = Parser.parse(filePath2);

        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        List<DifferEntry> diff = keys.stream()
                .map(key -> {
                    Object oldValue = data1.get(key);
                    Object newValue = data2.get(key);

                    if (!data1.containsKey(key)) {
                        return new DifferEntry(key, newValue, null, DifferEntry.Status.ADDED);
                    } else if (!data2.containsKey(key)) {
                        return new DifferEntry(key, null, oldValue, DifferEntry.Status.REMOVED);
                    } else if (!oldValue.equals(newValue)) {
                        return new DifferEntry(key, newValue, oldValue, DifferEntry.Status.CHANGED);
                    } else {
                        return new DifferEntry(key, newValue, oldValue, DifferEntry.Status.UNCHANGED);
                    }
                })
                .toList();

        return getFormatter(format).format(diff);
    }

    private static Formatter getFormatter(String format) {
        return switch (format.toLowerCase()) {
            case "plain" -> new PlainFormatter();
            case "json" -> new JsonFormatter();
            default -> new StylishFormatter();
        };
    }
}