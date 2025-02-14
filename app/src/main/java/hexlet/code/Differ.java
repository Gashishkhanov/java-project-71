package hexlet.code;

import hexlet.code.formatters.StylishFormatter;

import java.util.*;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        List<DifferEntry> diff = buildDiff(filePath1, filePath2);
        return StylishFormatter.format(diff);
    }

    private static List<DifferEntry> buildDiff(String filePath1, String filePath2) throws Exception {
        Map<String, Object> data1 = Parser.parse(filePath1);
        Map<String, Object> data2 = Parser.parse(filePath2);

        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        List<DifferEntry> diff = new ArrayList<>();
        for (String key : keys) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (data1.containsKey(key) && !data2.containsKey(key)) {
                diff.add(new DifferEntry(key, value1, null, DifferEntry.Status.REMOVED));
            } else if (!data1.containsKey(key) && data2.containsKey(key)) {
                diff.add(new DifferEntry(key, null, value2, DifferEntry.Status.ADDED));
            } else if (!Objects.equals(value1, value2)) {
                diff.add(new DifferEntry(key, value1, value2, DifferEntry.Status.CHANGED));
            } else {
                diff.add(new DifferEntry(key, value1, value2, DifferEntry.Status.UNCHANGED));
            }
        }
        return diff;
    }
}
